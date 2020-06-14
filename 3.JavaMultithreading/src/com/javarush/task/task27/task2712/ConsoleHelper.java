package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ConsoleHelper {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    // для вывода message в консоль
    public static void writeMessage(String message) {
        System.out.println(message);
    }

    // для чтения строки с консоли
    public static String readString() throws IOException {
        return reader.readLine();
    }

    public static List<Dish> getAllDishesForOrder() {
        List<Dish> clienOrder = new ArrayList<>();
        writeMessage(Dish.allDishesToString());
        writeMessage("название блюда: ");
        String newDish;
        try {
            while (!(newDish = readString()).equals("exit")) {
                for(Dish d : Dish.values()){
                    if(d.name().equals(newDish)){
                        clienOrder.add(Dish.valueOf(newDish));
                    }
                }
                if(!clienOrder.get(clienOrder.size()-1).toString().equals(newDish)){
                 ConsoleHelper.writeMessage("такого блюда нет");
                }
            }
        }catch (Exception ex){

        }
        return clienOrder;
    }
}