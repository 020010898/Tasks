package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        reader.close();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
        while (bufferedReader.ready()){
            String originalLine = bufferedReader.readLine();
            String[] line = originalLine.split(" ");
            int same = 0;
            for (int i = 0; i <line.length ; i++) {
                for (int j = words.size()-1; j >=0 ; j--) {
                    if(words.get(j).equals(line[i]))
                    {
                        same++;
                    }
                }
            }
            if(same==2){
                    System.out.println(originalLine);
                same = 0;
            }
        }
        bufferedReader.close();
    }
}
