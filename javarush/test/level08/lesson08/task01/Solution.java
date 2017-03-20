package com.javarush.test.level08.lesson08.task01;

import java.util.HashSet;
import java.util.Set;

/* 20 слов на букву «Л»
Создать множество строк (Set<String>), занести в него 20 слов на букву «Л».
*/

public class Solution
{
    public static HashSet<String> createSet()
    {
        HashSet<String> set = new HashSet<>();
        set.add("Лево");
        set.add("Левfо");
        set.add("Левоd");
        set.add("Левоs");
        set.add("Левоa");
        set.add("Левоn");
        set.add("Левоv");
        set.add("Левоc");
        set.add("Левоvc");
        set.add("Левоvb");
        set.add("Левgfо");
        set.add("Левоgh");
        set.add("Левjhо");
        set.add("Левоkj");
        set.add("Левоkl");
        set.add("Левоoi");
        set.add("Левоiu");
        set.add("Левоty");
        set.add("Левоyu");
        set.add("Левоtr");
        return set;
    }
}
