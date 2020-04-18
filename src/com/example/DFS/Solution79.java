package com.example.DFS;

/**
 * 79. Word Search
 * @author Steph
 * @date 2020/2/19 22:11
 */
public class Solution79 {
    private boolean flag = false;   // 全局标记

    public boolean exist(char[][] board, String word) {
        if (board.length == 0 || board[0].length == 0) return false;
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, "", word);
                if (flag) return true;
            }
        }
        return false;
    }

    private void dfs(char[][] board, int x, int y, String curStr, String word) {
        if (flag) return;
        char ch = board[x][y];
        curStr += ch;
        if (ch == '@') return;
        if (!word.startsWith(curStr)) return;
        if (word.equals(curStr)) {
            flag = true;
            return;
        }
        board[x][y] = '@';
        if (x < board.length - 1) dfs(board, x + 1, y, curStr, word);
        if (y < board[0].length - 1) dfs(board, x, y + 1, curStr, word);
        if (x > 0) dfs(board, x - 1, y, curStr, word);
        if (y > 0) dfs(board, x, y - 1, curStr, word);
        board[x][y] = ch;
    }
}
