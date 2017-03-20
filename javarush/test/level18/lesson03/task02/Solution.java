package com.javarush.test.level18.lesson03.task02;

import java.io.FileInputStream;
import java.util.Scanner;

/* Минимальный байт
Ввести с консоли имя файла
Найти минимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution {
    static int min;

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        String fileName = in.nextLine();
        FileInputStream fin = new FileInputStream(fileName);
        min = fin.read();

        while (fin.available() > 0) {
            int token = fin.read();
            if (token < min) min = token;
        }

        System.out.println(min);
        fin.close();
    }
}
