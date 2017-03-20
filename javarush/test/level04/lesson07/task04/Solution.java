package com.javarush.test.level04.lesson07.task04;

/* Положительные и отрицательные числа
Ввести с клавиатуры три целых числа. Вывести на экран количество положительных и количество отрицательных чисел в исходном наборе,
в следующем виде:
"количество отрицательных чисел: а", "количество положительных чисел: б", где а, б - искомые значения.
Пример для чисел 2 5 6:
количество отрицательных чисел: 0
количество положительных чисел: 3
Пример для чисел -2 -5 6:
количество отрицательных чисел: 2
количество положительных чисел: 1
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(reader.readLine());
        int y = Integer.parseInt(reader.readLine());
        int z = Integer.parseInt(reader.readLine());

        int count = 0;
        int pcount = 0;

        if (x > 0) count++;
        if (y > 0) count++;
        if (z > 0) count++;
        if (x < 0) pcount++;
        if (y < 0) pcount++;
        if (z < 0) pcount++;

        System.out.println("количество отрицательных чисел: " + pcount);
        System.out.println("количество положительных чисел: " + count);
//напишите тут ваш код

    }
}
