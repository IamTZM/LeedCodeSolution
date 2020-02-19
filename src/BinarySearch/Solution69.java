package BinarySearch;

/**
 * 69. Sqrt(x)
 *
 * @author Steph
 * @date 2020/2/19 9:10
 */
public class Solution69 {
    /**
     * 方法1 二分法
     *
     * @param x 整数值
     * @return 开平方后取整
     */
    public int mySqrt1(int x) {
        if (x == 0 || x == 1) return x;
        int l = 1, r = x, res = 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (m == x / m) {
                return m;
            } else if (m > x / m) {
                r = m - 1;
            } else {
                l = m + 1;
                res = m;
            }
        }
        return res;
    }

    /**
     * 方法2 牛顿迭代法
     * 公式: X[n-1] = X[n] - f(X[n]) / f'(X[n])
     *
     * @param x 整数值
     * @return 开平方后取整
     */
    public int mySqrt2(int x) {
        long r = x;
        while (r > x / r)
            r = (r + x / r) / 2;
        return (int) r;
    }

    /**
     * 扩展sqrt 二分法
     *
     * @param x   浮点值
     * @param per 精度
     * @return 浮点值计算结果
     */
    public static double mySqrt3(double x, double per) {
        if (x == 0 || x == 1) return x;
        double l = 0d, r = x;
        double m = (l + r) / 2;
        while (Math.abs(x - m * m) > per) {
            if (m == x / m) {
                return m;
            } else if (m > x / m) {
                r = m;
            } else {
                l = m;
            }
            m = (l + r) / 2;
        }
        return m;
    }
}
