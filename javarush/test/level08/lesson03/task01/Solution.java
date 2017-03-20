package com.javarush.test.level08.lesson03.task01;


/* HashSet из растений
Создать коллекцию HashSet с типом элементов String.
Добавить в неё 10 строк: арбуз, банан, вишня, груша, дыня, ежевика, жень-шень, земляника, ирис, картофель.
Вывести содержимое коллекции на экран, каждый элемент с новой строки.
Посмотреть, как изменился порядок добавленных элементов.
*/

import java.util.HashSet;
import java.util.Set;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        Set<String> grows = new HashSet<>();
        grows.add("арбуз");
        grows.add("банан");
        grows.add("вишня");
        grows.add("груша");
        grows.add("дыня");
        grows.add("ежевика");
        grows.add("жень-шень");
        grows.add("земляника");
        grows.add("ирис");
        grows.add("картофель");

        for(String text : grows)
        {
            System.out.println(text);
        }

    }
}
