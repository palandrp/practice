package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human). Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

import java.util.ArrayList;
import java.util.Collections;

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<Human> list = new ArrayList<>();

        Human gpm = new Human("mamagrandpa", true, 62, null, null);
        Human gpp = new Human("papagrandpa", true, 70, null, null);
        Human gmm = new Human("mamagrandma", false, 56, null, null);
        Human gmp = new Human("papagrandma", false, 64, null, null);
        Human p = new Human("papa", true, 33, gpp, gmp);
        Human m = new Human("mama", false, 28, gpm, gmm);
        Human k1 = new Human("k1", false, 6, p, m);
        Human k2 = new Human("k2", true, 5, p, m);
        Human k3 = new Human("k3", false, 3, p, m);

        Collections.addAll(list, gpm, gpp, gmm, gmp, p, m, k1, k2, k3);

        for (Human x : list)
        {
            System.out.println(x);
        }
    }

    public static class Human
    {
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;

        Human (String name, boolean sex, int age, Human father, Human mother) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }

}
