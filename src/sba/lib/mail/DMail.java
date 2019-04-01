/*
 * ToRecipients change this template, choose ToRecipientsols | Templates
 * and open the template in the editor.
 */

package sba.lib.mail;

import java.io.File;
import java.util.ArrayList;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author Sergio Flores
 */
public class DMail {

    protected DMailSender moSender;
    protected String msSubject;
    protected String msBody;
    protected String msContentType;
    protected ArrayList<String> maToRecipients;
    protected ArrayList<String> maCcRecipients;
    protected ArrayList<String> maBccRecipients;
    protected ArrayList<File> maAttachments;

    /**
     * @param sender Mail sender.
     * @param subject Mail subject.
     * @param body Mail body (it is assumed that content type is plain text).
     * @param toRecipients Mail recipients list.
     */
    public DMail(DMailSender sender, String subject, String body, ArrayList<String> toRecipients) {
        this(sender, subject, body, "", toRecipients, new ArrayList<String>(), new ArrayList<String>());
    }

    /**
     * @param sender Mail sender.
     * @param subject Mail subject.
     * @param body Mail body (it is assumed that content type is plain text).
     * @param toRecipients Mail recipients list.
     * @param ccRecipients Mail carbon copy recipients list.
     */
    public DMail(DMailSender sender, String subject, String body, ArrayList<String> toRecipients, ArrayList<String> ccRecipients) {
        this(sender, subject, body, "", toRecipients, ccRecipients, new ArrayList<String>());
    }

    /**
     * @param sender Mail sender.
     * @param subject Mail subject.
     * @param body Mail body (it is assumed that content type is plain text).
     * @param toRecipients Mail recipients list.
     * @param ccRecipients Mail carbon copy recipients list.
     * @param bccRecipients Mail blind carbon copy recipients list.
     */
    public DMail(DMailSender sender, String subject, String body, ArrayList<String> toRecipients, ArrayList<String> ccRecipients, ArrayList<String> bccRecipients) {
        this(sender, subject, body, "", toRecipients, ccRecipients, bccRecipients);
    }

    /**
     * @param sender Mail sender.
     * @param subject Mail subject.
     * @param body Mail body (it is assumed that content type is plain text).
     * @param contentType  Mail content type (Constants of options defined in class sa.lib.mail.SMailConsts).
     * @param toRecipients Mail recipients list.
     * @param ccRecipients Mail carbon copy recipients list.
     * @param bccRecipients Mail blind carbon copy recipients list.
     */
    public DMail(DMailSender sender, String subject, String body, String contentType, ArrayList<String> toRecipients, ArrayList<String> ccRecipients, ArrayList<String> bccRecipients) {
        moSender = sender;
        msSubject = subject;
        msBody = body;
        msContentType = contentType;
        maToRecipients = toRecipients;
        maCcRecipients = ccRecipients;
        maBccRecipients = bccRecipients;
        maAttachments = new ArrayList<File>();
    }

    public void setSender(DMailSender o) { moSender = o; }
    public void setSubject(String s) { msSubject = s; }
    public void setBody(String s) { msBody = s; }
    public void setContentType(String s) { msContentType = s; }

    public DMailSender getSender() { return moSender; }
    public String getSubject() { return msSubject; }
    public String getBody() { return msBody; }
    public String getContentType() { return msContentType; }
    public ArrayList<String> getToRecipients() { return maToRecipients; }
    public ArrayList<String> getCcRecipients() { return maCcRecipients; }
    public ArrayList<String> getBccRecipients() { return maBccRecipients; }
    public ArrayList<File> getAttachments() { return maAttachments; }

    public void send() throws MessagingException {
        BodyPart bodyPart = null;
        MimeMultipart mimeMultipart = null;
        MimeMessage mimeMessage = null;
        Transport transport = null;

        // Attachments:

        mimeMultipart = new MimeMultipart();

        for (int i = 0; i < maAttachments.size(); i++) {
            BodyPart attachment = new MimeBodyPart();

            attachment.setDataHandler(new DataHandler(new FileDataSource(maAttachments.get(i))));
            attachment.setFileName(maAttachments.get(i).getName());

            mimeMultipart.addBodyPart(attachment);
        }

        // Body:

        bodyPart = new MimeBodyPart();

        if (msContentType.isEmpty()) {
            bodyPart.setText(msBody);
        }
        else {
            bodyPart.setContent(msBody, msContentType);
        }

        mimeMultipart.addBodyPart(bodyPart);

        // Message:

        mimeMessage = new MimeMessage(moSender.getSession());
        mimeMessage.setFrom(new InternetAddress(moSender.getMailFrom()));
        mimeMessage.setSubject(msSubject);

        if (msContentType.isEmpty()) {
            mimeMessage.setContent(mimeMultipart);
        }
        else {
            mimeMessage.setContent(mimeMultipart, msContentType);
        }

        for (int i = 0; i < maToRecipients.size(); i++) {
            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress((String) maToRecipients.get(i)));
        }

        for (int i = 0; i < maCcRecipients.size(); i++) {
            mimeMessage.addRecipient(Message.RecipientType.CC, new InternetAddress((String) maCcRecipients.get(i)));
        }

        for (int i = 0; i < maBccRecipients.size(); i++) {
            mimeMessage.addRecipient(Message.RecipientType.BCC, new InternetAddress((String) maBccRecipients.get(i)));
        }

        // Sending:

        transport = moSender.getSession().getTransport(moSender.getProtocol());
        transport.connect(moSender.getMailUser(), moSender.getMailPassword());
        transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
        transport.close();  // allways close the connection
    }
}
