/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sba.lib.mail;

import java.util.Properties;
import javax.mail.Session;

/**
 *
 * @author Sergio Flores
 */
public class DMailSender {

    protected String msHost;
    protected String msPort;
    protected String msProtocol;
    protected boolean mbCommandStartTls;
    protected boolean mbCommandAuth;
    protected String msMailUser;
    protected String msMailPassword;
    protected String msMailFrom;
    protected Session moSession;

    public DMailSender(String host, String port, String protocol, String mailUser, String mailPassword, String mailFrom) {
        this(host, port, protocol, false, false, mailUser, mailPassword, mailFrom);
    }

    public DMailSender(String host, String port, String protocol, boolean startTls, boolean auth, String mailUser, String mailPassword, String mailFrom) {
        msHost = host;
        msPort = port;
        msProtocol = protocol;
        mbCommandStartTls = startTls;
        mbCommandAuth = auth;
        msMailUser = mailUser;
        msMailPassword = mailPassword;
        msMailFrom = mailFrom;
        moSession = createSession();
    }

    public void setHost(String s) { msHost = s; }
    public void setPort(String s) { msPort = s; }
    public void setProtocol(String s) { msProtocol = s; }
    public void setMailUser(String s) { msMailUser = s; }
    public void setMailPassword(String s) { msMailPassword = s; }
    public void setMailFrom(String s) { msMailFrom = s; }

    public String getHost() { return msHost; }
    public String getPort() { return msPort; }
    public String getProtocol() { return msProtocol; }
    public String getMailUser() { return msMailUser; }
    public String getMailPassword() { return msMailPassword; }
    public String getMailFrom() { return msMailFrom; }
    public Session getSession() { return moSession; }

    public Session createSession() {
        Properties props = new Properties();

        props.setProperty("mail.smtp.host", msHost);
        props.setProperty("mail.smtp.starttls.enable", "" + mbCommandStartTls);
        props.setProperty("mail.smtp.port", msPort);
        props.setProperty("mail.transport.protocol", msProtocol);
        props.setProperty("mail.smtp.user", msMailUser);
        props.setProperty("mail.smtp.from", msMailFrom);
        props.setProperty("mail.smtp.auth", "" + mbCommandAuth);
        
        // It seems that these prpoerties apply only to Gmail (sflores, 2015-12-11):
        
        props.setProperty("mail.smtp.socketFactory.port", msPort);        
        props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        return Session.getInstance(props);
    }
}
