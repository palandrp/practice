package com.javarush.test.level18.lesson10.home08;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (true) {
            String line = in.nextLine();
            if (line.equals("exit")) break;
            else new ReadThread(line).start();
        }
        in.close();
    }

    public static class ReadThread extends Thread {
        String fileName;
        Map<Integer, Integer> map = new HashMap<>();
        int key = 0;
        int value = 0;

        public ReadThread(String fileName) {
            this.fileName = fileName;
        }

        @Override
        public void run() {
            try {
                FileInputStream in = new FileInputStream(fileName);
                while (in.available() > 0) {
                    int a = in.read();
                    if (map.containsKey(a)) map.put(a, map.get(a) + 1);
                    else map.put(a, 1);
                }
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
                if (pair.getValue() > value) {
                    value = pair.getValue();
                    key = pair.getKey();
                }
            }

            resultMap.put(fileName, key);
        }
    }
}
