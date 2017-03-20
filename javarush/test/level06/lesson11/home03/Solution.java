package com.javarush.test.level06.lesson11.bonus02;

import java.io.IOException;

/* Нужно добавить в программу новую функциональность
Задача: У каждой кошки есть имя и кошка-мама. Создать класс, который бы описывал данную ситуацию. Создать два объекта: кошку-дочь и кошку-маму. Вывести их на экран.
Новая задача: У каждой кошки есть имя, кошка-папа и кошка-мама. Изменить класс Cat так, чтобы он мог описать данную ситуацию.
Создать 6 объектов: дедушку(папин папа), бабушку(мамина мама), папу, маму, сына, дочь.
Вывести их всех на экран в порядке: дедушка, бабушка, папа, мама, сын, дочь.

Пример ввода:
дедушка Вася
бабушка Мурка
папа Котофей
мама Василиса
сын Мурчик
дочь Пушинка

Пример вывода:
Cat name is дедушка Вася, no mother, no father
Cat name is бабушка Мурка, no mother, no father
Cat name is папа Котофей, no mother, father is дедушка Вася
Cat name is мама Василиса, mother is бабушка Мурка, no father
Cat name is сын Мурчик, mother is мама Василиса, father is папа Котофей
Cat name is дочь Пушинка, mother is мама Василиса, father is папа Котофей
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {

    }

    public static class Cat
    {
        private String name;
        private Cat mother;
        private Cat father;

        Cat(String name)
        {
            this.name = name;
        }

        Cat(Cat father, String name)
        {
            this.name = name;
            this.father = father;
        }

        Cat(String name, Cat mother, Cat father)
        {
            this.name = name;
            this.mother = mother;
            this.father = father;
        }

        @Override
        public String toString()
        {
            if (mother == null && father == null)
                return "Cat name is " + name + ", no mother, no father";
            else if (father == null)
                return "Cat name is " + name + ", mother is " + mother.name + ", no father";
            else if (mother == null)
                return "Cat name is " + name + ", no mother, father is " + father.name;
            else return "Cat name is " + name + ", mother is " + mother.name + ", father is " + father.name;
        }
    }

}

