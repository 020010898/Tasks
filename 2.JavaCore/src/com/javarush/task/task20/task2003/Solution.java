package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap(){
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            FileInputStream fis = new FileInputStream(reader.readLine());
            reader.close();
            load(fis);
        }catch (Exception e){

        }
        //implement this method - реализуйте этот метод
    }

    public void save(OutputStream outputStream) throws Exception {
        Properties propert = new Properties();
        if(!propert.isEmpty()) {
            propert.forEach((k,v) -> properties.put((String) k, (String) v));
        }
            propert.putAll(properties);
            propert.store(outputStream, "");
            outputStream.close();

        //implement this method - реализуйте этот метод
    }

    public void load(InputStream inputStream) throws Exception {
        Properties proper = new Properties();
        proper.load(inputStream);
        proper.forEach((k,v) -> properties.put((String) k, (String) v));
        //implement this method - реализуйте этот метод
    }

    public static void main(String[] args) {

    }
}
