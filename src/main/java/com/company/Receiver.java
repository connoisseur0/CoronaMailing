package com.company;

import com.company.utils.PropLoader;
import com.company.utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Receiver {
    private String email;
    private String name;

    public Receiver(String email, String name) {
        this.name = name;
        this.email = email;
    }
    /**
     *   Example of passing list of email recaivers
     *     Add example@mail.com,nameOfReceivers and separete them with a semicolon to receiverList key (properties.xml)
     *     <entry key="receiversList">wilamowskiarek@gmail.com,Arek;ponuryrybak@gmail.com,Rybak</entry>
     * @param
     * @return List<Receiver>
     */
    public static  List<Receiver> createReceiversListFromProperties() {
        String[] extractedFieldSet = extractReceiversFieldSetFromProperties(Utils.getPropertiesXml()); //todo get ListFromProperties
        Utils separateValues = new Utils();
        List<Receiver> receiversList = new ArrayList<>();
        for (String set : extractedFieldSet) {
            String[] receiverFieldsAfter = separateValues.splitByComma(set);
            Receiver receiver = new Receiver(receiverFieldsAfter[0], receiverFieldsAfter[1]);
            receiversList.add(receiver);
        }
        return receiversList;
    }

    private static String[] extractReceiversFieldSetFromProperties(Properties prop) {
         Object setsOfReceiversFields = PropLoader.getValue(prop, "receiversList", String.class);
        Utils separateValues = new Utils();
        String[] extractedFieldSet = separateValues.splitSemicolon(setsOfReceiversFields);
        return extractedFieldSet;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
