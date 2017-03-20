package com.javarush.task.task30.task3012;

/* 
Получи заданное число
*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.createExpression(74);
    }

    public void createExpression(int number) {
        int current = number;
        StringBuilder sb = new StringBuilder();
        sb.append(number);
        sb.append(" = ");

        int[] arr = new int[]{1, 3, 9, 27, 81, 243, 729, 2187};
        int index = 0;

        while (current != 0) {
            int rem = current % 3;
            current = current / 3;
            if (rem != 0) {
                if (rem == 1) {
                    sb.append("+ ");
                }
                if (rem == 2) {
                    sb.append("- ");
                    current++;
                }
                sb.append(arr[index]);
                sb.append(" ");
            }
            index++;
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb.toString());
    }
}