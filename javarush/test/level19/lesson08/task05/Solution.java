package com.javarush.test.level19.lesson08.task05;

/* Дублируем текст
Считайте с консоли имя файла
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна дублировать вывод всего текста в файл, имя которого вы считали
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток
Закройте поток файла

Пример вывода на экран:
it's a text for testing

Пример тела файла:
it's a text for testing
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    static String file;

    static {
        Scanner in = new Scanner(System.in);
        file = in.nextLine();
        in.close();
    }

    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        PrintStream def = System.out;
        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        PrintStream SysOut = new PrintStream(buf);
        PrintWriter fileOut = new PrintWriter(file);
        System.setOut(SysOut);
        testString.printSomething();
        System.setOut(def);
        fileOut.println(buf.toString());
        System.out.println(buf.toString());
        fileOut.close();
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

