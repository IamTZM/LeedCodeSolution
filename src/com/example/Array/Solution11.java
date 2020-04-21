package com.example.Array;

public class Solution11 {

    public static int maxArea(int[] height) {
        if (height == null || height.length <= 1) {
            return 0;
        }
        int l = 0, r = height.length - 1, res = 0;
        while (l < r) {
            int minHeight = Math.min(height[l], height[r]);
            int width = r - l;
            res = Math.max(res, minHeight * width);
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}
