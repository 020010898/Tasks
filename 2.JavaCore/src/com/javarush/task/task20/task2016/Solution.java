package com.javarush.task.task20.task2016;

import java.io.*;

/*
Минимум изменений
*/
public class Solution {
    public class A implements Serializable {
        String name = "A";

        public A(String name) {
            this.name += name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public class B extends A implements Externalizable {
        String name = "B";

        public B(String name) {
            super(name);
            this.name += name;
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

    public class C extends B implements Externalizable{
        String name = "C";

        public C(String name) {
            super(name);
            this.name = name;
        }
    }

    public static void main(String[] args) {

    }
}
