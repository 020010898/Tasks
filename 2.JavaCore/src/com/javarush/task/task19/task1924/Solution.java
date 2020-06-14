package com.javarush.task.task19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        BufferedReader readFile = new BufferedReader(new FileReader(fileName));
        while (readFile.ready()) {
            String originalLine = readFile.readLine();
            String[] str = originalLine.split(" ");
            for (int i = 0; i < str.length; i++) {
                if (str[i].matches("^\\d*$")) {
                    int u = Integer.parseInt(str[i]);
                    for (Map.Entry<Integer, String> pair : map.entrySet()) {
                        if (pair.getKey() == u) str[i] = map.get(u);
                    }
                }
            }
            String h = "";
            for (int i = 0; i <= str.length - 1; i++) {
                h += str[i] + " ";
            }
            System.out.println(h);
        //    System.out.println(str[str.length - 1]);
        }
        readFile.close();
    }
    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }
}
