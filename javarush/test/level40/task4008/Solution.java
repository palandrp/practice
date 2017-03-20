package com.javarush.task.task40.task4008;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Работа с Java 8 DateTime API
*/

public class Solution {
    public static void main(String[] args) {
        printDate("21.4.2014 15:56:45");
        System.out.println();
        printDate("21.4.2014");
        System.out.println();
        printDate("17:33:40");
    }

    public static void printDate(String date) {
        String pattern2 = "(\\d\\d.\\d.\\d\\d\\d\\d)";
        String pattern3 = "(\\d\\d:\\d\\d:\\d\\d)";

        Matcher m = Pattern.compile(pattern2).matcher(date);

        if (m.find()) {
            LocalDate ldt = LocalDate.parse(m.group(), DateTimeFormatter.ofPattern("d.M.yyyy"));
            System.out.println("День: " + ldt.getDayOfMonth());
            System.out.println("День недели: " + ldt.getDayOfWeek().getValue());
            System.out.println("День месяца: " + ldt.getDayOfMonth());
            System.out.println("День года: " + ldt.getDayOfYear());
            System.out.println("Неделя месяца: " + (ldt.get(ChronoField.ALIGNED_WEEK_OF_MONTH) + 1));
            System.out.println("Неделя года: " + (ldt.get(ChronoField.ALIGNED_WEEK_OF_YEAR) + 1));
            System.out.println("Месяц: " + (ldt.getMonthValue()));
            System.out.println("Год: " + ldt.getYear());
        }

        m.usePattern(Pattern.compile(pattern3));

        if (m.find()) {
            LocalTime ldt = LocalTime.parse(m.group(), DateTimeFormatter.ISO_TIME);
            System.out.format("AM или PM: %s%n", (1 == (ldt.get(ChronoField.AMPM_OF_DAY)) ? "PM" : "AM"));
            System.out.format("Часы: %d%n", ldt.get(ChronoField.HOUR_OF_AMPM));
            System.out.format("Часы дня: %d%n", ldt.get(ChronoField.HOUR_OF_DAY));
            System.out.format("Минуты: %d%n", ldt.get(ChronoField.MINUTE_OF_HOUR));
            System.out.format("Секунды: %d%n", ldt.get(ChronoField.SECOND_OF_MINUTE));
        }

    }
}
