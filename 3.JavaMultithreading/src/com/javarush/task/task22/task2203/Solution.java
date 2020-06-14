package com.javarush.task.task22.task2203;

import java.awt.*;

/*
Между табуляциями
*/
public class Solution {
    public static String getPartOfString(String string)throws TooShortStringException {
        String result;
        if (string != null) {
            String[] str = string.split("\t");
            if(str.length<=2){
                throw new TooShortStringException();
            }
            result = String.format("%s", str[1]);
        }
        else {throw new TooShortStringException();}
            return result;
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис\t обучения Java."));
    }
}
