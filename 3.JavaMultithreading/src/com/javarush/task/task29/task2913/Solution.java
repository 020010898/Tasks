package com.javarush.task.task29.task2913;

import java.util.Random;

/* 
Замена рекурсии
*/

public class Solution {
    private static int numberA;
    private static int numberB;

    public static String getAllNumbersBetween(int a, int b) {
        StringBuffer buffer = new StringBuffer();
        if (a > b) {
            for (int i = a; i >= b ; i--) {
                if (i != b){
                    buffer.append(i).append(" ");
                }else {
                    buffer.append(i);
                }
            }
            return buffer.toString();
        } else {
            if (a == b) {
                return Integer.toString(a);
            }
            for (int i = a; i <=b ; i++) {
                if (i != b){
                    buffer.append(i).append(" ");
                }else {
                    buffer.append(i);
                }
            }
            return buffer.toString();
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        numberA = random.nextInt(1000);
        numberB = random.nextInt(1000);
        System.out.println(getAllNumbersBetween(numberA, numberB));
        System.out.println(getAllNumbersBetween(numberB, numberA));
    }
}