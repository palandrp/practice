package com.javarush.task.task39.task3910;

/* 
isPowerOfThree
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(isPowerOfThree(3));
        System.out.println(isPowerOfThree(27));
        System.out.println(isPowerOfThree(81));
        System.out.println(isPowerOfThree(82));
    }

    public static boolean isPowerOfThree(int n) {
        if (n == 3 || n == 1) return true;
        int a = 3;
        while (a < n) {
            a = a * 3;
            if (a == n) return true;
            if (a > n || a < 0) break;
        }
        return false;
    }
}
