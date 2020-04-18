package com.example.Matrix;

/**
 * 74. Search a 2D com.example.Matrix
 * 描述：给定二维数组，每行从左到右递增，每列从上到下递增
 * 完成一个函数，输入二维数组和一个整数，判断数组中是否含有该整数
 */
public class Solution74 {
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int r = matrix.length, c = matrix[0].length;
        // 从右上角开始搜索
        int i = 0, j = c - 1;
        while (i < r && j >= 0) {
            if (matrix[i][j] > target) {
                --j;
            } else if (matrix[i][j] < target) {
                ++i;
            } else {
                // 找到
                return true;
            }
        }
        return false;
    }
}
