package BitManipulation;

/**
 * 231. Power of Two
 *
 * @author Steph
 * @date 2020/2/19 15:25
 */
public class Solution231 {
    /**
     * Note: n & (n-1) -> 将最后一位1变为0
     *
     * @param n 正整数n
     * @return n是否为2的幂
     */
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
