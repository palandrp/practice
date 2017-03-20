package com.javarush.test.level22.lesson09.task02;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Формируем Where
Сформируйте часть запроса WHERE используя StringBuilder.
Если значение null, то параметр не должен попадать в запрос.
Пример:
{"name", "Ivanov", "country", "Ukraine", "city", "Kiev", "age", null}
Результат:
"name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'"
*/
public class Solution {

    public static StringBuilder getCondition(Map<String, String> params) {

        StringBuilder sb = new StringBuilder();

        for (Map.Entry<String, String> pair : params.entrySet()) {
            String key = pair.getKey();
            String value = pair.getValue();
            if (value != null && key != null) sb.append(key + " = '" + value + "' and ");
        }
        if (sb.length() > 5) sb.setLength(sb.length() - 5);
        return sb;
    }

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();

        System.out.println(getCondition(map).toString());
    }
}
