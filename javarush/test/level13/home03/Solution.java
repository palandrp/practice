package com.javarush.test.level13.home03;

/* Чтение файла
1. Считать с консоли имя файла.
2. Вывести в консоль(на экран) содержимое файла.
3. Не забыть освободить ресурсы. Закрыть поток чтения с файла и поток ввода с клавиатуры.
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        Scanner in = new Scanner(System.in);
        BufferedReader read = new BufferedReader(new FileReader(in.nextLine()));
        while(read.ready()) System.out.println(read.readLine());
        in.close();
        read.close();
    }
}
