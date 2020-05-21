package com.example.String;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution17 {

    private static final String[] TAB = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        LinkedList<String> res = new LinkedList<>();
        if (digits.length() == 0) {
            return res;
        }
        res.add("");
        for (int i = 0; i < digits.length(); i++) {
            int v = Character.getNumericValue(digits.charAt(i));
            while (res.peek().length() == i) {
                String f = res.remove();
                for (char c : TAB[v].toCharArray()) {
                    res.addLast(f + c);
                }
            }
        }
        return res;
    }

    public List<String> letterCombinations2(String digits) {
        List<String> res = new LinkedList<>();
        if (digits.length() == 0) {
            return res;
        }
        combine("", digits, 0, res);
        return res;
    }

    private void combine(String prefix, String digits, int level, List<String> res) {
        if (level >= digits.length()) {
            res.add(prefix);
            return;
        }
        int v = Character.getNumericValue(digits.charAt(level));
        for (char c : TAB[v].toCharArray()) {
            combine(prefix + c, digits, level + 1, res);
        }
    }

    public static void main(String[] args) {

    }
}
