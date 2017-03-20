package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        Human mfather = new Human("tbe", true, 55);
        Human ffather = new Human("tbefsd", true, 55);
        Human mmother = new Human("tessd", false, 55);
        Human fmother = new Human("tesadsd", false, 55);

        Human father = new Human("ee", true, 35);
        Human mother = new Human("tb", false, 30);

        Human baby1 = new Human("a", true, 15);
        Human baby2 = new Human("b", false, 15);
        Human baby3 = new Human("c", true, 15);
        ArrayList<Human> kids = new ArrayList<>();
        kids.add(baby1);
        kids.add(baby2);
        kids.add(baby3);
        father.children = kids;
        mother.children = kids;

        ArrayList<Human> fathers = new ArrayList<>();
        fathers.add(father);
        ffather.children = fathers;
        fmother.children = fathers;

        ArrayList<Human> mothers = new ArrayList<>();
        mothers.add(mother);
        mfather.children = mothers;
        mmother.children = mothers;

        ArrayList<Human> kk = new ArrayList<>();
        baby1.children = kk;
        baby2.children = kk;
        baby3.children = kk;

        System.out.println(ffather);
        System.out.println(mfather);
        System.out.println(fmother);
        System.out.println(mmother);
        System.out.println(father);
        System.out.println(mother);
        System.out.println(baby1);
        System.out.println(baby2);
        System.out.println(baby3);

    }

    public static class Human
    {
        String name;
        boolean sex;
        int age;
        public ArrayList<Human> children;

        public Human(String name, boolean sex, int age, ArrayList<Human> children) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }
    }

}
