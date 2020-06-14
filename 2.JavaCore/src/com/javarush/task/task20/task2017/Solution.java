package com.javarush.task.task20.task2017;

import java.io.*;

/* 
Десериализация
*/
public class Solution {
    public A getOriginalObject(ObjectInputStream objectStream){
        A a = null;
        try {
            a = (A) objectStream.readObject();
        }catch (NotSerializableException e){
            e.getStackTrace();
            return null;
        }catch (IOException e){
            e.getStackTrace();
            return null;
        }catch (ClassNotFoundException e){
            e.getStackTrace();
            return null;
        }catch (Exception e){
            e.getStackTrace();
            return null;
        }
        return a;
    }

    public class A implements Serializable {

    }

    public class B extends A implements Externalizable {
        public B() {
            System.out.println("inside B");
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(this);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            in.readObject();
        }
    }

    public static void main(String[] args) {

    }
}
