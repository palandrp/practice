package com.javarush.test.level04.lesson13.task04;

import java.io.*;

/* Рисуем линии
Используя цикл for вывести на экран:
- горизонтальную линию из 10 восьмёрок
- вертикальную линию из 10 восьмёрок.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {


        for (int i = 1; i < 11; i++)
        {
            System.out.print(8); //напишите тут ваш код

        }
        System.out.println();

        for (int j = 1; j < 11; j++){
            System.out.println(8);
        }
    }
}