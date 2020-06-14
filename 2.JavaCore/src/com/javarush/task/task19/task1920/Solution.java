package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        Map<String, Double> map = new TreeMap<>();
        double max = Double.MIN_VALUE;
        while (reader.ready())
        {
            double value;
            String [] str = reader.readLine().split(" ");
            if(map.containsKey(str[0]))
            {
                value = map.get(str[0]);
                map.put(str[0], Double.parseDouble(str[1]) + value);
            }else{
                map.put(str[0], Double.parseDouble(str[1]));
            }
        }
        reader.close();
        for (Map.Entry<String,Double> pair : map.entrySet())
        {
            max = Math.max(max,pair.getValue());
        }
        for (Map.Entry<String,Double> pair : map.entrySet())
        {
            if (pair.getValue().equals(max)) System.out.println(pair.getKey());
        }
    }
}
