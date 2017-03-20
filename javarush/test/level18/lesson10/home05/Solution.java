package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/

import java.io.*;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner sc = new Scanner(System.in);
        String fileName = sc.nextLine();
        String file2Name = sc.nextLine();
        sc.close();
        ArrayList<Long> arr = new ArrayList<>();

        Scanner in = new Scanner(new File(fileName));
        while(in.hasNext()) {
            //System.out.println(Double.parseDouble(in.next()));
            arr.add(Math.round(Double.parseDouble(in.next())));
        }
        in.close();

        PrintWriter out = new PrintWriter(file2Name);
        for (Long number : arr) {
            out.print(number + " ");
        }
        out.close();
    }
}
