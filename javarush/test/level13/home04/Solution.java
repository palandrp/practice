package com.javarush.test.level13.home04;

/* Запись в файл
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести абсолютно все введенные строки в файл, каждую строчку с новой стороки.
*/

import java.io.*;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        Scanner in = new Scanner(System.in);

        PrintWriter wr = new PrintWriter(in.nextLine());
        while(true) {
            String a = in.nextLine();
            if (a.equals("exit")) {
                wr.println(a);
                break;
            }
            wr.println(a);
        }
        in.close();
        wr.close();
    }
}
