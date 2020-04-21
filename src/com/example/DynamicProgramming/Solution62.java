package com.example.DynamicProgramming;

import java.util.Arrays;

public class Solution62 {

    public static int uniquePaths(int m, int n) {
        if (m <= 1 || n <= 1) {
            return 1;
        }
        int[][] dp = new int[m][n];
        dp[m - 1][n - 1] = 0;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 || j == n - 1) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
                }
            }
        }
        return dp[0][0];
    }

    public static int uniquePathsPlus(int m, int n) {
        if (m <= 1 || n <= 1) {
            return 1;
        }
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (j == n - 1) {
                    dp[j] = 1;
                } else {
                    dp[j] = dp[j + 1] + dp[j];
                }
            }
        }
        return dp[0];
    }

}
