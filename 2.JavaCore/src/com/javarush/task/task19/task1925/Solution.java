package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] lines = line.split(" ");
                for (String words : lines) {
                    if (words.length() > 6)
                        stringBuilder.append(words + ",");
                }
            }
            writer.write(stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length()).toString());
            writer.flush();
        writer.close();
        reader.close();

    }
}

