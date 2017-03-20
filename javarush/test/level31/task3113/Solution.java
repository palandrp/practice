package com.javarush.task.task31.task3113;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Scanner;

/* 
Что внутри папки?
*/
public class Solution {

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);
        String path = in.nextLine();
        in.close();

        Path file = Paths.get(path);
        if (!Files.isDirectory(file)) {
            System.out.println(path + " - не папка");
            return;
        }

        ThisFileVisitor fw = new ThisFileVisitor();

        Files.walkFileTree(file, fw);

        System.out.format("Всего папок - %d\n", fw.getDirCount() - 1);
        System.out.format("Всего файлов - %d\n", fw.getFileCount());
        System.out.format("Общий размер - %d\n", fw.getByteCount());

    }

    static class ThisFileVisitor extends SimpleFileVisitor<Path> {

        private int dirCount = 0;
        private int fileCount = 0;
        private long byteCount = 0;

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            fileCount++;
            byteCount += Files.size(file);
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            dirCount++;
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
            return FileVisitResult.CONTINUE;
        }

        public int getDirCount() {
            return dirCount;
        }

        public int getFileCount() {
            return fileCount;
        }

        public long getByteCount() {
            return byteCount;
        }
    }

}
