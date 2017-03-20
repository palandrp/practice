package com.javarush.test.level19.lesson10.bonus03;

/* Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат
Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span><span>Super</span><span>girl</span>
Первым параметром в метод main приходит тег. Например, "span"
Вывести на консоль все теги, которые соответствуют заданному тегу
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле
Количество пробелов, \n, \r не влияют на результат
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нету
Тег может содержать вложенные теги
Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>
<span>Super</span>
<span>girl</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми
*/
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution {

    public static void main(String[] args) throws IOException {

        String SEEK = args[0];
        int LENGTH = SEEK.length() + 3;

        Scanner f = new Scanner(System.in);
        String file = f.nextLine();
        f.close();

        BufferedReader in = new BufferedReader(new FileReader(file));
        StringBuilder full = new StringBuilder();
        while (in.ready()) {
            full.append(in.readLine());
        }
        String line = full.toString().replaceAll("[\\r\\n]", "");
        in.close();

        TreeMap<Integer, Tag> map = new TreeMap<>();

        for (int i = 0; i < line.length(); i++) {
            i = line.indexOf("<" + SEEK, i);
            if (i != -1) map.put(i, Tag.OPEN);
            else break;
        }

        for (int i = 0; i < line.length(); i++) {
            i = line.indexOf("</" + SEEK , i);
            if (i != -1) map.put(i, Tag.CLOSE);
            else break;
        }

        int openCount;
        int closeCount;

        for (Map.Entry<Integer, Tag> pair : map.entrySet()) {
            if (pair.getValue() == Tag.OPEN) {
                openCount = 1;
                closeCount = 0;
                int close = pair.getKey();
                while (openCount != closeCount) {
                    close = map.higherEntry(close).getKey();
                    if (map.get(close) == Tag.OPEN) openCount++;
                    else if (map.get(close) == Tag.CLOSE) closeCount++;
                }
                System.out.println(line.substring(pair.getKey(), close + LENGTH));
            }
        }
    }

    private enum Tag {
        OPEN, CLOSE
    }
}
