package com.javarush.test.level18.lesson05.task02;

/* Подсчет запятых
С консоли считать имя файла
Посчитать в файле количество символов ',', количество вывести на консоль
Закрыть потоки. Не использовать try-with-resources

Подсказка: нужно сравнивать с ascii-кодом символа ','
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    static final int CHECK = 44;
    static int count = 0;

    public static void main(String[] args) throws IOException{

        Scanner sc = new Scanner(System.in);
        String fileName = sc.nextLine();
        sc.close();

        FileInputStream in = new FileInputStream(fileName);
        while (in.available() > 0) {
            if (in.read() == CHECK) count++;
        }
        in.close();

        System.out.println(count);
    }
}
