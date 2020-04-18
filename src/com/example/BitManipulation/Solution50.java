package com.example.BitManipulation;

/**
 * 50. Pow(x, n)
 */
public class Solution50 {
    /**
     * 50. Pow(x, n) 方法2 位运算
     *
     * @param x 底数
     * @param n 指数
     * @return 幂值
     */
    public static double myPow(double x, int n) {
        if (n == 0)
            return 1d;
        if (n == Integer.MIN_VALUE)
            return 1 / myPow(x * x, n >>> 1);
        if (n < 0)
            return 1 / myPow(x, -n);
        if ((n & 1) == 1)
            return x * myPow(x, n - 1);
        return myPow(x * x, n >>> 1);
    }
}
