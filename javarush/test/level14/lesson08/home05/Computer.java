package com.javarush.test.level14.lesson08.home05;

/**
 * Created by Юля on 24.12.2016.
 */
public class Computer {
    private Keyboard key;
    private Mouse mou;
    private Monitor mon;

    public Computer() {
        this.key = new Keyboard();
        this.mou = new Mouse();
        this.mon = new Monitor();
    }

    public Keyboard getKeyboard() {
        return key;
    }

    public Mouse getMouse() {
        return mou;
    }

    public Monitor getMonitor() {
        return mon;
    }
}
