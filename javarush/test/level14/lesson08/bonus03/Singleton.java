package com.javarush.test.level14.lesson08.bonus03;

/**
 * Created by Юля on 22.12.2016.
 */
public class Singleton {
    private final static Singleton INSTANCE = new Singleton();

    private Singleton(){
    }

    static Singleton getInstance(){
        return INSTANCE;
    }
}
