package com.example.BinarySearch;

/**
 * 367. Valid Perfect Square
 * 判断一个数是否为一个整数的平方(不使用Math.sqrt)
 *
 * @author Steph
 * @date 2020/2/19 9:34
 */
public class Solution367 {
    /**
     * 二分法
     *
     * @param num 整数值
     * @return 是否为一个整数的平方
     */
    public boolean isPerfectSquare(int num) {
        if (num == 0 || num == 1) return true;
        int l = 1, r = num;
        while (l <= r) {
            int m = (l + r) / 2;
            if (m == num / m) {
                return num % m == 0;
            } else if (m > num / m) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return false;
    }
}
