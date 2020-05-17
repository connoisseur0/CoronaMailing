package com.company;

import com.company.utils.PropLoader;
import com.company.utils.Utils;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class MailServer {
    private static Logger log = LogManager.getLogger(MailServer.class);
    private String subject;
    private HtmlEmail emailSettings;
    private Properties appProp;

    public MailServer(Properties appProp) throws EmailException, IOException {
        setAppProp(appProp);
        emailSettings = new HtmlEmail();
        emailSettings.setHostName(loadHostName());
        emailSettings.setSmtpPort(loadSmtpPort());
        emailSettings.setStartTLSEnabled(true);
        emailSettings.setAuthenticator(new DefaultAuthenticator(loadServerEmailLogin(), loadServerEmailPassword()));
        emailSettings.setFrom(loadServerEmailLogin());
        log.info("Created new mailServer instance" + emailSettings);
    }

    public void buildMimeMail() throws EmailException {
        getEmailSettings().buildMimeMessage();
        log.info("Building MIME done.");
    }

    public void sendMail() {
        try {
            Utils.checkHostConnection();
            log.info(String.format("Connection %s OK", PropLoader.getValue(appProp, "hostName", String.class)));
        } catch (IOException e) {
            log.error(String.format("Connection %s failed", PropLoader.getValue(appProp, "hostName", String.class)));
        }
        try {
            getEmailSettings().sendMimeMessage();
            log.info("Sended email");
        } catch (EmailException e) {
           log.error("I can not send email. Check your internet connection...");
        }
    }

    public void waiting() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
    }

    public String loadHostName() {
        Object hostName = PropLoader.getValue(getAppProp(), "hostName", String.class);
        return String.valueOf(hostName);
    }

    public int loadSmtpPort() {
        Object smtpPort = PropLoader.getValue(getAppProp(), "smtpPort", Integer.class);
        return (int) smtpPort;
    }


    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public HtmlEmail getEmailSettings() {
        return emailSettings;
    }

    public void setEmailSettings(HtmlEmail emailSettings) {
        this.emailSettings = emailSettings;
    }

    public String loadServerEmailLogin() {
        Object senderEmail = PropLoader.getValue(getAppProp(), "serverEmailLogin", String.class);
        return String.valueOf(senderEmail);
    }

    public String loadServerEmailPassword() {
        Object senderEmailPassword = PropLoader.getValue(getAppProp(), "serverEmailPassword", String.class);
        return String.valueOf(senderEmailPassword);
    }

    public Properties getAppProp() {
        return appProp;
    }

    public void setAppProp(Properties appProp) {
        this.appProp = appProp;
    }

    public void addBccReceivers(List<Receiver> receivers) {
        try {
            for (Receiver r : receivers) {
                getEmailSettings().addBcc(r.getEmail());
                log.info("Added receiver" + r.getEmail());
            }
        } catch (EmailException e) {
            e.printStackTrace();
        }
    }

    public void setMailContent(MailContent content) {
        getEmailSettings().setSubject(content.getMailSubject());
        setMsg(content);
    }

    public void setMsg(MailContent content) {
        try {
            getEmailSettings().setHtmlMsg(content.getMailBody());
        } catch (EmailException e) {
            log.error("No data to build mail body");
        }
    }

}
