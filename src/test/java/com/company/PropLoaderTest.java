package com.company;

import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropLoaderTest {

    @Test
    public void load() throws IOException {
//        PropLoader.load("properties.xml").;
//        PropLoader.getValue(PropLoader.load("properties.xml"), "hostName",String.class);
        Properties appProp = new Properties();
       FileInputStream in = new FileInputStream("properties.xml");
       appProp.loadFromXML(in);
        Assert.assertEquals("pro1.mail.ovh.net",PropLoader.getValue(appProp, "hostName", String.class));
    }

}