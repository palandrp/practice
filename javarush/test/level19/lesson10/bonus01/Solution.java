package com.javarush.test.level19.lesson10.bonus01;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* Отслеживаем изменения
Считать в консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
Пример:
оригинальный   редактированный    общий
file1:         file2:             результат:(lines)

строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка4                           REMOVED строка4
строка5        строка5            SAME строка5
строка0                           ADDED строка0
строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка5                           ADDED строка5
строка4        строка4            SAME строка4
строка5                           REMOVED строка5
*/

public class Solution {

    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        String file1 = in.nextLine();
        String file2 = in.nextLine();
        in.close();

        Scanner in1 = new Scanner(new File(file1));
        Scanner in2 = new Scanner(new File(file2));

        List<String> line1 = new ArrayList<>();
        List<String> line2 = new ArrayList<>();

        while(in1.hasNext()) {
            line1.add(in1.nextLine());
        }
        while(in2.hasNext()) {
            line2.add(in2.nextLine());
        }

        in1.close();
        in2.close();

        for (int i = 0, j = 0; i < line1.size() && j < line2.size(); i++, j++) {
            if (line1.get(i).equals(line2.get(j))) lines.add(new LineItem(Type.SAME, line1.get(i)));

            else if (i + 1 < line1.size() && line1.get(i+1).equals(line2.get(j))) {
                lines.add(new LineItem(Type.REMOVED, line1.get(i)));
                i++;
                lines.add(new LineItem(Type.SAME, line1.get(i)));
            }

            else if (j + 1 < line2.size() && line1.get(i).equals(line2.get(j+1))) {
                lines.add(new LineItem(Type.ADDED, line2.get(j)));
                j++;
                lines.add(new LineItem(Type.SAME, line2.get(j)));
            }

            if (i == line1.size() - 1 && j != line2.size() - 1) {
                lines.add(new LineItem(Type.ADDED, line2.get(j+1)));
            }

            else if (i != line1.size() - 1 && j == line2.size() - 1) {
                lines.add(new LineItem(Type.ADDED, line1.get(i+1)));
            }

        }

        for (LineItem a : lines) {
            System.out.println(a.type + ": " + a.line);
        }

    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
