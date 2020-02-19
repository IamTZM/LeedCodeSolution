package DFS;

import java.util.HashSet;
import java.util.Set;

/**
 * 52. N-Queens II
 * Note: DFS写法
 * @author Steph
 * @date 2020/2/19 22:08
 */
public class Solution52 {
    private int n, result;
    private Set<Integer> col, sum, dif;

    public int totalNQueens(int n) {
        init(n);
        dfs(0);
        return result;
    }

    private void init(int inpN) {
        n = inpN;
        result = 0;
        col = new HashSet<>();
        sum = new HashSet<>();
        dif = new HashSet<>();
    }

    private void dfs(int r) {
        if (r == n) {
            result++;
        } else {
            for (int c = 0; c < n; c++) {
                int id1 = r + c, id2 = r - c;
                if (col.contains(c) || sum.contains(id1) || dif.contains(id2))
                    continue;
                col.add(c);
                sum.add(id1);
                dif.add(id2);
                dfs(r + 1);
                col.remove(c);
                sum.remove(id1);
                dif.remove(id2);
            }
        }
    }
}
