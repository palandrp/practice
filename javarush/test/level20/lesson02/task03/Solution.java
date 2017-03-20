package com.javarush.test.level20.lesson02.task03;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() {
        Scanner in = new Scanner(System.in);
        File file = new File(in.nextLine());
        in.close();
        try {
            FileInputStream fis = new FileInputStream(file);
            load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void save(OutputStream outputStream) throws Exception {
        Properties pr = new Properties();
        pr.putAll(properties);
        pr.store(outputStream, null);
    }

    public void load(InputStream inputStream) throws Exception {
        Properties pr = new Properties();
        pr.load(inputStream);
        for (Map.Entry pair : pr.entrySet()) {
            properties.put((String) pair.getKey(), (String) pair.getValue());
        }
    }
}
