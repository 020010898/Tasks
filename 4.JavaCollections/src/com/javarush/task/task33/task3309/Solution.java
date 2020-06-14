package com.javarush.task.task33.task3309;

import com.javarush.task.task33.task3308.Shop;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

/*
Комментарий внутри xml
*/
public class Solution {

    public static String toXmlWithComment( Object obj, String tagName, String comment) {
        StringWriter writer = new StringWriter();
        String result = null;
        try{
            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(obj, writer);

            String xml = writer.toString();

            if(xml.contains(tagName))
                result =xml.replaceAll("<" + tagName + ">", "<!--" + comment + "-->\n" + "<" + tagName + ">");
            else
                result = xml;

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><first><second>some string</second><second>some" +
                " string</second><second><![CDATA[need CDATA because of < and >]]></second><second/></first>";
        System.out.println(toXmlWithComment(new Shop(), "second", "it's a comment"));
    }
}
