package com.javarush.task.task32.task3202;


import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* 
Читаем из потока
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("a:/1.txt"));
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {
        if (is == null) {
            StringWriter sw =  new StringWriter();
            sw.write("");
            return sw;
        }
            StringBuilder textBuilder = new StringBuilder();
            try (Reader reader = new BufferedReader(
                    new InputStreamReader(is, Charset.forName(StandardCharsets.UTF_8.name())))) {
                int c = 0;
                while ((c = reader.read()) != -1) {
                    textBuilder.append((char) c);
                }
            }
            StringWriter sw = new StringWriter();
            sw.write(textBuilder.toString());

            return sw;
        }
}