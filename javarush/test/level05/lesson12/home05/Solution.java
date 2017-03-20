package com.javarush.test.level05.lesson12.home05;

/* Вводить с клавиатуры числа и считать их сумму
Вводить с клавиатуры числа и считать их сумму, пока пользователь не введёт слово «сумма». Вывести на экран полученную сумму.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        String x = "0";
        int y = 0;
        int z = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        do
        {
            y = Integer.parseInt(x);
            z = z + y;
            x = reader.readLine();
        }
        while (!x.equals("сумма"));
        System.out.println(z);
    }
}
