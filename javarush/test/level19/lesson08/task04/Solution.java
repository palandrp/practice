package com.javarush.test.level19.lesson08.task04;

/* Решаем пример
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить на консоль решенный пример
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.

Пример вывода:
3 + 6 = 9
*/

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class Solution {

    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream def = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream newStream = new PrintStream(out);
        System.setOut(newStream);
        testString.printSomething();
        System.setOut(def);

        String a = out.toString().replaceAll("\\r\\n", "");
        String[] ar = a.split(" ");
        int x = Integer.parseInt(ar[0]);
        String action = ar[1];
        int y = Integer.parseInt(ar[2]);
        if (action.equals("*")) System.out.println(a + (x * y));
        else if (action.equals("+")) System.out.println(a + (x + y));
        else if (action.equals("-")) System.out.println(a + (x - y));
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }

}

