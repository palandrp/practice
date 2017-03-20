package com.javarush.test.level18.lesson03.task03;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/* Самые частые байты
Ввести с консоли имя файла
Найти байт или байты с максимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static HashMap<Integer, Integer> map = new HashMap<>();
    static int maxValue;

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
            if (pair.getValue() > maxValue) maxValue = pair.getValue();
        }

        for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
            if (pair.getValue() == maxValue) System.out.print(pair.getKey() + " ");
        }
    }
}
