package com.javarush.task.task40.task4012;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

/* 
Полезные методы DateTime API
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static boolean isLeap(LocalDate date) {
        return date.isLeapYear();
    }

    public static boolean isBefore(LocalDateTime dateTime) {
        return dateTime.isBefore(LocalDateTime.now());
    }

    public static LocalTime addTime(LocalTime time, int n, ChronoUnit chronoUnit) {
        LocalTime newTime = time.plus(n, chronoUnit);
        return newTime;
    }

    public static Period getPeriodBetween(LocalDate firstDate, LocalDate secondDate) {
        return Period.between(firstDate.isAfter(secondDate) ? secondDate : firstDate, firstDate.isAfter(secondDate) ? firstDate : secondDate);
    }
}
