package com.javarush.test.level22.lesson09.task01;

import java.io.File;
import java.io.IOException;
import java.util.*;

/* Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Порядок слов first/second не влияет на тестирование.
Использовать StringBuilder.
Пример содержимого файла
рот тор торт о
о тот тот тот
Вывод:
рот тор
о о
тот тот
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        in.close();

        ArrayList<String> set = new ArrayList<>();

        Scanner file = new Scanner(new File(line));
        while (file.hasNext()) {
            set.add(file.next());
        }
        file.close();

        for (int i = 0; i < set.size();) {
            boolean flag = false;
            String sb = new StringBuilder(set.get(i)).reverse().toString();

            for (int j = i + 1; j < set.size();) {
                String s = set.get(j);
                String s1 = set.get(i);
                if (s.equals(sb)) {
                    Pair pa = new Pair(s, s1);
                    if (!result.contains(pa)) result.add(pa);
                    flag = true;
                    set.remove(j);
                    break;
                }
                j++;
            }

            if (flag) {
                set.remove(i);
            }
            else i++;
        }

        for (Pair p : result) {
            System.out.println(p);
        }

    }

    public static class Pair {
        String first;
        String second;

        public Pair(String f, String s) {
            first = f;
            second = s;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof Pair)) return false;
            Pair o = (Pair) obj;
            return ((o.first.equals(first) && o.second.equals(second)) || (o.first.equals(second) && o.second.equals(first)));
        }

        @Override
        public int hashCode() {
            return (31 * first.hashCode()) + second.hashCode();
        }
    }

}
