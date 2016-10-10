package com.javarush.test.level07.lesson04.task05;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Один большой массив и два маленьких
1. Создать массив на 20 чисел.
2. Ввести в него значения с клавиатуры.
3. Создать два массива на 10 чисел каждый.
4. Скопировать большой массив в два маленьких: половину чисел в первый маленький, вторую половину во второй маленький.
5. Вывести второй маленький массив на экран, каждое значение выводить с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        int[] arr = new int[20];
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < arr.length; i++)
        {
            arr[i] = Integer.parseInt(r.readLine());
        }

        int[] arr1 = new int[10];
        int[] arr2 = new int[10];

        for (int i = 0; i < arr.length; i++)
        {
            if (i < 10) arr1[i] = arr[i];
            else arr2[i - 10] = arr[i];
        }

        for (int i = 0; i < arr2.length; i++)
        {
            System.out.println(arr2[i]);
        }

    }
}
