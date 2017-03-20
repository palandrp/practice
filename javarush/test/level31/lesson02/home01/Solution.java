package com.javarush.test.level31.lesson02.home01;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

/* Проход по дереву файлов
1. На вход метода main подаются два параметра.
Первый - path - путь к директории, второй - resultFileAbsolutePath - имя файла, который будет содержать результат.
2. Для каждого файла в директории path и в ее всех вложенных поддиректориях выполнить следующее:
2.1. Если у файла длина в байтах больше 50, то удалить его.
2.2. Если у файла длина в байтах НЕ больше 50, то для всех таких файлов:
2.2.1. отсортировать их по имени файла в возрастающем порядке, путь не учитывать при сортировке
2.2.2. переименовать resultFileAbsolutePath в 'allFilesContent.txt'
2.2.3. в allFilesContent.txt последовательно записать содержимое всех файлов из п. 2.2.1. Тела файлов разделять "\n"
2.3. Удалить директории без файлов (пустые).
Все файлы имеют расширение txt.
*/
public class Solution {
    private static Map<String, File> fileMap = new TreeMap<>();

    public static void main(String[] args) throws IOException {
        File result = new File(args[1]);
        getFileTree(new File(args[0]), result);
        File newResult = new File(result.getParent() + File.separator + "allFilesContent.txt");
        result.renameTo(newResult);
        FileOutputStream fos = new FileOutputStream(newResult, true);
        List<File> files = new ArrayList<>(fileMap.values());
        for (int i = 0; i < files.size(); i++) {
            fos.write(Files.readAllBytes(files.get(i).toPath()));
            if (i < files.size()) fos.write('\n');
        }
    }

    public static void getFileTree(File root, File result) throws IOException {
        for (File f : root.listFiles()) {
            if (f.isDirectory()) {
                if (f.listFiles().length == 0) f.delete();
                else getFileTree(f, result);
            }
            else if (f.isFile()) {
                if (f.equals(result)) continue;
                if (f.length() > 50) f.delete();
                else fileMap.put(f.getName(), f);
            }
        }
        if (root.listFiles().length == 0) root.delete();
    }

}
