package com.javarush.test.level09.lesson11.home04;

import sun.java2d.pipe.SpanShapeRenderer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static java.util.Locale.ENGLISH;

/* Конвертер дат
Ввести с клавиатуры дату в формате «08/18/2013»
Вывести на экран эту дату в виде «AUG 18, 2013».
Воспользоваться объектом Date и SimpleDateFormat.
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        SimpleDateFormat add = new SimpleDateFormat("MM/dd/yyyy", ENGLISH);
        Date input = add.parse(in.readLine());
        add.applyPattern("MMM dd, yyyy");
        System.out.println(add.format(input).toUpperCase());
    }
}
