package com.javarush.test.level03.lesson12.home02;

/* Я не хочу изучать Java, я хочу большую зарплату
Вывести на экран десять раз надпись «Я не хочу изучать Java, я хочу большую зарплату»
*/

public class Solution
{
    public static void main(String[] args)
    {
        String a = "Я не хочу изучать Java, я хочу большую зарплату";
        print10(a);//напишите тут ваш код
    }
    public static void print10(String text) {
        for (int i = 0; i < 10; i++) {
            System.out.println(text);
        }
    }
}
