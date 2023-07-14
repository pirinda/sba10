/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sba.lib.mail.gmail;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.GmailScopes;
import com.google.api.services.gmail.model.Message;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.List;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.apache.commons.codec.binary.Base64;

/**
 *
 * @author Sergio Flores
 */
public class DGmail {
    
    /** Application name. */
    private static final String APPLICATION_NAME = "Gmail Service";
    /** Global instance of the JSON factory. */
    private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();
    /** Directory to store authorization tokens for this application.  */
    private static final String TOKENS_DIRECTORY = "tokens";
    /** Global instance of the Gmail scopes required. If modifying these scopes, delete your previously saved /tokens folder. */
    private static final List<String> GMAIL_SCOPES = Collections.singletonList(GmailScopes.GMAIL_SEND);
    /** Google Cloud Platform credentials. */
    private static final String GOOGLE_CREDENTIALS_FILE = "/resources/credentials.json";
    
    protected final Gmail moGmailService;
    
    public DGmail() throws IOException, GeneralSecurityException {
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        moGmailService = new Gmail.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                .setApplicationName(APPLICATION_NAME)
                .build();
    }
    
    /**
     * Creates an authorized Credential object.
     * @param HTTP_TRANSPORT The network HTTP Transport.
     * @return An authorized Credential object.
     * @throws IOException If the credentials.json file cannot be found.
     */
    private Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT) throws IOException {
        // load client secrets:
        InputStream in = this.getClass().getResourceAsStream(GOOGLE_CREDENTIALS_FILE);
        if (in == null) {
            throw new FileNotFoundException("Resources not found: " + GOOGLE_CREDENTIALS_FILE);
        }
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));
        
        // build flow and trigger user authorization request:
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, GMAIL_SCOPES)
                .setDataStoreFactory(new FileDataStoreFactory(new File(TOKENS_DIRECTORY)))
                .setAccessType("offline")
                .build();
        LocalServerReceiver receiver = new LocalServerReceiver.Builder()
                .setPort(8888)
                .build();
        Credential credential = new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
        
        //returns an authorized Credential object:
        return credential;
    }
    
    private Message createMessage(final MimeMessage mimeMessage) throws IOException, MessagingException {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        mimeMessage.writeTo(buffer);
        byte[] bytes = buffer.toByteArray();
        String messageBase64 = Base64.encodeBase64URLSafeString(bytes);
        Message message = new Message();
        message.setRaw(messageBase64);
        return message;
    }
    
    public void sendMessage(final MimeMessage mimeMessage) throws IOException, MessagingException {
        Message message = createMessage(mimeMessage);
        message = moGmailService.users().messages().send("me", message).execute();
        
        System.out.println("Message ID: " + message.getId());
        System.out.println(message.toPrettyString());
    }
}
