package BitManipulation;

/**
 * 191. Number of 1 Bits
 *
 * @author Steph
 * @date 2020/2/19 15:21
 */
public class Solution191 {
    /**
     * you need to treat n as an unsigned value
     * Note: n & (n-1) -> 将最后一位1变为0
     *
     * @param n 正整数n
     * @return n对应二进制中1的个数
     */
    public int hammingWeight(int n) {
        int res = 0;
        for (; n != 0; n &= n - 1)
            ++res;
        return res;
    }
}
