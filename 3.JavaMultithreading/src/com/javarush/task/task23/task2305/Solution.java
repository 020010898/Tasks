package com.javarush.task.task23.task2305;

/* 
Inner
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {
        Solution[] sol = new Solution[2];
        Solution s = new Solution();
        s.innerClasses[0] = s.new InnerClass();
        s.innerClasses[1] = s.new InnerClass();
        sol[0] = s;
        sol[1] = s;
        return sol;
    }

    public static void main(String[] args) {

    }
}
