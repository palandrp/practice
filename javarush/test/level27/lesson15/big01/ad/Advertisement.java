package com.javarush.test.level27.lesson15.big01.ad;

public class Advertisement {
    private Object content;
    private String name;
    private long initialAmount; //начальная сумма, стоимость рекламы в копейках.
    private int hits; // количество оплаченных показов
    private int duration; // продолжительность в секундах
    private long amountPerOneDisplaying;

    public Advertisement(Object content, String name, long initialAmount, int hits, int duration) {
        this.content = content;
        this.name = name;
        this.initialAmount = initialAmount;
        this.hits = hits;
        this.duration = duration;
        amountPerOneDisplaying = initialAmount / hits;
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
        if (hits <= 0) throw new UnsupportedOperationException();
        else hits--;
        if (hits == 1) amountPerOneDisplaying += initialAmount % amountPerOneDisplaying;
    }

    public int getHits() {
        return hits;
    }

    public double getAmountPerOneSecond(){
        return (double) amountPerOneDisplaying / duration;
    }

    @Override
    public String toString() {
        // First Video is displaying... 50, 277
        return String.format("%s is displaying... %d, %d", name, amountPerOneDisplaying, (int)(getAmountPerOneSecond() * 1000));
    }
}
