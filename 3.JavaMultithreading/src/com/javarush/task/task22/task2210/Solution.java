package com.javarush.task.task22.task2210;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/*
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {
        String [] s = getTokens("level22.lesson13.task01", ".");
        for(String ss : s){
            System.out.println(ss);
        }
    }

    public static String[] getTokens(String query, String delimiter) {
        StringTokenizer tokenizer = new StringTokenizer(query, delimiter);
        List<String> list = new ArrayList<>();
        while (tokenizer.hasMoreTokens()){
            String token = tokenizer.nextToken();
            list.add(token);
        }
        String[] tokens = new String[list.size()];
        list.toArray(tokens);
        return tokens;
    }
}
