package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.Tablet;

import java.io.IOException;
import java.util.List;

public class Order {
    private Tablet tablet;
    protected List<Dish> dishes;
    private Cook cook;

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        initDishes();
    }

    protected void initDishes() throws IOException{
        ConsoleHelper.writeMessage(Dish.allDishesToString());
        dishes = ConsoleHelper.getAllDishesForOrder();
    }

    @Override
    public String toString() {
        if (dishes.isEmpty()) return "";
        return "Your order: " + dishes + " of " + tablet;
    }

    public int getTotalCookingTime() {
        int sum = 0;
        for (Dish d : dishes) {
            sum += d.getDuration();
        }
        return sum;
    }

    public boolean isEmpty() {
        return dishes.isEmpty();
    }

    public Tablet getTablet() {
        return tablet;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setCook(Cook cook) {
        this.cook = cook;
    }

    public Cook getCook(){
        return cook;
    }

}
