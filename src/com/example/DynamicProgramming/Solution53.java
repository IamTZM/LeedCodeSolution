package com.example.DynamicProgramming;

/**
 * 53. Maximum Subarray
 */
public class Solution53 {
    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int tmp = nums[0], res = nums[0];
        for (int i = 1; i < len; i++) {
            tmp = Math.max(tmp + nums[i], nums[i]);
            res = Math.max(res, tmp);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] tst = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(tst));
    }
}
