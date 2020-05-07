package com.company;

import java.util.Properties;

/**
 *  Prevent wrap and cast in application logic
 *  Example of use: Object targetEmail = PropLoader.getValue(appProp, "smtpPort", int.class);
 */
public class PropLoader {
    public static Object getValue(Properties appProp, String name, Class<?> type){

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
//todo pobierz z properties sam text, czy tego nie robic metoda powyzej? zrobilbym kolejna metode ktora zrobilaby to przy uzuciu tej wyzej i tej ponizej
//    public static List<Receiver> getReceiversFromProperties() {
//
////                get z properties
////        return listOfValue
//    }
    //todo podziel tekst i zwroc tablice (potem uzyj tego w mainie/mailserver)
    public static String[] splitListToStringsByComma(String value){
        String tab[];
        tab = value.split(",");
        return tab;
    }

    //todo commit  = napisz ze zrobiles te dwie metody i poprawiles constructor receivera

}
