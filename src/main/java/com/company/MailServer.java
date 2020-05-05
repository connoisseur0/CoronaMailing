package com.company;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class MailServer {
    private static Logger log = LogManager.getLogger(MailServer.class);
    private String subject;
    private HtmlEmail emailSettings;
    private Properties appProp;
    List<Receiver> listOfReceivers = new ArrayList<Receiver>();

    public MailServer(Properties appProp) throws EmailException, IOException {
        setAppProp(appProp);
        emailSettings = new HtmlEmail();
        emailSettings.setHostName(getHostName());
        emailSettings.setSmtpPort(getSmtpPort());
        emailSettings.setStartTLSEnabled(true);
        emailSettings.setAuthenticator(new DefaultAuthenticator(getServerEmailLogin(), getServerEmailPassword()));
        emailSettings.setFrom(getServerEmailLogin());
        log.info("Created new mailServer instance" + emailSettings);
    }


    public void buildMimeMail() throws EmailException {
        getEmailSettings().buildMimeMessage();
        log.info("Building MIME done.");
    }

    public void appendReceiver(Receiver receiver) {
        listOfReceivers.add(receiver);
        log.info("Added receiver");
    }

    //todo o tutaj dokoncz
    public void sendMail() throws EmailException {
        getEmailSettings().sendMimeMessage();
//        log.info("Sended email to " + receiver.getEmail());
        log.info("Sended email");
    }

    public void waiting() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
    }

    public String getHostName() throws IOException {
        Object hostName = PropLoader.getValue(getAppProp(), "hostName", String.class);
        return String.valueOf(hostName);
    }

    public int getSmtpPort() throws IOException {
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

    public String getServerEmailLogin() throws IOException {
        Object senderEmail = PropLoader.getValue(getAppProp(), "serverEmailLogin", String.class);
        return String.valueOf(senderEmail);
    }

    public String getServerEmailPassword() throws IOException {
        Object senderEmailPassword = PropLoader.getValue(getAppProp(), "serverEmailPassword", String.class);
        return String.valueOf(senderEmailPassword);
    }

    public Properties getAppProp() {
        return appProp;
    }

    public void setAppProp(Properties appProp) {
        this.appProp = appProp;
    }

    public List<Receiver> getListOfReceivers() {
        return listOfReceivers;
    }

    public void setListOfReceivers(List<Receiver> listOfReceivers) {
        this.listOfReceivers = listOfReceivers;
    }

    public void addReceiverToMailingList(Receiver receiver){
        getListOfReceivers().add(receiver);
        try {
            getEmailSettings().addTo(receiver.getEmail());
            log.info("Added receiver" + receiver.getEmail());
        } catch (EmailException e) {
            e.printStackTrace();
        }

    }

    public void addBccReceiverToMailingList(Receiver receiver){
        getListOfReceivers().add(receiver);
        try {
            getEmailSettings().addBcc(receiver.getEmail());
            log.info("Added receiver" + receiver.getEmail());
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
            e.printStackTrace();
        }
    }


    //    public CountryDetails getCountryDetails() {
//        return countryDetails;
//    }
//
//    public void setCountryDetails(CountryDetails countryDetails) {
//        this.countryDetails = countryDetails;
//    }
}
