package com.example.Array;

public class Solution26 {

    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int p1 = 0, p2 = 1, len = nums.length;
        while (p2 < len) {
            while (p2 < len && nums[p1] == nums[p2]) {
                p2++;
            }
            if (p2 < len) {
                p1++;
                nums[p1]=nums[p2];
            }
        }
        return p1 + 1;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
    }
}
