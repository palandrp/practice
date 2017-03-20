package com.javarush.test.level08.lesson08.task03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{
    public static void main (String[] args) {
        HashMap arg = createMap();
        int a = getCountTheSameFirstName(arg, "Петров");
        int b = getCountTheSameLastName(arg, "Сергей");
        System.out.println(a);
        System.out.println(b);
    }

    public static HashMap<String, String> createMap()
    {
        HashMap<String, String> map = new HashMap<>();
        map.put("Игорь","Малкин");
        map.put("Павел","Иванов");
        map.put("Олег","Петров");
        map.put("Сергей","Сидоров");
        map.put("Люся","Форточкина");
        map.put("Аня","Стрельникова");
        map.put("Антон","Никитин");
        map.put("Костя","Дружина");
        map.put("Росс","Геллер");
        map.put("Чендлер","Бинг");
        return map;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {
        int count = 0;
        for (Map.Entry<String, String> pair : map.entrySet())
        {
            String nam = pair.getValue();
            if (nam.equals(name)) count++;
        }
        return count;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName)
    {
        int count = 0;
        for (Map.Entry<String, String> pair : map.entrySet())
        {
            String nam = pair.getKey();
            System.out.println(nam);
            if (nam.equals(lastName)) count++;
        }
        return count;

    }
}
