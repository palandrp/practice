package com.javarush.test.level10.lesson11.home08;

import java.util.ArrayList;

/* Массив списков строк
Создать массив, элементами которого будут списки строк. Заполнить массив любыми данными и вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<String>[] arrayOfStringList =  createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList()
    {
        ArrayList<String> arrl1 = new ArrayList<String>();
        arrl1.add("мама мыла раму");
        arrl1.add("лебедь рак и щука");
        ArrayList<String> arrl2 = new ArrayList<String>();
        arrl2.add("клара у карла украла");
        arrl2.add("карл у клары клорнет");
        ArrayList<String> arrl3 = new ArrayList<String>();
        arrl3.add("шла саша по шоссе");
        arrl3.add("сосала сушку");

        ArrayList[] arr = new ArrayList[]{arrl1, arrl2, arrl3};
        return arr;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList)
    {
        for (ArrayList<String> list: arrayOfStringList)
        {
            for (String s : list)
            {
                System.out.println(s);
            }
        }
    }
}