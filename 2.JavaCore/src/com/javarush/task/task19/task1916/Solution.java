package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader file1 = new BufferedReader(new FileReader(reader.readLine()));
        BufferedReader file2 = new BufferedReader(new FileReader(reader.readLine()));
        reader.close();
        List<String> firstFile = new ArrayList<>();
        List<String> secondFile = new ArrayList<>();

        while (file1.ready()){
            firstFile.add(file1.readLine());
        }
        while (file2.ready()){
            secondFile.add(file2.readLine());
        }
        file1.close();
        file2.close();
        while (!firstFile.isEmpty() | !secondFile.isEmpty()){
            if(secondFile.isEmpty()){
                lines.add(new LineItem(Type.REMOVED,firstFile.get(0)));
                firstFile.remove(0);
            } else if(firstFile.isEmpty()){
                lines.add(new LineItem(Type.ADDED, secondFile.get(0)));
                secondFile.remove(0);
            } else if(firstFile.get(0).equals(secondFile.get(0))) {
                lines.add(new LineItem(Type.SAME, firstFile.get(0)));
                firstFile.remove(0);
                secondFile.remove(0);
            } else if (firstFile.get(0).equals(secondFile.get(1))){
                lines.add(new LineItem(Type.ADDED, secondFile.get(0)));
                secondFile.remove(0);
            } else {
                lines.add(new LineItem(Type.REMOVED, firstFile.get(0)));
                firstFile.remove(0);
            }
        }
 //           for(LineItem lineItem : lines) { System.out.println(lineItem.type + " " + lineItem.line); }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
