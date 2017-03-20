package com.javarush.test.level06.lesson11.home02;

import java.util.ArrayList;

/* Статические коты
1. В классе Cat добавь public статическую переменную cats (ArrayList<Cat>).
2. Пусть при каждом создании кота (нового объекта Cat) в переменную cats добавляется этот новый кот. Создать 10 объектов Cat.
3. Метод printCats должен выводить всех котов на экран. Нужно использовать переменную cats.
*/

public class Cat
{
    public static ArrayList<Cat> cats = new ArrayList<>();

    public Cat()
    {
        cats.add(this);
    }

    public static void main(String[] args)
    {
        Cat c1 = new Cat();
        Cat c2 = new Cat();
        Cat c3 = new Cat();
        Cat c4 = new Cat();
        Cat c5 = new Cat();
        Cat c6 = new Cat();
        Cat c7 = new Cat();
        Cat c8 = new Cat();
        Cat c9 = new Cat();
        Cat c10 = new Cat();
        printCats();
    }

    public static void printCats()
    {
        for (int i = 0; i < Cat.cats.size(); i++)
        {
            System.out.println(cats.get(i));
        }
    }
}