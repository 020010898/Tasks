package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        reader.close();
        List<String> data = new ArrayList<>();

        if (args.length != 0) {
            switch (args[0]) {
                case "-u": {
                    try {
                        BufferedReader reader2 = new BufferedReader(new FileReader(filename));
                        while (reader2.ready())
                        {
                            String line = reader2.readLine();
                            if (line.substring(0, 8).trim().equals(args[1])) {
                                data.add(String.format("%-8s%-30.30s%-8.8s%-4.4s", args[1], args[2], args[3], args[4]));
                            } else {
                                data.add(line);
                            }
                        }

                        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));

                        for (String txt : data) {
                            writer.write(txt);
                            writer.newLine();
                        }
                        writer.close();
                        reader2.close();
                        break;
                    } catch (Exception e1) {
                        System.out.println("ups2");
                    }
                }
                case "-d": {
                    try {
                        BufferedReader reader3 = new BufferedReader(new FileReader(filename));

                        while (reader3.ready())
                        {
                            String str = reader3.readLine();
                            if (str.substring(0, 8).trim().equals(args[1])){
                        }else {
                                data.add(str);
                            }
                        }

                        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
                        for (String txt2 : data) {
                            writer.write(txt2);
                            writer.newLine();
                        }

                        writer.close();
                        reader3.close();
                        break;
                    } catch (Exception e4) {
                        System.out.println("ups2");
                    }
                }
            }
        }
    }
}
