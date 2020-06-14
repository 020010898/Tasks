package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();
    private static String filename;
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
             filename = reader.readLine();
            reader.close();
        }catch(Exception e){
        }
        PrintStream ps = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps2 = new PrintStream(baos);
        System.setOut(ps2);

        testString.printSomething();
        System.setOut(ps);

        String result = baos.toString();
        try {

            FileOutputStream fos = new FileOutputStream(filename);
            fos.write(result.getBytes());
            fos.close();
            } catch (IOException e) {
            System.out.println("Ups : FileNotFoundException");
        }
        System.out.println(result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

