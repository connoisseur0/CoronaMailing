package com.company.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Properties;


public class Utils {
    private static Logger log = LogManager.getLogger(Utils.class);
    public String[] splitByComma(String value){
        String stringValue = String.valueOf(value);
        String tabOfStrings[];
        tabOfStrings = stringValue.split(",");
        return tabOfStrings;
    }
    public String[] splitSemicolon(Object value){
        String stringValue = String.valueOf(value);
        String tabOfStrings[];
        tabOfStrings = stringValue.split(";");
        return tabOfStrings;
    }

    public static Properties getPropertiesXml() {

        final String PROPERTIES_XML = "properties.xml";
        Properties appProp = new Properties();
        FileInputStream in = null;
        try {
            in = new FileInputStream(PROPERTIES_XML);
            appProp.loadFromXML(in);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            log.warn(String.format("Properties file not found %s", PROPERTIES_XML));
        }
         catch (IOException e) {
            log.warn(String.format("Properties file %s found, but detected problem with load XML", PROPERTIES_XML));
            e.printStackTrace();
        }
        return appProp;
    }

    public static void checkHostConnection() throws IOException {
            String hostName = String.valueOf(PropLoader.getValue(getPropertiesXml(),"hostName", String.class));
            URL url = new URL(createHttpsUrl(hostName));
            URLConnection connection = url.openConnection();
            connection.connect();
    }

    private static String createHttpsUrl(String siteName){
        StringBuilder url = new StringBuilder();
        url.append("https://").append(siteName);
        return url.toString();
    }
}
