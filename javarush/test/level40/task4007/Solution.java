package com.javarush.task.task40.task4007;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* 
Работа с датами
*/

public class Solution {
    public static void main(String[] args) {
        printDate("21.4.2014 15:56:45");
        System.out.println();
        printDate("2.4.2014");
        System.out.println();
        printDate("17:33:40");
    }

    public static void printDate(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("d.M.yyyy HH:mm:ss");
        SimpleDateFormat sdf2 = new SimpleDateFormat("d.M.yyyy");
        SimpleDateFormat sdf3 = new SimpleDateFormat("HH:mm:ss");
        try {
            Date dt = sdf.parse(date);
            Calendar cal = Calendar.getInstance();
            cal.setTime(dt);
            System.out.println("День: " + cal.get(Calendar.DATE));
            System.out.println("День недели: " + (cal.get(Calendar.DAY_OF_WEEK) - 1));
            System.out.println("День месяца: " + cal.get(Calendar.DAY_OF_MONTH));
            System.out.println("День года: " + cal.get(Calendar.DAY_OF_YEAR));
            System.out.println("Неделя месяца: " + cal.get(Calendar.WEEK_OF_MONTH));
            System.out.println("Неделя года: " + cal.get(Calendar.WEEK_OF_YEAR));
            System.out.println("Месяц: " + (cal.get(Calendar.MONTH) + 1));
            System.out.println("Год: " + cal.get(Calendar.YEAR));
            System.out.println("AM или PM: " + (cal.get(Calendar.AM_PM) == 1 ? "PM" : "AM"));
            System.out.println("Часы: " + cal.get(Calendar.HOUR));
            System.out.println("Часы дня: " + cal.get(Calendar.HOUR_OF_DAY));
            System.out.println("Минуты: " + cal.get(Calendar.MINUTE));
            System.out.println("Секунды: " + cal.get(Calendar.SECOND));
            return;
        } catch (ParseException e) {}

        try {
            Date dt = sdf2.parse(date);
            Calendar cal = Calendar.getInstance();
            cal.setTime(dt);
            System.out.println("День: " + cal.get(Calendar.DAY_OF_WEEK_IN_MONTH));
            System.out.println("День недели: " + (cal.get(Calendar.DAY_OF_WEEK) - 1));
            System.out.println("День месяца: " + cal.get(Calendar.DAY_OF_MONTH));
            System.out.println("День года: " + cal.get(Calendar.DAY_OF_YEAR));
            System.out.println("Неделя месяца: " + cal.get(Calendar.WEEK_OF_MONTH));
            System.out.println("Неделя года: " + cal.get(Calendar.WEEK_OF_YEAR));
            System.out.println("Месяц: " + (cal.get(Calendar.MONTH) + 1));
            System.out.println("Год: " + cal.get(Calendar.YEAR));
            return;
        } catch (ParseException e) {
        }

        try {
            Date dt = sdf3.parse(date);
            Calendar cal = Calendar.getInstance();
            cal.setTime(dt);
            System.out.println("AM или PM: " + (cal.get(Calendar.AM_PM) == 1 ? "PM" : "AM"));
            System.out.println("Часы: " + cal.get(Calendar.HOUR));
            System.out.println("Часы дня: " + cal.get(Calendar.HOUR_OF_DAY));
            System.out.println("Минуты: " + cal.get(Calendar.MINUTE));
            System.out.println("Секунды: " + cal.get(Calendar.SECOND));
            return;
        } catch (ParseException e) {
        }
    }
}
