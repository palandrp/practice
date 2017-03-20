package com.javarush.test.level15.lesson12.bonus01;

/**
 * Created by Юля on 25.12.2016.
 */
public class Plane implements Flyable {
    private int passCount;

    public Plane(int amount) {
        passCount = amount;
    }

    @Override
    public void fly() {

    }
}
