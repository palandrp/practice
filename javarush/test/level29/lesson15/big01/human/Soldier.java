package com.javarush.test.level29.lesson15.big01.human;

/**
 * Created by Naatsms on 29.01.2017.
 */
public class Soldier extends Human {

    public Soldier(String name, int age) {
        super(name, age);
    }

    @Override
    public void live() {
        super.live();
        fight();
    }

    public void fight() {
    }

}
