package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран соотношение количества пробелов к количеству всех символов. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
4. Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {

    static float totalCount;
    static float spCount;

    public static void main(String[] args) throws IOException, FileNotFoundException{
        FileInputStream in = new FileInputStream(args[0]);
        while(in.available() > 0) {
            if (in.read() == 32) spCount++;
            totalCount++;
        }
        in.close();
        System.out.printf("%.2f", spCount / totalCount * 100);
    }
}
