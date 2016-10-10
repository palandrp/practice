package com.javarush.test.level04.lesson16.home03;

import java.io.*;

/* Посчитать сумму чисел
Вводить с клавиатуры числа и считать их сумму. Если пользователь ввел -1, вывести на экран сумму и завершить программу.  -1 должно учитываться в сумме.
*/

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        int x = 0;
        int y = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (x != -1) {

            x = Integer.parseInt(reader.readLine());
            y = y + x;
        }
        System.out.println(y);
    }
}
