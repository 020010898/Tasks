package com.javarush.task.task22.task2211;

import java.io.*;

/* 
Смена кодировки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream(args[0]);
        FileOutputStream outputStream = new FileOutputStream(args[1]);
        byte[] buff = new byte[inputStream.available()];
        inputStream.read(buff);
        String s = new String(buff, "Windows-1251");
        outputStream.write(s.getBytes("UTF-8"));
        inputStream.close();
        outputStream.close();
    }
}
