package com.example.String;

/**
 * 43. Multiply Strings
 */
public class Solution43 {
    public String multiply(String num1, String num2) {
        int l1 = num1.length(), l2 = num2.length();
        int[] pos = new int[l1 + l2];
        for (int i = l1 - 1; i >= 0; i--) {
            for (int j = l2 - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + pos[p2];
                pos[p1] += sum / 10;
                pos[p2] = sum % 10;
            }
        }
        StringBuilder res = new StringBuilder();
        for (int p : pos) {
            if (!(res.length() == 0 && p == 0)) {
                res.append(p);
            }
        }
        return res.length() == 0 ? "0" : res.toString();
    }
}
