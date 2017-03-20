package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    static int SIZE = 80;
    static int id = 0;

    public static void main(String[] args) throws IOException {
        if (args[0].equals("-c")) {
            Scanner in = new Scanner(System.in);
            String fileName = in.nextLine();
            in.close();

            InputStreamReader fin = new InputStreamReader(new FileInputStream(fileName));
            char[] buf = new char[51];

            while (fin.ready()) {
                fin.read(buf);
                String line = "";
                for (int i = 0; i < 8; i++) {
                    if (buf[i] != ' ') line += buf[i];
                }
                int num = Integer.parseInt(line);
                if (num > id) id = num;
            }
            fin.close();

            String newLine = String.format("%-8.8s%-30.30s%-8.8s%-4.4s", String.valueOf(++id), args[1], args[2], args[3]);
            byte[] line = newLine.getBytes();

            FileOutputStream out = new FileOutputStream(fileName, true);
            out.write(line);
            out.close();
        }
    }
}
