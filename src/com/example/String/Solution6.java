package com.example.String;

import java.util.ArrayList;
import java.util.List;

public class Solution6 {

    public static String convert(String s, int numRows) {
        if (s == null || s.length() <= 2 || numRows == 1) {
            return s;
        }
        char[] c = s.toCharArray();
        int len = c.length;
        StringBuilder[] lines = new StringBuilder[numRows];
        for (int i = 0; i < lines.length; i++) {
            lines[i] = new StringBuilder();
        }
        int i = 0;
        while (i < len) {
            for (int idx = 0; idx < numRows && i < len; idx++) {
                lines[idx].append(c[i++]);
            }
            for (int idx = numRows - 2; idx >= 1 && i < len; idx--) {
                lines[idx].append(c[i++]);
            }
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder line : lines) {
            res.append(line);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 1));

    }


}
