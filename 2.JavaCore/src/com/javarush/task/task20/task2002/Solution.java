package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/*
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File yourFile = new File("a:\\1.txt");
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
            User user1 = new User();
            user1.setFirstName("1");
            user1.setLastName("11");
            user1.setBirthDate(new Date(1991, 11, 19));
            user1.setMale(true);
            user1.setCountry(User.Country.UKRAINE);
            javaRush.users.add(user1);
            User user2 = new User();
            user2.setFirstName("12");
            user2.setLastName("11");
            user2.setBirthDate(new Date(1991, 10, 19));
            user2.setMale(true);
            user2.setCountry(User.Country.UKRAINE);
            javaRush.users.add(user2);
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            for (User u : loadedObject.users) {
                System.out.println(u.getFirstName() + " " + u.getLastName() + " " + u.getCountry() + " " + u.getBirthDate());
            }

            System.out.println(javaRush.equals(loadedObject));


            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            PrintWriter printWriter = new PrintWriter(outputStream);
            SimpleDateFormat sdf = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z", Locale.ENGLISH);

            if(users!=null) {
                for (User user : users) {
                    printWriter.println(user.getFirstName());
                    printWriter.println(user.getLastName());
                    printWriter.println(user.getBirthDate().getTime());
                    printWriter.println(user.isMale());
                    printWriter.println(user.getCountry());
                }
            }
            printWriter.close();
            printWriter.flush();
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            SimpleDateFormat sdf = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z", Locale.ENGLISH);

            if (users != null) {
                String firstName;
                while ((firstName = reader.readLine()) != null) {
                    User user = new User();
                    user.setFirstName(firstName);
                    user.setLastName(reader.readLine());
                    Long date = Long.parseLong(reader.readLine());
                    Date bd = new Date(date);
                    user.setBirthDate(bd);
                    user.setMale(Boolean.parseBoolean(reader.readLine()));
                    user.setCountry(User.Country.valueOf(reader.readLine()));
                    users.add(user);
                }
                reader.close();
            }
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
