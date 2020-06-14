package com.javarush.task.task22.task2208;

import java.util.LinkedHashMap;
import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {

    }
    public static String getQuery(Map<String, String> params) {
        StringBuilder builder = new StringBuilder();
         String string = "%s = '%s' and ";
            for(Map.Entry<String, String> map : params.entrySet()){
                if(map.getValue()!=null){
                    builder.append(String.format(string,map.getKey(),map.getValue()));
                }
            }
                return builder.length()==0 ? "" : builder.toString().substring(0,builder.lastIndexOf(" and"));
        }
}
