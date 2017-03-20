package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-resources

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);
        String file1 = in.nextLine();
        String file2 = in.nextLine();
        in.close();

        Scanner on = new Scanner(new File(file1));
        FileWriter out = new FileWriter(file2);

        while (on.hasNext()) {
            if (on.hasNextInt()) out.write(on.next() + " ");
            else on.next();
        }

        on.close();
        out.close();
    }
}
