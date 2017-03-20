package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.Comparator;
import java.util.TreeSet;

public class Solution {
    static TreeSet<String> set = new TreeSet<>(new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            int i1 = Integer.parseInt(o1.split(".part")[1]);
            int i2 = Integer.parseInt(o2.split(".part")[1]);
            return Integer.compare(i1, i2);
        }
    });

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String line = reader.readLine();
            if (line.equals("end")) break;
            set.add(line);
        }
        reader.close();
        String full = set.first().split(".part")[0];

        FileOutputStream out = new FileOutputStream(full);
        byte[] buffer = new byte[1000];

        for (String fileName : set) {
            FileInputStream in = new FileInputStream(fileName);
            while (in.available() > 0) {
                int count = in.read(buffer);
                out.write(buffer, 0, count);
            }
            in.close();
        }
        out.close();
    }
}
