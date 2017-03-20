package com.javarush.task.task36.task3605;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.TreeSet;

/* 
Использование TreeSet
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        TreeSet<Character> set = new TreeSet<Character>();
        Path file = Paths.get(args[0]);
        List<String> list = Files.readAllLines(file);
        for (String s : list) {
            StringReader sr = new StringReader(s);
            int i;
            while ((i = sr.read()) != -1) {
                if (Character.isAlphabetic(i)) set.add(Character.toLowerCase((char) i));
            }
        }

        for (int j = 0; j < 5; j++) {
            try {
                char a = set.pollFirst();
                System.out.print(a);
            } catch (NullPointerException ignored){};
        }
    }
}
