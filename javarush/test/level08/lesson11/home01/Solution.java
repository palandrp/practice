package com.javarush.test.level08.lesson11.home01;

import java.util.HashSet;
import java.util.Set;

/* Set из котов
1. Внутри класса Solution создать public static класс кот – Cat.
2. Реализовать метод createCats, он должен создавать множество (Set) котов и добавлять в него 3 кота.
3. В методе main удалите одного кота из Set cats.
4. Реализовать метод printCats, он должен вывести на экран всех котов, которые остались во множестве. Каждый кот с новой строки.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Set<Cat> cats = createCats();
        int count = 0;
        for (Cat a: cats)
        {
            count++;
            if (count == 3) cats.remove(a);
        }

        printCats(cats);
    }

    public static Set<Cat> createCats()
    {
        HashSet<Cat> set = new HashSet<>();
        Cat a = new Cat("bats");
        set.add(a);
        Cat b = new Cat("bots");
        set.add(b);
        Cat c = new Cat("buts");
        set.add(c);
        return set;
    }

    public static void printCats(Set<Cat> cats)
    {
        for (Cat a: cats)
        {
            System.out.println(a);
        }
    }

    public static class Cat {
        private String name;
        public Cat(String name) {
            this.name = name;
        }
    }
}
