package com.javarush.test.level18.lesson03.task04;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байт или байты с минимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static HashMap<Integer, Integer> map = new HashMap<>();
    static int minValue = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        String fileName = in.nextLine();

        FileInputStream fin = new FileInputStream(fileName);

        while (fin.available() > 0) {
            int token = fin.read();
            if (map.containsKey(token)) map.put(token, map.get(token) + 1);
            else map.put(token, 1);
        }
        fin.close();

        for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
            if (pair.getValue() < minValue) minValue = pair.getValue();
        }

        for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
            if (pair.getValue() == minValue) System.out.print(pair.getKey() + " ");
        }
    }
}
