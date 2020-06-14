package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MM yyyy", Locale.ENGLISH);
        String[] str;
        String name = "";
        String birthday = "";

        while (reader.ready()) {
            str = reader.readLine().split(" ");
            int len = str.length;
            birthday = str[len-3] + " " + str[len-2] + " " + str[len-1];
            if(len == 6){
                name = str[0] + " " + str[1] + " " + str[2];
            }
            else if ( len == 5){
                name = str[0] + " " + str[1];
            }
            else if (len == 4){
                name = str[0];
            }
            PEOPLE.add(new Person(name,simpleDateFormat.parse(birthday)));
        }
        reader.close();
    }
}

