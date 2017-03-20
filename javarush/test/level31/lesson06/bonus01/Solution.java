package com.javarush.test.level31.lesson06.bonus01;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.TreeSet;
import java.util.Vector;
import java.util.zip.ZipInputStream;

/* Разархивируем файл
В метод main приходит список аргументов.
Первый аргумент - имя результирующего файла resultFileName, остальные аргументы - имена файлов fileNamePart.
Каждый файл (fileNamePart) - это кусочек zip архива. Нужно разархивировать целый файл, собрав его из кусочков.
Записать разархивированный файл в resultFileName.
Архив внутри может содержать файл большой длины, например, 50Mb.
Внутри архива может содержаться файл с любым именем.

Пример входных данных. Внутри архива находится один файл с именем abc.mp3:
C:/result.mp3
C:/pathToTest/test.zip.003
C:/pathToTest/test.zip.001
C:/pathToTest/test.zip.004
C:/pathToTest/test.zip.002
*/
public class Solution {
    public static void main(String[] args) throws IOException{
        FileOutputStream out = new FileOutputStream(args[0]);
        int count = args.length;
        TreeSet<String> set = new TreeSet<>();
        for (int i = 1; i < count; i++) {
            set.add(args[i]);
        }

        Vector<FileInputStream> vector = new Vector<>();
        for (String a : set) {
            vector.add(new FileInputStream(a));
        }

        Enumeration<FileInputStream> en = vector.elements();
        ZipInputStream in = new ZipInputStream(new SequenceInputStream(en));
        in.getNextEntry();
        int a;
        while ((a = in.read()) != -1) {
            out.write(a);
        }
        in.closeEntry();
        in.close();
        out.close();
    }
}
