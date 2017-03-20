package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.Tablet;

import java.io.IOException;
import java.util.ArrayList;

public class TestOrder extends Order{

    public TestOrder(Tablet tablet) throws IOException {
        super(tablet);
    }

    @Override
    protected void initDishes() {
        ConsoleHelper.writeMessage(Dish.allDishesToString());
        dishes = new ArrayList<>();
        Dish[] dish = Dish.values();

        int count = (int)(Math.random() * dish.length);
        for (int i = 0; i < count; i++) {
            int index = (int)(Math.random() * dish.length);
            dishes.add(dish[index]);
        }
    }
}
