package com.javarush.task.task37.task3714;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeMap;

/* 
Древний Рим
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input a roman number to be converted to decimal: ");
        String romanString = bufferedReader.readLine();
        System.out.println("Conversion result equals " + romanToInteger(romanString));
    }

    public static int romanToInteger(String s) {
        int result = 0;
        TreeMap<String, Integer> map = new TreeMap<String, Integer>();
            map.put("M", 1000);
            map.put("CM", 900);
            map.put("D", 500);
            map.put("CD", 400);
            map.put("C", 100);
            map.put("XC", 90);
            map.put("L", 50);
            map.put("XL", 40);
            map.put("X", 10);
            map.put("IX", 9);
            map.put("V", 5);
            map.put("IV", 4);
            map.put("I", 1);
        String sub = s;
        while (!s.isEmpty()) {
            Integer a = 0;
            try {
                a = map.get(s.substring(0, 2));
                if (a != null) {
                    result += a;
                    s = s.substring(2);
                    continue;
                }
            } catch (StringIndexOutOfBoundsException ignored) {}
            a = map.get(s.substring(0, 1));
            result += a;
            s = s.substring(1);
        }
        return result;
    }
}
