package com.javarush.test.level08.lesson03.task02;

/* HashMap из 10 пар
Создать коллекцию HashMap<String, String>, занести туда 10 пар строк:
арбуз - ягода, банан - трава, вишня - ягода, груша - фрукт, дыня - овощ, ежевика - куст, жень-шень - корень, земляника - ягода, ирис - цветок, картофель - клубень.
Вывести содержимое коллекции на экран, каждый элемент с новой строки.
Пример вывода (тут показана только одна строка):
картофель - клубень
*/
import java.util.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        Map<String, String> grows = new HashMap<>();
        grows.put("арбуз", "ягода");
        grows.put("банан", "трава");
        grows.put("вишня", "ягода");
        grows.put("груша", "фрукт");
        grows.put("дыня", "овощ");
        grows.put("ежевика", "куст");
        grows.put("жень-шень", "корень");
        grows.put("земляника", "ягода");
        grows.put("ирис", "цветок");
        grows.put("картофель", "клубень");


        for(Map.Entry<String, String> text : grows.entrySet())
        {
            String key = text.getKey();
            String value = text.getValue();
            System.out.println(key + " - " + value);
        }

    }
}
