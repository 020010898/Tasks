package com.javarush.task.task27.task2712.kitchen;

public enum Dish {
    Fish(25), Steak(30), Soup(15), Juice(5), Water(3);
    private int duration;

    Dish(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public static String allDishesToString(){
        StringBuffer buffer = new StringBuffer();
        for(Dish dish : values()){
            buffer.append(dish).append(", ");
        }
        buffer.replace(buffer.length()-2, buffer.length(),"");
        return buffer.toString();
    }
}
