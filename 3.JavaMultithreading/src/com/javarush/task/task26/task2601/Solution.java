package com.javarush.task.task26.task2601;

import java.lang.reflect.Array;
import java.util.*;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {
    Integer[] a = {13, 8, 15, 5, 17, 14};
    sort(a);
    }

    public static Integer[] sort(Integer[] array) {
        //implement logic here
        Arrays.sort(array);
        int length = array.length;
        int mediana = length % 2 != 0 ? array[length/2] : (int)((array[length/2] + array[length/2-1])/2);

        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Math.abs(o1 - mediana) - Math.abs(o2 - mediana);
            }
        };
        List<Integer> list = new ArrayList<>(Arrays.asList(array));
        Collections.sort(list, comparator);
        Integer[] result = list.toArray(new Integer[array.length]);
        return result;
    }
}
