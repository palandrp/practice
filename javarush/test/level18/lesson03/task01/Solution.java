package com.javarush.test.level18.lesson03.task01;

import java.io.FileInputStream;
import java.util.Scanner;

/* Максимальный байт
Ввести с консоли имя файла
Найти максимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution {

    static int max;

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        String fileName = in.nextLine();
        FileInputStream fin = new FileInputStream(fileName);

        while (fin.available() > 0) {
            int token = fin.read();
            if (token > max) max = token;
        }

        System.out.println(max);
        fin.close();

    }
}
