package com.javarush.test.level14.lesson06.home01;

public class UkrainianHen extends Hen {
    @Override
    int getCountOfEggsPerMonth() {
        return 25;
    }

    @Override
    String getDescription() {
        return super.getDescription() + " Моя страна - Ukraine. Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
