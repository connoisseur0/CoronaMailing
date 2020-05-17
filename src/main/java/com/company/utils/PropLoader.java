package com.company.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Properties;

/**
 * Prevent wrap and cast in application logic
 * Example of use: Object targetEmail = PropLoader.getValue(appProp, "smtpPort", int.class);
 */
public class PropLoader {

    public static final String NAME_TXT = "Properties name: ";
    public static final String VALUE_TXT = " Value:";
    private static Logger log = LogManager.getLogger(PropLoader.class);

    public static Object getValue(Properties appProp, String name, Class<?> type) {

        String value = appProp.getProperty(name);
        if (value == null) {
            log.warn(String.format("Null value properties. Name = %s", name));
            throw new IllegalArgumentException("Null value properties: " + name);
        } else if (type == String.class) {
            log.info(String.format("%s %s %s %s", NAME_TXT, name, VALUE_TXT, value));
            return value;
        } else if (type == int.class) {
            log.info(String.format("%s %s %s %s", NAME_TXT, name, VALUE_TXT, Integer.parseInt(value)));
            return Integer.parseInt(value);
        } else if (type == Integer.class) {
            log.info(String.format("%s %s %s %s", NAME_TXT, name, VALUE_TXT, Integer.parseInt(value)));
            return Integer.parseInt(value);
        } else if (type == boolean.class) {
            log.info(String.format("%s %s %s %s", NAME_TXT, name, VALUE_TXT, Boolean.parseBoolean(value)));
            return Boolean.parseBoolean(value);
        } else if (type == float.class) {
            log.info(NAME_TXT + name + VALUE_TXT + Float.parseFloat(value));
            return Float.parseFloat(value);
        } else
            log.warn("Unknown value type.");
            throw new IllegalArgumentException("Unknown value type: " + type.getName());
    }
}
