package com.javarush.task.task34.task3411;

/* 
Ханойские башни
*/

public class Solution {
    static int abc = 0;

    public static void main(String[] args) {
        int count = 15;
        moveRing('A', 'B', 'C', count);
        System.out.println(abc);
    }

    public static void moveRing(char a, char b, char c, int count) {
        if (count == 1) {
            System.out.println("from " + a + " to " + b);
            abc++;

        }
        else {
            moveRing(a, c, b, count - 1);
            System.out.println("from " + a + " to " + b);
            abc++;
            moveRing(c, b, a, count - 1);
        }

    }
}