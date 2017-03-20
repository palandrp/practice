package com.javarush.test.level08.lesson08.task05;

import java.util.HashMap;
import java.util.Map;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class Solution
{
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

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair: copy.entrySet()) {
            String nameOne = pair.getValue();
            int count = 0;
            for (Map.Entry<String, String> pairTwo: copy.entrySet()) {
                if (pairTwo.getValue() == nameOne) count++;
            }
            if (count >= 2) removeItemFromMapByValue(map, nameOne);
        }
    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair: copy.entrySet())
        {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }

}
