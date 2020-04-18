package com.example.BitManipulation;

/**
 * 338. Counting Bits
 *
 * @author Steph
 * @date 2020/2/19 15:29
 */
public class Solution338 {
    /**
     * 输入正整数num, 返回[0..n]之间每个数对应二进制的1的位数
     * Note: n & (n-1) -> 将最后一位1变为0
     * Note: DP, 使用计算过的值来提高效率
     *
     * @param num 正整数num
     * @return 结果数组
     */
    public int[] countBits(int num) {
        int[] cnt = new int[num + 1];
        cnt[0] = 0;
        for (int i = 1; i <= num; i++)
            cnt[i] = cnt[i & (i - 1)] + 1;
        return cnt;
    }
}
