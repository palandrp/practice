package com.javarush.task.task39.task3912;

/* 
Максимальная площадь
*/

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] sq = new int[][]{
                {1,1,1,1,1,0,0,1,1,1},
                {1,1,1,1,1,0,1,0,0,0},
                {1,1,1,1,1,0,1,0,0,0},
                {1,1,1,1,1,0,1,0,0,0},
                {1,1,1,1,1,1,1,0,0,0},
                {1,1,1,1,1,1,1,0,0,0},
                {1,1,1,1,1,1,1,0,0,0},
                {1,1,1,1,1,1,1,0,0,0},
                {1,1,1,1,1,1,1,0,0,0},
                {1,1,1,1,1,1,1,0,0,0}
        };
        System.out.println(s.maxSquare(sq));
    }

    public int maxSquare(int[][] matrix) {
        int maxRow = 0;
        int rowCount = 0;
        int begin = 0;
        boolean isSquare = false;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (isSquare) {
                    if (matrix[i][j] == 1) {
                        rowCount++;
                        if (rowCount > maxRow && checkSquare(i, begin, rowCount, matrix)) maxRow = rowCount;
                    }
                    else {
                        isSquare = false;
                        rowCount = 0;
                    }
                }
                else {
                    if (matrix[i][j] == 1) {
                        if (maxRow == 0) maxRow = 1;
                        isSquare = true;
                        begin = j;
                        rowCount++;
                    }
                }
            }
            isSquare = false;
            rowCount = 0;
        }
        return maxRow * maxRow;
    }

    public boolean checkSquare(int i, int begin, int rowCount, int[][] matrix) {
        try {
            for (int j = i; j < i + rowCount; j++) {
                for (int k = begin; k < begin + rowCount; k++) {
                    if (matrix[j][k] == 0) return false;
                }
            }
            return true;
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }
}
