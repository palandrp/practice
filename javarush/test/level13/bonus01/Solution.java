package com.javarush.test.level13.bonus01;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

public class Solution
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<>();

        try {
            Scanner fin = new Scanner(new FileInputStream(in.nextLine()));
            while(fin.hasNext()) {
                int a = fin.nextInt();
                if (a % 2 == 0) arr.add(a);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        bubble(arr);
        for (Integer i : arr) {
            System.out.println(i);
        }

    }

    public static void bubble (ArrayList<Integer> arr) {

        int count = 0;

        for (int j = arr.size(); j > 0; j--) {
            for (int i = 0; i < j - 1; i++) {
                if (arr.get(i) > arr.get(i + 1)) {
                    int temp = arr.get(i);
                    arr.set(i, arr.get(i + 1));
                    arr.set(i + 1, temp);
                    count++;
                }
            }
            if (count == 0) break;
            else count = 0;
        }
    }

}
