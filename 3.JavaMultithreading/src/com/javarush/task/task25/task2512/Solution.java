package com.javarush.task.task25.task2512;

import java.util.Stack;

/*
Живем своим умом
*/
public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
            t.interrupt();
        Stack<Throwable> stack = new Stack<>();
        stack.push(e);
        Throwable throwable = e.getCause();
        while (throwable!=null){
            stack.push(throwable);
            throwable = throwable.getCause();
        }
        while (!stack.isEmpty()){
            Throwable currentException = stack.pop();
            System.out.println(
                    currentException.getClass().getName() + ": " + currentException.getMessage()
            );
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.uncaughtException(new Thread(),
                new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI"))));    }
}
