package com.javarush.task.task20.task2015;

import java.io.*;

/* 
Переопределение сериализации
*/
public class Solution implements Serializable, Runnable {
    private transient Thread runner;
    private int speed;

    public Solution(int speed) {
        this.speed = speed;
        runner = new Thread(this);
        runner.start();
    }

    public void run() {
        int i = 0;
       while (i!=5){
           System.out.println("run:" + i);
           ++i;// do something here, doesn't matter what
       }
    }

    /**
     Переопределяем сериализацию.
     Для этого необходимо объявить методы:
     private void writeObject(ObjectOutputStream out) throws IOException
     private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
     Теперь сериализация/десериализация пойдет по нашему сценарию :)
     */
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        Thread t = new Thread(this);
        t.start();


    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Solution s = new Solution(555);
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("a:\\1.txt"));
        out.writeObject(s);
        out.close();
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("a:\\1.txt"));
        in.readObject();
        in.close();

    }
}
