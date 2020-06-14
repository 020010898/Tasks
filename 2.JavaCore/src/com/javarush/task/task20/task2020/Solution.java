package com.javarush.task.task20.task2020;

import java.io.*;
import java.util.logging.Logger;

/* 
Сериализация человека
*/
public class Solution {

    public static class Person implements Serializable {
        String firstName;
        String lastName;
        transient String fullName;
        transient final String greeting;
        String country;
        Sex sex;
        transient PrintStream outputStream;
        transient Logger logger;

        public Person(){
            greeting = "Hey";
        }
        public Person(String firstName, String lastName){
            this.firstName = firstName;
            this.lastName = lastName;
            this.fullName = String.format("%s, %s", lastName, firstName);
            this.greeting = "Hello, ";
            this.outputStream = System.out;
            this.logger = Logger.getLogger(String.valueOf(Person.class));
        }

        Person(String firstName, String lastName, String country, Sex sex) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.fullName = String.format("%s, %s", lastName, firstName);
            this.greeting = "Hello, ";
            this.country = country;
            this.sex = sex;
            this.outputStream = System.out;
            this.logger = Logger.getLogger(String.valueOf(Person.class));
        }

        public void writeObject(ObjectOutputStream out) throws IOException{
            out.writeObject(this.firstName);
            out.writeObject(this.lastName);
        }
        public void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException{
            firstName = (String)in.readObject();
            lastName = (String) in.readObject();
        }

    }

    enum Sex implements Serializable {
        MALE,
        FEMALE
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("a:\\1.txt"));
        Person p = new Person("Amigo","Developer");
        out.writeObject(p);
        out.close();

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("a:\\1.txt"));
        Person p1 = (Person)in.readObject();
        in.close();

        System.out.println(p1.fullName);
    }
}
