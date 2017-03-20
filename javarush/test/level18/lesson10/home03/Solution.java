package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner sc = new Scanner(System.in);
        String fileName = sc.nextLine();
        String file2Name = sc.nextLine();
        String file3Name = sc.nextLine();
        sc.close();

        FileOutputStream out = new FileOutputStream(fileName);
        FileInputStream in = new FileInputStream(file2Name);
        FileInputStream in2 = new FileInputStream(file3Name);

        while (in.available() > 0) {
            out.write(in.read());
        }

        while (in2.available() > 0) {
            out.write(in2.read());
        }

        out.close();
        in.close();
        in2.close();
    }
}
