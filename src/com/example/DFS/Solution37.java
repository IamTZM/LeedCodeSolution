package com.example.DFS;

/**
 * 37. Sudoku Solver
 * @author Steph
 * @date 2020/2/19 17:00
 */
public class Solution37 {
    /**
     * @param board 输入字符表
     */
    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0) return;
        solve(board);
    }

    /**
     * 主要方法, 填入结果
     * @param board 输入字符表
     * @return 是否有解
     */
    private boolean solve(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') continue;
                for (char c = '1'; c <= '9'; c++) {
                    if (!valid(board, i, j, c)) continue;
                    board[i][j] = c;
                    if (solve(board)) return true;
                    else board[i][j] = '.';
                }
                return false;
            }
        }
        return true;
    }

    /**
     * 检查当前点是否有效
     * @param board
     * @param row
     * @param col
     * @param cur
     * @return
     */
    private boolean valid(char[][] board, int row, int col, char cur) {
        for (int i = 0; i < 9; i++) {
            // check row
            if (board[row][i] != '.' && board[row][i] == cur) return false;
            // check column
            if (board[i][col] != '.' && board[i][col] == cur) return false;
            // check block
            if (board[(row / 3) * 3 + i / 3][(col / 3) * 3 + i % 3] != '.'
                    && board[(row / 3) * 3 + i / 3][(col / 3) * 3 + i % 3] == cur)
                return false;
        }
        return true;
    }
}
