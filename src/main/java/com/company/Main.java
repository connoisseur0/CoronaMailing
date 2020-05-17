package com.company;

import com.company.model.CountryDetails;
import com.company.utils.Utils;

import java.util.Properties;

public class Main {


    public static void main(String[] args) throws Exception {

        Properties appProp = Utils.getPropertiesXml();
        CountryDetails dataFromApi = new ApiConnector().fetchCountryDetailsFromApi();
        MailServer mailServer = new MailServer(appProp);
        mailServer.addBccReceivers(Receiver.createReceiversListFromProperties());
        MailContent content = new MailContent();
        content.prepareMailContent(dataFromApi);
        mailServer.setMailContent(content);
        mailServer.buildMimeMail();
        mailServer.sendMail();
    }


}
