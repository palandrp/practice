package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Solution {
    static LinkedHashMap<String, String> map = new LinkedHashMap<>();
    static String fileName;

    static{
        Scanner in = new Scanner(System.in);
        fileName = in.nextLine();
        in.close();
    }

    public static void main(String[] args) throws IOException {
        mapCreate();
        if (args[0].equals("-u")) mapUpdate(args);
        if (args[0].equals("-d")) mapRemove(args);
    }

    public static void mapRemove(String[] args) {
        String id = String.format("%8s", args[1]);
        map.remove(id);
        writeFile();
    }

    public static void mapUpdate(String[] args) {
        String id = String.format("%-8s", args[1]);
        String newLine = String.format("%-8.8s%-30.30s%-8.8s%-4.4s", args[1], args[2], args[3], args[4]);
        map.put(id, newLine);
        writeFile();
    }

    public static void writeFile() {
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(fileName, false));
            for (String a : map.values()) {
                out.write(a);
                out.newLine();
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void mapCreate() {
        try {
            BufferedReader fin = new BufferedReader(new FileReader(fileName));

            while (fin.ready()) {
                String line = fin.readLine();
                String id = line.substring(0, 8);
                map.put(id, line);
            }
            fin.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
