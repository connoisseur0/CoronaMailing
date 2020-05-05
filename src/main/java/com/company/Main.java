package com.company;

import com.company.model.CountryDetails;

import java.io.FileInputStream;
import java.util.Properties;

public class Main {

    public static final String PROPERTIES_XML = "properties.xml";

    public static void main(String[] args) throws Exception {

        Properties appProp = new Properties();
        FileInputStream in = new FileInputStream(PROPERTIES_XML);
        appProp.loadFromXML(in);

        CountryDetails dataFromApi = new ApiConnector().fetchCountryDetailsFromApi();
        MailServer mailServer = new MailServer(appProp);

        mailServer.addBccReceiverToMailingList(new Receiver("example@gmail.com", "Bill"));

        MailContent content = new MailContent();
        content.prepareMailContent(dataFromApi);
        mailServer.setMailContent(content);

        mailServer.buildMimeMail();
        mailServer.sendMail();


    }
}