package com.example.Array;

import java.util.Arrays;

/**
 * 88. Merge Sorted com.example.Array
 * 描述：给定两个有序数组nums1和nums2，把nums2合并到nums1中且保证有序
 */
public class Sloution88 {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0 && n >= 0) {
            System.arraycopy(nums2, 0, nums1, 0, n);
            return;
        }
        int i = m - 1, j = n - 1, p = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[p--] = nums1[i--];
            }else{
                nums1[p--] = nums2[j--];
            }
        }
        while (j >= 0) {
            nums1[p--] = nums2[j--];
        }
    }

    public static void main(String[] args) {
        int[] a = {2,0};
        int[] b = {1};
        merge(a, 1, b, 1);
        System.out.println(Arrays.toString(a));
    }
}
