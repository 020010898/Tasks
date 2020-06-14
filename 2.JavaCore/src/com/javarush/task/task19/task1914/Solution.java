package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args)
    {
        PrintStream ps = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps2 = new PrintStream(baos);
        System.setOut(ps2);

        testString.printSomething();
        System.setOut(ps);

        String result = baos.toString();
        int answer = 0;
        String[] strArr = result.split("\\s");
        switch (strArr[1]){
            case "+":
                answer = Integer.parseInt(strArr[0]) + Integer.parseInt(strArr[2]);
                break;
            case "-":
                answer = Integer.parseInt(strArr[0]) - Integer.parseInt(strArr[2]);
                break;
            case "*":
                answer = Integer.parseInt(strArr[0]) * Integer.parseInt(strArr[2]);
                break;
        }

        String str = result.replaceAll(System.lineSeparator(), String.valueOf(answer));
        System.out.print(str);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

