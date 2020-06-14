package com.javarush.task.task20.task2010;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
Как сериализовать что-то свое?
*/
public class Solution {
    public static class Object implements Serializable {
        public String string1;
        public String string2;
    }

    public static transient int stringCount;

    public static void serializeStatic(ObjectOutputStream oos) throws IOException{
        oos.writeObject(Object.class);
    }

    public static class String implements Serializable {
        private final int number;

        public String() {
            number = ++stringCount;
        }

        public void print() {
            System.out.println("string #" + number);
        }
    }

    public static void main(String[] args) {

    }
}
