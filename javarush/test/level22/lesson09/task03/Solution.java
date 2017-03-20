package com.javarush.test.level22.lesson09.task03;

import com.sun.corba.se.impl.orbutil.graph.Graph;

import java.io.File;
import java.io.IOException;
import java.util.*;

/* Составить цепочку слов
В методе main считайте с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставить все слова в таком порядке,
чтобы последняя буква данного слова совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Метод getLine должен возвращать любой вариант.
Слова разделять пробелом.
В файле не обязательно будет много слов.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн

Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена
*/
public class Solution {
    public static void main(String[] args) throws IOException{

        Scanner in = new Scanner(System.in);
        String file = in.nextLine();
        in.close();
        ArrayList<String> arr = new ArrayList<>();

        Scanner fin = new Scanner(new File(file));
        while (fin.hasNext()) {
            arr.add(fin.next());
        }
        String[] words = new String[arr.size()];
        arr.toArray(words);

        StringBuilder result = getLine(words);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        StringBuilder sb = new StringBuilder();
        if (words == null || words.length < 1) return sb;
        boolean correct = false;

        while (!correct) {
            List<String> arr = new ArrayList<>();
            Collections.addAll(arr, words);
            sb.setLength(0);
            Collections.shuffle(arr);
            int wordscount = 0;

            sb.append(arr.get(0));
            sb.append(" ");

            for (int i = 1; i < words.length; i++) {
                if (arr.get(i) == null) continue;
                String a = arr.get(i).toLowerCase();
                if (a.charAt(0) == Character.toLowerCase(sb.charAt(sb.length() - 2))) {
                    sb.append(arr.get(i) + " ");
                    arr.set(i, null);
                    i = 0;
                    wordscount++;
                }
            }
            if (wordscount == words.length - 1) correct = true;
        }
        return sb;
    }

}
