package com.javarush.task.task40.task4009;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Locale;

/* 
Buon Compleanno!
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(weekDayOfBirthday("1.12.2015", "2016"));
    }

    public static String weekDayOfBirthday(String birthday, String year) {
        LocalDate date = LocalDate.parse(birthday, DateTimeFormatter.ofPattern("d.M.yyyy"));
        Year yer = Year.parse(year);
        LocalDate newDate = date.with(yer);
        return newDate.format(DateTimeFormatter.ofPattern("cccc", Locale.ITALIAN));
    }
}
