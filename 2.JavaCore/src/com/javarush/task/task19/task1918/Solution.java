package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args)throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
        reader.close();
        StringBuffer str = new StringBuffer();
        while (fileReader.ready()){
            str.append(fileReader.readLine());
        }
        String line = str.toString().replaceAll(System.lineSeparator(),"");
        if(!line.contains("CDATA")){
            findTags(args[0],line,0);
        }
        fileReader.close();
    }
    private static void findTags(String tag, String x, int q ){
        int tagsQuantity = 0, lastTagsIndex = 0;
        int i = q;
        while (i < (x.length() - tag.length()-1))
        {
            if(x.substring(i,i + tag.length()+1).equals("<" + tag))
            {
                if(tagsQuantity == 0) lastTagsIndex = i;
                tagsQuantity++;
            }
            else if (x.substring(i, i + tag.length() + 2).equals("</" + tag))
            {
                tagsQuantity--;
                if(tagsQuantity == 0)
                {
                    String newString = x.substring(lastTagsIndex, i + tag.length() + 3);
                    System.out.println(newString);
                    findTags(tag, newString, 1);
                }
            }
            i++;
        }
    }
}
