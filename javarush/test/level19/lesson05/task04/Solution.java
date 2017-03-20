package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException{

        Scanner in = new Scanner(System.in);
        String file1 = in.nextLine();
        String file2 = in.nextLine();
        in.close();

        FileReader on = new FileReader(file1);
        FileWriter out = new FileWriter(file2);

        while (on.ready()) {
            char b = (char) on.read();
            if (b == '.') out.write('!');
            else out.write(b);
        }

        on.close();
        out.close();
    }
}
