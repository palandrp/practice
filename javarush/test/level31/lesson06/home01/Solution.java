package com.javarush.test.level31.lesson06.home01;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* Добавление файла в архив
В метод main приходит список аргументов.
Первый аргумент - полный путь к файлу fileName.
Второй аргумент - путь к zip-архиву.
Добавить файл (fileName) внутрь архива в директорию 'new'.
Если в архиве есть файл с таким именем, то заменить его.

Пример входных данных:
C:/result.mp3
C:/pathToTest/test.zip

Файлы внутри test.zip:
a.txt
b.txt

После запуска Solution.main архив test.zip должен иметь такое содержимое:
new/result.mp3
a.txt
b.txt

Подсказка: нужно сначала куда-то сохранить содержимое всех энтри,
а потом записать в архив все энтри вместе с добавленным файлом.
Пользоваться файловой системой нельзя.
*/
public class Solution {
    public static void main(String[] args) {
        Map<ZipEntry, byte[]> map = createMap(args[1]);
        File file = new File(args[0]);
        writeZip(map, file, args[1]);
    }

    public static Map<ZipEntry, byte[]> createMap(String zip) {
        Map<ZipEntry, byte[]> map = new HashMap<>();
        try (ZipInputStream zin = new ZipInputStream(new FileInputStream(new File(zip)))) {
            ZipEntry ent;
            while ((ent = zin.getNextEntry()) != null) {
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                int a;
                while ((a = zin.read()) != -1) {
                    out.write(a);
                }
                map.put(ent, out.toByteArray());
                zin.closeEntry();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

    public static void writeZip(Map<ZipEntry, byte[]> map, File file, String zip) {
        try (ZipOutputStream zon = new ZipOutputStream(new FileOutputStream(new File(zip)))) {
            for (Map.Entry<ZipEntry, byte[]> pair : map.entrySet()) {
                if (Paths.get(pair.getKey().getName()).toFile().getName().equals(file.getName())) {
                    zon.putNextEntry(new ZipEntry("new/" + file.getName()));
                    zon.write(Files.readAllBytes(file.toPath()));
                    zon.closeEntry();
                    continue;
                }
                zon.putNextEntry(pair.getKey());
                zon.write(pair.getValue());
                zon.closeEntry();
            }
            zon.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
