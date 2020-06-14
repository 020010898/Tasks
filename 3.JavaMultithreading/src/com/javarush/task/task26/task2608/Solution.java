package com.javarush.task.task26.task2608;

/* 
Мудрый человек думает раз, прежде чем два раза сказать
*/
public class Solution {
    int var1;
    int var2;
    int var3;
    int var4;

    public Solution(int var1, int var2, int var3, int var4) {
        this.var1 = var1;
        this.var2 = var2;
        this.var3 = var3;
        this.var4 = var4;
    }

    public int getSumOfVar1AndVar2() {
        Solution s1 = Solution.this;
        synchronized (s1) {
            return s1.var1 + s1.var2;
        }
    }

    public int getSumOfVar3AndVar4() {
        Solution s2 = Solution.this;
        synchronized (s2) {
            return s2.var3 + s2.var4;
        }
    }

    public static void main(String[] args) {

    }
}
