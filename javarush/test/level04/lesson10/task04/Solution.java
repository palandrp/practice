package com.javarush.test.level04.lesson10.task04;

import java.io.*;

/* S-квадрат
Вывести на экран квадрат из 10х10 букв S используя цикл while.
Буквы в каждой строке не разделять.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
    int x = 1;
    int y = 1;
        while (x < 11 && y < 11) {
            if (x < 10) {
                System.out.print("S");
                x++;
            } else {
                System.out.println("S");
                x = 1;
                y++;
            }
        }

    }
}
