package com.example.DFS;

import java.util.*;

/**
 * 51. N-Queens
 * Note: DFS写法
 * @author Steph
 * @date 2020/2/19 17:08
 */
public class Solution51 {
    private int n;  // 将输入n作为全局变量
    private Set<Integer> col, sum, dif; // 行,撇,捺 状态
    private List<List<String>> result;  // 存结果

    public List<List<String>> solveNQueens(int n) {
        init(n);
        dfs(new String[n], 0);
        return result;
    }

    private void init(int inpN) {
        n = inpN;
        result = new ArrayList<>();
        col = new HashSet<>();
        sum = new HashSet<>();
        dif = new HashSet<>();
    }

    private void dfs(String[] curRows, int r) {
        if (r == n) {
            result.add(Arrays.asList(curRows.clone()));
        } else {
            for (int c = 0; c < n; c++) {
                int id1 = r + c, id2 = r - c;
                if (col.contains(c) || sum.contains(id1) || dif.contains(id2))
                    continue;
                char[] row = new char[n];
                Arrays.fill(row, '.');
                row[c] = 'Q';
                curRows[r] = new String(row);
                col.add(c);
                sum.add(id1);
                dif.add(id2);
                dfs(curRows, r + 1);
                col.remove(c);
                sum.remove(id1);
                dif.remove(id2);
            }
        }
    }
}
