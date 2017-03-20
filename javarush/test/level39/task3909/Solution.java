package com.javarush.task.task39.task3909;

/* 
Одно изменение
*/
public class Solution {
    public static void main(String[] args) {
        isOneEditAway("gjfkdls", "rivndvd");
    }

    public static boolean isOneEditAway(String first, String second) {
        if (first.length() == 0 && second.length() == 0) return true;
        if (first.length() == 0) return second.length() == 1;
        if (second.length() == 0) return first.length() == 1;
        int[][] arr = new int[first.length() + 1][second.length() + 1];
        for (int i = 0; i <= first.length(); i++) {
            arr[i][0] = i;
        }
        for (int i = 0; i <= second.length(); i++) {
            arr[0][i] = i;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[i].length; j++) {
                arr[i][j] = Math.min(Math.min(arr[i][j-1] + 1, arr[i-1][j] + 1), arr[i-1][j-1] + check(first.charAt(i-1), second.charAt(j-1)));
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        if (arr[first.length()][second.length()] <= 1) return true;
        return false;
    }

    public static int check(char a, char b) {
        if (a == b) return 0;
        return 1;
    }
}
