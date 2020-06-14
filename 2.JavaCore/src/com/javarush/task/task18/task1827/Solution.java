package com.javarush.task.task18.task1827;

import java.io.*;
/* 
Прайсы
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();
        int id, max = 0;

        if (args.length != 0)
            switch (args[0]) {
                case "-c": {
                    try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
                        while (reader.ready()) {
                            id = Integer.parseInt(reader.readLine().substring(0, 8).trim());
                            if (id > max) {
                                max = id;
                            }
                        }
                        reader.close();

                    }
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {

                        writer.newLine();
                        writer.write(String.format("%-8d%-30.30s%-8.8s%-4.4s", max+1, args[1], args[2], args[3]));
                        writer.close();
                    }
                }
            }
    }
}
