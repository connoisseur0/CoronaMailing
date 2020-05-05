package com.company;

import java.io.IOException;
import java.util.Properties;

/**
 *  Prevent wrap and cast in application logic
 *  Example of use: Object targetEmail = PropLoader.getValue(appProp, "smtpPort", int.class);
 */
public class PropLoader {
    public static Object getValue(Properties appProp, String name, Class<?> type) throws IOException {

        String value = appProp.getProperty(name);
        if (value == null)
            throw new IllegalArgumentException("Null value properties: " + name);
        if (type == String.class)
            return value;
        if (type == int.class)
            return Integer.parseInt(value);
        if (type == Integer.class)
            return Integer.parseInt(value);
        if (type == boolean.class)
            return Boolean.parseBoolean(value);
        if (type == float.class)
            return  Float.parseFloat(value);
        throw new IllegalArgumentException("Unknown value type: " + type.getName());
}

}
