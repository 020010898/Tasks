package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        Map<String, Double> map = new TreeMap<>();
        while(reader.ready()){
            String line = reader.readLine();
            String [] str = line.split(" ");
            Double value = 1.0;
            if(map.containsKey(str[0])){
                value = map.get(str[0]);
                map.put(str[0],Double.parseDouble(str[1]) + value);
            }else {
                map.put(str[0],Double.parseDouble(str[1]));
            }
        }
        reader.close();
        for(String key : map.keySet()){
            System.out.println(key + " " + map.get(key));
        }
    }
}
