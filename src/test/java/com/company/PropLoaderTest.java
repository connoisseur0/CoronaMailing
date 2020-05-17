package com.company;

import com.company.utils.PropLoader;
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
        Assert.assertEquals("pro1.mail.ovh.net", PropLoader.getValue(appProp, "hostName", String.class));
    }


}