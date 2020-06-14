package com.javarush.task.task32.task3210;

/* 
Используем RandomAccessFile
*/

import java.io.IOException;
import java.io.RandomAccessFile;

public class Solution {
    public static void main(String... args) throws IOException {

        String fileName = args[0];
        int number = Integer.parseInt(args[1]);
        String text = args[2];


        RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
        int lengthOfTextIn3rdParameter = text.length();
        byte[] fileContent = new byte[lengthOfTextIn3rdParameter];

        raf.seek(number);
        raf.read(fileContent, 0, lengthOfTextIn3rdParameter);

        String textFromByteArray = new String(fileContent);
        if (textFromByteArray.equals(text)) {
            raf.seek(raf.length());
            raf.write("true".getBytes());
        } else {
            raf.seek(raf.length());
            raf.write("false".getBytes());
        }
    }
}
