/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sba.lib.mail.gmail;

import java.io.File;
import java.util.ArrayList;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author Sergio Flores
 */
public class DMessage {

    protected String msFrom;
    protected String msSubject;
    protected String msBodyText;
    protected String msContentType;
    protected ArrayList<String> maToRecipients;
    protected ArrayList<String> maCcRecipients;
    protected ArrayList<String> maBccRecipients;
    protected ArrayList<File> maAttachments;

    /**
     * Create a new email message.
     *
     * @param from Email sender
     * @param subject Email subject.
     * @param bodyText Email body text.
     * @param contentType Email content type (constants defined in class
     * SMailConsts).
     * @param toRecipients Email list of TO recipients.
     */
    public DMessage(final String from, final String subject, final String bodyText, final String contentType, final ArrayList<String> toRecipients) {
        this(from, subject, bodyText, contentType, toRecipients, new ArrayList<>(), new ArrayList<>());
    }

    /**
     * Create a new email message.
     *
     * @param from Email sender
     * @param subject Email subject.
     * @param bodyText Email body text.
     * @param contentType Email content type (constants defined in class
     * SMailConsts).
     * @param toRecipients Email list of TO recipients.
     * @param ccRecipients Email list of CC recipients.
     */
    public DMessage(final String from, final String subject, final String bodyText, final String contentType, final ArrayList<String> toRecipients, final ArrayList<String> ccRecipients) {
        this(from, subject, bodyText, contentType, toRecipients, ccRecipients, new ArrayList<>());
    }

    /**
     * Create a new email message.
     *
     * @param from Email sender
     * @param subject Email subject.
     * @param bodyText Email body text.
     * @param contentType Email content type (constants defined in class
     * SMailConsts).
     * @param toRecipients Email list of TO recipients.
     * @param ccRecipients Email list of CC recipients.
     * @param bccRecipients Email list of CC recipients.
     */
    public DMessage(final String from, final String subject, final String bodyText, final String contentType, final ArrayList<String> toRecipients, final ArrayList<String> ccRecipients, final ArrayList<String> bccRecipients) {
        msFrom = from;
        msSubject = subject;
        msBodyText = bodyText;
        msContentType = contentType;
        maToRecipients = new ArrayList<>(toRecipients);
        maCcRecipients = new ArrayList<>(ccRecipients);
        maBccRecipients = new ArrayList<>(bccRecipients);
        maAttachments = new ArrayList<>();
    }

    public String getFrom() {
        return msFrom;
    }

    public String getSubject() {
        return msSubject;
    }

    public String getBodyText() {
        return msBodyText;
    }

    public String getContentType() {
        return msContentType;
    }

    public ArrayList<String> getToRecipients() {
        return maToRecipients;
    }

    public ArrayList<String> getCcRecipients() {
        return maCcRecipients;
    }

    public ArrayList<String> getBccRecipients() {
        return maBccRecipients;
    }

    public ArrayList<File> getAttachments() {
        return maAttachments;
    }
    
    public MimeMessage createMimeMessage() throws MessagingException, Exception {
        if (maToRecipients.isEmpty()) {
            throw new Exception("No hay destinatarios para el mail.");
        }
        
        // MIME message:
        
        Properties properties = new Properties();
        Session session = Session.getDefaultInstance(properties, null);
        
        MimeMessage mimeMessage = new MimeMessage(session);
        mimeMessage.setFrom(new InternetAddress(msFrom));
        mimeMessage.setSubject(msSubject);
        
        // MIME message recipients:
        
        for (String to : maToRecipients) {
            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
        }
        
        for (String cc : maCcRecipients) {
            mimeMessage.addRecipient(Message.RecipientType.CC, new InternetAddress(cc));
        }
        
        for (String bcc : maBccRecipients) {
            mimeMessage.addRecipient(Message.RecipientType.BCC, new InternetAddress(bcc));
        }
        
        // MIME message parts:
        
        MimeMultipart multipart = new MimeMultipart();
        
        // part: body:
        
        MimeBodyPart partBody = new MimeBodyPart();
        
        if (msContentType.isEmpty()) {
            partBody.setText(msBodyText);
        }
        else {
            partBody.setContent(msBodyText, msContentType);
        }
        
        multipart.addBodyPart(partBody);
        
        // part: attachments:
        
        for (File file : maAttachments) {
            MimeBodyPart partAttachment = new MimeBodyPart();
            partAttachment.setDataHandler(new DataHandler(new FileDataSource(file)));
            partAttachment.setFileName(file.getName());
            
            multipart.addBodyPart(partAttachment);
        }
        
        // MIME message:
        
        if (msContentType.isEmpty()) {
            mimeMessage.setContent(multipart);
        }
        else {
            mimeMessage.setContent(multipart, msContentType);
        }
        
        return mimeMessage;
    }
}
