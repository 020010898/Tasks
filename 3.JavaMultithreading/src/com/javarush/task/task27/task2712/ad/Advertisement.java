package com.javarush.task.task27.task2712.ad;

public class Advertisement {
    //видео
    public Object content;

    //имя/название
    public String name;

    //начальная сумма, стоимость рекламы в копейках.
    private long initialAmount;
    //количество оплаченных показов
    private int hits;
    //продолжительность в секундах
    public int duration;

    private long amountPerOneDisplaying;

    public Advertisement(Object content, String name, long initialAmount, int hits, int duration) {
        this.content = content;
        this.name = name;
        this.initialAmount = initialAmount;
        this.hits = hits;
        this.duration = duration;
        this.amountPerOneDisplaying = (hits > 0) ? initialAmount / hits : 0;
    }

    public long getInitialAmount() {
        return initialAmount;
    }

    public void setInitialAmount(long initialAmount) {
        this.initialAmount = initialAmount;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public long getAmountPerOneDisplaying() {
        return amountPerOneDisplaying;
    }

    public void revalidate(){
    if(hits<=0) {
        throw new UnsupportedOperationException();
    }
    hits--;
    }
}
