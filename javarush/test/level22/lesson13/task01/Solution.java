package com.javarush.test.level22.lesson13.task01;

import java.util.ArrayList;
import java.util.StringTokenizer;

/* StringTokenizer
Используя StringTokenizer разделить query на части по разделителю delimiter.
Пример,
getTokens("level22.lesson13.task01", ".") == {"level22", "lesson13", "task01"}
*/
public class Solution {
    public static String [] getTokens(String query, String delimiter) {

        StringTokenizer str = new StringTokenizer(query, delimiter);
        String[] got = new String[str.countTokens()];
        for (int i = 0; i < got.length; i++) {
            got[i] = str.nextToken();
        }
        return got;
    }

    public static void main(String[] args) {
        String[] test = getTokens("level22.lesson13.task01", ".");
        for (String a: test) {
            System.out.println(a);
        }
    }
}
