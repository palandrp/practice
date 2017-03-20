package com.javarush.test.level08.lesson08.task02;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/* Удалить все числа больше 10
Создать множество чисел(Set<Integer>), занести туда 20 различных чисел.
Удалить из множества все числа больше 10.
*/

public class Solution
{
    public static void main(String[] args) {
        HashSet<Integer> set = createSet();
        HashSet<Integer> set2 = remove(set);
        System.out.println(set2);
    }

    public static HashSet<Integer> createSet()
    {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < 20; i++)
        {
            set.add(i);
        }
        return set;
    }

    public static HashSet<Integer> remove(HashSet<Integer> set)
    {
        HashSet<Integer> temp = new HashSet<>();
        for (Integer one : set)
        {
            if (one > 10) temp.add(one);
        }
        set.removeAll(temp);
        return set;
    }
}
