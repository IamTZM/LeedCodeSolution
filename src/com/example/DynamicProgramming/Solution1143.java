package com.example.DynamicProgramming;

public class Solution1143 {

    public static int longestCommonSubsequence(String text1, String text2) {
        char[] t1 = text1.toCharArray();
        char[] t2 = text2.toCharArray();
        int l1 = t1.length, l2 = t2.length;
        int[] dp = new int[l2 + 1];
        for (int i = 1; i <= l1; i++) {
            int pre = dp[0];
            for (int j = 1; j <= l2; j++) {
                int tmp = dp[j];
                if (t1[i - 1] == t2[j - 1]) {
                    dp[j] = pre + 1;
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
                pre = tmp;
            }
        }
        return dp[l2];
    }

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abcde", "ace"));
    }
}
