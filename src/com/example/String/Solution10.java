package com.example.String;


public class Solution10 {

    public static boolean isMatch(String s, String p) {
        char[] sArr = s.toCharArray();
        char[] pArr = p.toCharArray();
        int sLen = sArr.length, pLen = pArr.length;
        boolean[][] dp = new boolean[sLen + 1][pLen + 1];
        dp[0][0] = true;
        for (int i = 0; i < pArr.length; i++) {
            if (pArr[i] == '*' && dp[0][i - 1]) {
                dp[0][i + 1] = true;
            }
        }
        for (int i = 0; i < sLen; i++) {
            for (int j = 0; j < pLen; j++) {
                if (pArr[j] == '.' || pArr[j] == sArr[i]) {
                    dp[i + 1][j + 1] = dp[i][j];
                }
                if (pArr[j] == '*') {
                    if (pArr[j - 1] != '.' && pArr[j - 1] != sArr[i]) {
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    } else {
                        dp[i + 1][j + 1] = (dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j - 1]);
                    }
                }
            }
        }
        return dp[sLen][pLen];
    }

    public static void main(String[] args) {
        System.out.println(isMatch("aab", "c*a*b"));
    }
}
