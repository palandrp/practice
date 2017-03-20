package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(new File(args[0]));
        FileWriter out = new FileWriter(args[1]);
        String line = "";
        StringBuilder full = new StringBuilder();

        while(in.hasNext()) {
            line = in.next();
            if (line.length() > 6) {
                full.append(line);
                full.append(",");
            }
        }
        full.deleteCharAt(full.length() - 1);

        out.write(full.toString());
        in.close();
        out.close();
    }
}
