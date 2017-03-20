package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
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
        String file3Name = sc.nextLine();
        sc.close();

        FileInputStream in = new FileInputStream(fileName);
        FileOutputStream out = new FileOutputStream(file2Name);
        FileOutputStream out2 = new FileOutputStream(file3Name);
        int half = in.available() / 2;

        while (in.available() > half) {
            out.write(in.read());
        }
        out.close();

        while (in.available() > 0) {
            out2.write(in.read());
        }
        out2.close();
        in.close();

    }
}
