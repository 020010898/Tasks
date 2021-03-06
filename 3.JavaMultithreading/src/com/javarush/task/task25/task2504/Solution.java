package com.javarush.task.task25.task2504;

/* 
Switch для нитей
*/
public class Solution {
    public static void processThreads(Thread... threads) {
        Thread.State state;
        for(Thread thread : threads){
            state = thread.getState();
            switch (state){
                case NEW: thread.start();
                    break;
                case WAITING: thread.interrupt();
                    break;
                case TIMED_WAITING: thread.interrupt();
                    break;
                case BLOCKED: thread.interrupt();
                    break;
                case RUNNABLE: thread.isInterrupted();
                    break;
                case TERMINATED:
                    System.out.println(thread.getPriority());
                    break;
            }
        }
    }

    public static void main(String[] args)throws Exception {
    }
}
