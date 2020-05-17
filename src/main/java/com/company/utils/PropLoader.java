package com.company;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Properties;

/**
 *  Prevent wrap and cast in application logic
 *  Example of use: Object targetEmail = PropLoader.getValue(appProp, "smtpPort", int.class);
 */
public class PropLoader {

    public static final String NAME_TXT = "Name of value: ";
    public static final String VALUE_TXT = " Value:";
    private static Logger log = LogManager.getLogger(PropLoader.class);
    public static Object getValue(Properties appProp, String name, Class<?> type){

        String value = appProp.getProperty(name);
        if (value == null)
            throw new IllegalArgumentException("Null value properties: " + name);
            log.info("Null value properties. Name = " + name);
        if (type == String.class)
            return value;
            log.info(NAME_TXT + name + VALUE_TXT + value);
        if (type == int.class)
            return Integer.parseInt(value);
            log.info(NAME_TXT + name + VALUE_TXT + Integer.parseInt(value));
        if (type == Integer.class)
            return Integer.parseInt(value);
            log.info(NAME_TXT + name + VALUE_TXT +Integer.parseInt(value));
        if (type == boolean.class)
            return Boolean.parseBoolean(value);
            log.info(NAME_TXT + name + VALUE_TXT + Boolean.parseBoolean(value));
        if (type == float.class)
            return  Float.parseFloat(value);
            log.info(NAME_TXT + name + VALUE_TXT + Float.parseFloat(value));
        throw new IllegalArgumentException("Unknown value type: " + type.getName());
}

//    public static List<Receiver> getReceiversFromProperties(Properties appProp, String name, Class<?> type) {
////    PropLoader.getValue(appProp, name, Class<?> type);
//////                get z properties
//////        return listOfValue

    //todo podziel tekst i zwroc tablice (potem uzyj tego w mainie/mailserver)
    public static String[] splitListToStringsByComma(String value){
        String tab[];
        tab = value.split(",");
        return tab;
    }
}
