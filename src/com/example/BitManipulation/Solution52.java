package com.example.BitManipulation;

/**
 * 52. N-Queens II
 * Note: 位运算写法
 * @author Steph
 * @date 2020/2/19 22:15
 */
public class Solution52 {
    private int res;    // 存计数结果

    public int totalNQueens(int n) {
        if (n < 0) return 0;
        res = 0;
        DFS(n, 0, 0, 0, 0);
        return res;
    }

    private void DFS(int n, int row, int col, int pie, int na) {
        // 递归终止
        if (row >= n) {
            res++;
            return;
        }
        // 找到可用位置, 可用bit位, 否则为0
        int bits = (~(col | pie | na)) & ((1 << n) - 1);
        while (bits != 0) {
            // 拿到最右一位
            int p = bits & -bits;
            // 搜索下一层, 对不可用位置进行标记
            DFS(n, row + 1, col | p, (pie | p) << 1, (na | p) >> 1);
            // 最右一位置位0
            bits &= bits - 1;
        }
    }
}
