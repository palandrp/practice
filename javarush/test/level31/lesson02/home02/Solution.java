package com.javarush.test.level31.lesson02.home02;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

/* Находим все файлы
Реализовать логику метода getFileTree, который должен в директории root найти список всех файлов включая вложенные.
Используйте очередь, рекурсию не используйте.
Верните список всех путей к найденным файлам, путь к директориям возвращать не надо.
Путь должен быть абсолютный.
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {

        List<String> result = new LinkedList<>();
        LinkedBlockingQueue<File> files = new LinkedBlockingQueue<>();
        File rootFile = new File(root);
        if (rootFile.isDirectory()) files.add(rootFile);
        while (!files.isEmpty()) {
            File currentDir = files.poll();
            try {
                for (File f : currentDir.listFiles()) {
                    if (f.isDirectory()) files.add(f);
                    else if (f.isFile()) result.add(f.getAbsolutePath());
                }
            } catch (NullPointerException ignored) {
            }
        }

        return result;
    }
}
