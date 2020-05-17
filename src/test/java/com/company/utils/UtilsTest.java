package com.company.utils;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Properties;

public class UtilsTest {

    @Test
    public void splitSemicolon() {
        String splitSemicolon = "name@example.com,Steve;name2@example.com,Bill;name3@example.com,John";
        Utils utils = new Utils();
        String[] tab = utils.splitSemicolon(splitSemicolon);
        Assert.assertEquals("name@example.com,Steve", tab[0]);
    }

    @Test
    public void splitSemicolon_LastElement() {
        String splitSemicolon = "name@example.com,Steve;name2@example.com,Bill;name3@example.com,John";
        Utils utils = new Utils();
        String[] tab = utils.splitSemicolon(splitSemicolon);
        Assert.assertEquals("name3@example.com,John", tab[2]);
    }

    @Test
    public void splitByComma_FirstElement() {
        String stringsWithComma = "name@example.com,Steve";
        Utils utils = new Utils();
        String[] tab = utils.splitByComma(stringsWithComma);
        Assert.assertEquals("name@example.com", tab[0]);
    }

    @Test
    public void splitByComma_LastElement() {
        String stringsWithComma = "name@example.com,Steve";
        Utils utils = new Utils();
        String[] tab = utils.splitByComma(stringsWithComma);
        Assert.assertEquals("Steve", tab[1]);
    }

    @Test
    public void checking_internet_connection() {
       Properties appProp = Utils.getPropertiesXml();

        try {
            URL url = new URL("https://pro1.mail.ovh.net");
            URLConnection connection = url.openConnection();
            connection.connect();
            System.out.println(String.format("Connection  %s succesfull", PropLoader.getValue(appProp, "hostName", String.class)));
        } catch (IOException e) {
            System.out.println(String.format("Connection  %s failed", PropLoader.getValue(appProp, "hostName", String.class)));
            e.printStackTrace();
        }
    }
    @Test
    public void createHttpsUrl(){
        String siteName = "google.com";
        StringBuilder url = new StringBuilder();
        url.append("https://");
        url.append(siteName);
        Assert.assertEquals("https://google.com", url.toString());
    }


}