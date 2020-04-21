package com.example.String;

public class Solution5 {

    public static String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        int len = s.length(), start = 0, end = 0, maxLen = 1;
        char[] arr = s.toCharArray();
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len - 1; i++) {
            for (int j = i; j < len; j++) {
                dp[i][j] = arr[i] == arr[j] && (j - i <= 2 || dp[i + 1][j - 1]);
                if (dp[i][j] && (j - i + 1 > maxLen)) {
                    start = i;
                    end = j;
                    maxLen = j - i + 1;
                }
            }
        }
        return s.substring(start, end + 1);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }
}
