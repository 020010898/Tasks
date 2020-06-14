package com.javarush.task.task20.task2022;

import java.io.*;

/* 
Переопределение сериализации в потоке
*/
public class Solution implements Serializable, AutoCloseable {
    private transient FileOutputStream stream;
    private String fileName;

    public Solution(){}
    public Solution(String fileName) throws IOException {
        this.fileName = fileName;
        this.stream = new FileOutputStream(fileName);
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeObject(fileName);

    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        stream = new FileOutputStream(fileName, true);
        fileName = (String) in.readObject();

    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args)throws Exception {
        Solution s = new Solution("a:\\1.txt");
        s.writeObject("Scoobidoo");
        s.close();

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("a:\\2.txt"));
        out.writeObject(s);
        out.flush();
        out.close();

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("a:\\2.txt"));
        Solution ss = (Solution) in.readObject();
        in.close();
        ss.writeObject("hey");
        System.out.println(ss.toString());
    }
}
