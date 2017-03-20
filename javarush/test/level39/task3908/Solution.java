package com.javarush.task.task39.task3908;

/* 
Возможен ли палиндром?
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(isPalindromePermutation("aaaaaab"));
        System.out.println(isPalindromePermutation("ababa"));
        System.out.println(isPalindromePermutation("ssssss"));
    }

    public static boolean isPalindromePermutation(String s) {
        if (s.length() <= 1) return true;
        String was = "";
        int odds = 0;
        for (int i = 0; i < s.length(); i++) {
            if (was.contains(String.valueOf(s.charAt(i)).toLowerCase())) continue;
            int count = 1;
            for (int j = i + 1; j < s.length(); j++) {
                if (Character.toLowerCase(s.charAt(i)) == Character.toLowerCase(s.charAt(j))) count++;
            }
            if (count % 2 != 0) odds++;
            was += Character.toLowerCase(s.charAt(i));
        }
        if (odds > 1) return false;
        else return true;
    }
}
