package com.javarush.test.level14.lesson06.home01;

public class RussianHen extends Hen {
    @Override
    int getCountOfEggsPerMonth() { return 35; }

    @Override
    String getDescription() {
        return super.getDescription() + " Моя страна - Russia. Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
