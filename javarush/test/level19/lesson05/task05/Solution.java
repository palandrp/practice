package com.javarush.test.level19.lesson05.task05;

/* Пунктуация
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Удалить все знаки пунктуации, включая символы новой строки. Результат вывести во второй файл.
http://ru.wikipedia.org/wiki/%D0%9F%D1%83%D0%BD%D0%BA%D1%82%D1%83%D0%B0%D1%86%D0%B8%D1%8F
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Solution {

    Pattern p = Pattern.compile("\\p{Punct}|\\s|^");

    public static void main(String[] args) throws IOException{

        Scanner in = new Scanner(System.in);
        String file1 = in.nextLine();
        String file2 = in.nextLine();
        in.close();

        BufferedReader on = new BufferedReader(new FileReader(file1));
        FileWriter out = new FileWriter(file2);

        while (on.ready()) {
            String line = on.readLine();
            out.write(line.replaceAll("\\p{Punct}", "").toCharArray());
        }

        on.close();
        out.close();
    }
}
