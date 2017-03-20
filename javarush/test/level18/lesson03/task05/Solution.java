package com.javarush.test.level18.lesson03.task05;

import java.io.FileInputStream;
import java.util.Scanner;
import java.util.TreeSet;




/* Сортировка байт
Ввести с консоли имя файла
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран
Закрыть поток ввода-вывода

Пример байт входного файла
44 83 44

Пример вывода
44 83
*/

public class Solution {
    static TreeSet<Integer> set = new TreeSet<>();

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        String fileName = in.nextLine();

        FileInputStream fin = new FileInputStream(fileName);

        while (fin.available() > 0) {
            int token = fin.read();
            set.add(token);
        }
        fin.close();

        for (Integer a : set) {
            System.out.print(a + " ");
        }
    }
}
