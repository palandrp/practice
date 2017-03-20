package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException, FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        String fileName = sc.nextLine();
        String file2Name = sc.nextLine();
        sc.close();

        FileInputStream in1 = new FileInputStream(fileName);
        FileInputStream in2 = new FileInputStream(file2Name);

        byte[] buf = new byte[in1.available() + in2.available()];

        int check = in2.read(buf);
        int check2 = in1.read(buf, check, in1.available());

        FileOutputStream out1 = new FileOutputStream(fileName, false);

        out1.write(buf);

        in1.close();
        out1.close();
        in2.close();
        }
    }
