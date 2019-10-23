package com.han.leetcode.array;

public class SearchMatrixTarget {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };

        new SearchMatrixTarget().searchMatrix(matrix, -1);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0)
            return false;
        int i = 0;
        int j = matrix[0].length - 1;

        while (i < matrix.length && j > -1) {
            if (matrix[i][j] > target) {
                j--;
            } else if (matrix[i][j] < target) {
                i++;
            } else {
                System.out.println(matrix[i][j]);
                return true;
            }
        }
        System.out.println("Can't find target value.");
        return false;
    }
}
