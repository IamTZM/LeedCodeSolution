package DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. Generate Parentheses
 *
 * @author Steph
 * @date 2020/2/19 15:47
 */
public class Solution22 {
    /**
     * n对括号可能的组合, 结果存入List
     *
     * @param n 正整数n
     * @return 结果列表
     */
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfs("", result, n, n);
        return result;
    }

    /**
     * dfs
     *
     * @param str   当前字符串
     * @param res   结果List
     * @param left  还有多少'('
     * @param right 还有多少')'
     */
    private void dfs(String str, List<String> res, int left, int right) {
        if (left == 0 && right == 0) {
            res.add(str);
            return;
        }
        if (left > 0)
            dfs(str + "(", res, left - 1, right);
        if (right > left)
            dfs(str + ")", res, left, right - 1);
    }
}
