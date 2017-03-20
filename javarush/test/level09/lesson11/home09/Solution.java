package com.javarush.test.level09.lesson11.home09;

import java.util.*;

/* Десять котов
Создать класс кот – Cat, с полем «имя» (String).
Создать словарь Map(<String, Cat>) и добавить туда 10 котов в виде «Имя»-«Кот».
Получить из Map множество(Set) всех имен и вывести его на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap()
    {
        TreeMap<String, Cat> map = new TreeMap<>();
        map.put("a", new Cat("a"));
        map.put("b", new Cat("b"));
        map.put("c", new Cat("c"));
        map.put("d", new Cat("d"));
        map.put("e", new Cat("e"));
        map.put("f", new Cat("f"));
        map.put("g", new Cat("g"));
        map.put("h", new Cat("h"));
        map.put("i", new Cat("i"));
        map.put("j", new Cat("j"));
        return map;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map)
    {
        return new LinkedHashSet<>(map.values());
    }

    public static void printCatSet(Set<Cat> set)
    {
        for (Cat cat:set)
        {
            System.out.println(cat);
        }
    }

    public static class Cat
    {
        private String name;

        public Cat(String name)
        {
            this.name = name;
        }

        public String toString()
        {
            return "Cat "+this.name;
        }
    }
}
