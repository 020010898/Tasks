package com.javarush.task.task20.task2021;

import java.io.*;

/* 
Сериализация под запретом
*/
public class Solution implements Serializable {
    public static class SubSolution extends Solution {
    public SubSolution(){}
        private void writeObject(ObjectOutputStream out) throws IOException{
            throw new NotSerializableException("Not today");
        }
        private void readObject(ObjectInputStream in) throws IOException{
            throw new NotSerializableException("Not today");
        }

    }



    public static void main(String[] args) {
        SubSolution sub = new SubSolution();
        try {
            ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("a:\\1.txt"));
            o.writeObject(sub);
            o.close();

            ObjectInputStream oi = new ObjectInputStream(new FileInputStream("a:\\1.txt"));
            SubSolution su = (SubSolution)oi.readObject();
            oi.close();
        }catch (NotSerializableException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){

        }catch (IOException e){

        }

    }
}
