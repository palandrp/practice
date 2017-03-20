package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String fileName = sc.nextLine();
        String file2Name = sc.nextLine();
        sc.close();

        FileInputStream in = new FileInputStream(fileName);
        FileOutputStream out = new FileOutputStream(file2Name);
        byte[] arr = new byte[in.available()];
        in.read(arr);

        for (int i = arr.length - 1; i > -1; i--) {
            out.write(arr[i]);
        }
        in.close();
        out.close();

    }
}
