package com.javarush.test.level08.lesson08.task04;

import java.util.*;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution
{
    public static void main (String[] args) {
        HashMap add = createMap();
        remove(add);
        System.out.println(add);
    }

    public static HashMap<String, Date> createMap()
    {
        HashMap<String, Date> map = new HashMap<>();

        map.put("Stallone", new Date("JUNE 1 1980"));
        map.put("Stllone", new Date("JUNE 1 1980"));
        map.put("Stalljone", new Date("JUNE 1 1980"));
        map.put("Stkjallone", new Date("JUNE 1 1980"));
        map.put("Staljllone", new Date("OCTOBER 1 1980"));
        map.put("Stalgjlone", new Date("JUNE 1 1980"));
        map.put("Stabnllone", new Date("JUNE 1 1980"));
        map.put("Stallo,nne", new Date("JUNE 1 1980"));
        map.put("Stkballone", new Date("JUNE 1 1980"));
        map.put("Stnallone", new Date("JUNE 1 1980"));

        return map;

    }

    public static void remove(HashMap<String, Date> map)
    {
        HashMap<String, Date> temp = new HashMap<>(map);
        for(Map.Entry<String, Date> pair : temp.entrySet()) {
            if(pair.getValue().getMonth() == 5) map.remove(pair.getKey());
        }
    }
}
