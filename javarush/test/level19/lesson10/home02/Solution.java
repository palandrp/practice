package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        HashMap<String, Double> map = new HashMap<>();
        Scanner in = new Scanner(new File(args[0]));

        while (in.hasNext()) {
            String name = in.next();
            Double amount = in.nextDouble();

            if (map.containsKey(name)) {map.put(name, map.get(name) + amount);}
            else map.put(name, amount);
        }

        String rich = "";
        double max = 0;

        for (Map.Entry<String, Double> pair : map.entrySet()) {
            if (pair.getValue() > max) max = pair.getValue();
        }

        for (Map.Entry<String, Double> pair : map.entrySet()) {
            if (pair.getValue() == max) System.out.println(pair.getKey());
        }

        in.close();
    }
}
