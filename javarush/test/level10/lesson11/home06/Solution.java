package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        int age;
        int height;
        int weigth;
        boolean sex;
        String name;
        String secondname;

        public Human(int age, int weigth, String name, String secondname) {

            this.age = age;
            this.weigth = weigth;
            this.name = name;
            this.secondname = secondname;
        }

        public Human(int age, int weigth, String name) {

            this.age = age;
            this.weigth = weigth;
            this.name = name;
        }

        public Human(int age, int weigth, boolean sex) {

            this.age = age;
            this.weigth = weigth;
            this.sex = sex;
        }

        public Human(int age, int height, int weigth) {

            this.age = age;
            this.height = height;
            this.weigth = weigth;
        }

        public Human(int age, int height, int weigth, boolean sex, String name, String secondname) {

            this.age = age;
            this.height = height;
            this.weigth = weigth;
            this.sex = sex;
            this.name = name;
            this.secondname = secondname;
        }

        public Human(int age, int weigth, boolean sex, String name, String secondname) {

            this.age = age;
            this.weigth = weigth;
            this.sex = sex;
            this.name = name;
            this.secondname = secondname;
        }

        public Human(int weigth, boolean sex, String name, String secondname) {

            this.weigth = weigth;
            this.sex = sex;
            this.name = name;
            this.secondname = secondname;
        }

        public Human(int weigth, boolean sex, String name) {

            this.weigth = weigth;
            this.sex = sex;
            this.name = name;
        }

        public Human(int height, int weigth, boolean sex, String name) {
            this.height = height;
            this.weigth = weigth;
            this.sex = sex;
            this.name = name;
        }

        public Human(int age, int height, int weigth, String name, String secondname) {

            this.age = age;
            this.height = height;
            this.weigth = weigth;
            this.name = name;
            this.secondname = secondname;
        }
    }
}
