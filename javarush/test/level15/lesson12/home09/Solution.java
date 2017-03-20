package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String a = reader.readLine();
        String[] a1 = a.split("\\?");
        String[] a2 = a1[1].split("&");
        ArrayList<String> obj = new ArrayList<>();

        for (String b : a2) {
            System.out.print(b.split("=")[0] + " ");
            if (b.startsWith("obj=")) obj.add(b.split("=")[1]);
        }
        System.out.println("");

        if (!obj.isEmpty()) {
            for (String ob : obj) {
                if (checkDouble(ob)) alert(Double.parseDouble(ob));
                else alert(ob);
            }
        }

    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }

    public static boolean checkDouble(String a) {
        try {
            Double.parseDouble(a);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}