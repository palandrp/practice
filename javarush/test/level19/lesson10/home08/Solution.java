package com.javarush.test.level19.lesson10.home08;

/* Перевертыши
1 Считать с консоли имя файла.
2 Для каждой строки в файле:
2.1 переставить все символы в обратном порядке
2.2 вывести на экран
3 Закрыть потоки. Не использовать try-with-resources

Пример тела входного файла:
я - программист.
Амиго

Пример результата:
.тсиммаргорп - я
огимА
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        String file = in.nextLine();
        in.close();

        BufferedReader out = new BufferedReader(new FileReader(file));
        while(out.ready()) {
            StringBuilder line = new StringBuilder();
            line.append(out.readLine());
            System.out.println(line.reverse().toString());
        }
        out.close();
    }
}
