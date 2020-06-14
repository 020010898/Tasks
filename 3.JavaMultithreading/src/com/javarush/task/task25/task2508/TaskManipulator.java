package com.javarush.task.task25.task2508;

public class TaskManipulator implements Runnable, CustomThreadManipulator {
    Thread thread;

    @Override
    public void run() {
        try{
            while (!thread.isInterrupted()) {
                System.out.println(this.thread.getName());
                Thread.sleep(100);
            }
        }catch (InterruptedException ex){
            ex.getMessage();
        }
    }

    @Override
    public void start(String threadName) {
        this.thread = new Thread(this);
        this.thread.setName(threadName);
        this.thread.start();
    }

    @Override
    public void stop() {
        thread.interrupt();
    }
}
