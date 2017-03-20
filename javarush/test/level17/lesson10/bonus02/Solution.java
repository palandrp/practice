package com.javarush.test.level17.lesson10.bonus02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD 2
CrUD Batch - multiple Creation, Updates, Deletion
!!!РЕКОМЕНДУЕТСЯ выполнить level17.lesson10.bonus01 перед этой задачей!!!

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
-u  - обновляет соответствующие данные людей с заданными id
-d  - производит логическое удаление всех людей с заданными id
-i  - выводит на экран информацию о всех людях с заданными id: name sex bd

id соответствует индексу в списке
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople
Порядок вывода данных соответствует вводу данных
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных)
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    private static SimpleDateFormat bd = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
    private static SimpleDateFormat bdOutput = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
    private static Date birthday;
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException{
        if (args[0].equals("-c")) {
            for (int i = 1; i < args.length; i += 3) {
                argsC(args[i], args[i+1], args[i+2]);
            }
        }

        else if (args[0].equals("-u")) {
            for (int i = 1; i < args.length; i += 4) {
                argsU(args[i], args[i+1], args[i+2], args[i+3]);
            }
        }

        else if (args[0].equals("-d")) {
            for (int i = 1; i < args.length; i++) {
                argsD(args[i]);
            }
        }
        else if (args[0].equals("-i")) {
            for (int i = 1; i < args.length; i++) {
                argsI(args[i]);
            }
        }
    }

    public static void argsC(String name, String sex, String date) throws ParseException {
        birthday = bd.parse(date);
        if (sex.equals("м")) allPeople.add(Person.createMale(name, birthday));
        else if (sex.equals("ж")) allPeople.add(Person.createFemale(name, birthday));
        System.out.println(allPeople.size() - 1);
    }

    public static void argsU(String id, String name, String sex, String date) throws ParseException {
        birthday = bd.parse(date);
        Person p = allPeople.get(Integer.parseInt(id));
        p.setBirthDay(birthday);
        p.setName(name);
        if (sex.equals("м")) p.setSex(Sex.MALE);
        else if (sex.equals("ж")) p.setSex(Sex.FEMALE);
    }

    public static void argsD(String id) {
        allPeople.set(Integer.parseInt(id), null);
    }

    public static void argsI(String id) {
        Person a = allPeople.get(Integer.parseInt(id));
        String sex = "0";
        if (a.getSex().equals(Sex.MALE)) sex = "м";
        else if (a.getSex().equals(Sex.FEMALE)) sex = "ж";
        System.out.println(a.getName() + " " + sex + " " + bdOutput.format(a.getBirthDay()));
    }
}
