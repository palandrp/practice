package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    static int count = 0;

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        String file = in.nextLine();
        in.close();

        Scanner on = new Scanner(new File(file));
        while (on.hasNext())
        {
            String str = on.nextLine();

            Pattern p = Pattern.compile("\\bworld\\b");
            Matcher m = p.matcher(str);

            while(m.find()) count++;
        }

        System.out.println(count);
        on.close();
    }
}
