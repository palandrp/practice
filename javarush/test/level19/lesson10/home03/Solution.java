package com.javarush.test.level19.lesson10.home03;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {
        Calendar cal = new GregorianCalendar();

        Scanner in = new Scanner(new File(args[0]));
        while(in.hasNext()) {
            String name = "";
            while(!in.hasNextInt()) {
                name += in.next() + " ";
            }
            name = name.trim();
            int day = in.nextInt();
            int month = in.nextInt() - 1;
            int year = in.nextInt();
            cal.set(year, month, day);
            PEOPLE.add(new Person(name, cal.getTime()));
        }

        in.close();
    }

}
