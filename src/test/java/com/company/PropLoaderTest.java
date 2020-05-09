package com.company;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropLoaderTest {

    @Ignore
    @Test
/**
 * If you want use this test just change expected value and delete @Ignore
 */
    public void load() throws IOException {
        Properties appProp = new Properties();
       FileInputStream in = new FileInputStream("properties.xml");
       appProp.loadFromXML(in);
        Assert.assertEquals("pro1.mail.ovh.net",PropLoader.getValue(appProp, "hostName", String.class));
    }

    @Test
    public void splitListToStringsByComma_FirstElement() {
        String stringsWithColons = "abc,bca,cba";
        String[] tab = PropLoader.splitListToStringsByComma(stringsWithColons);
        Assert.assertEquals("abc",tab[0]);
    }
    @Test
    public void splitListToStringsByComma_LastElement() {
        String stringsWithColons = "abc,bca,cba";
        String[] tab = PropLoader.splitListToStringsByComma(stringsWithColons);
        Assert.assertEquals("cba", tab[2]);
    }
}