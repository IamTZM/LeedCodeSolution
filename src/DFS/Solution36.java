package DFS;

/**
 * 36. Valid Sudoku
 *
 * @author Steph
 * @date 2020/2/19 16:12
 */
public class Solution36 {
    /**
     * 遍历到每一个点
     *
     * @param board 字符表
     * @return 是否合法
     */
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length == 0) return false;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                if (!valid(board, i, j, board[i][j]))
                    return false;
            }
        }
        return true;
    }

    /**
     * 检查当前点是否有效
     *
     * @param board 字符表
     * @param row   行
     * @param col   列
     * @param cur   当前字符
     * @return 是否有效
     */
    private boolean valid(char[][] board, int row, int col, char cur) {
        for (int i = 0; i < 9; i++) {
            // check row
            if (i != col && board[row][i] != '.' && board[row][i] == cur) return false;
            // check column
            if (i != row && board[i][col] != '.' && board[i][col] == cur) return false;
            // exclude current point
            if (row == (row / 3) * 3 + i / 3 && col == (col / 3) * 3 + i % 3) continue;
            // check block
            if (board[(row / 3) * 3 + i / 3][(col / 3) * 3 + i % 3] != '.'
                    && board[(row / 3) * 3 + i / 3][(col / 3) * 3 + i % 3] == cur)
                return false;
        }
        return true;
    }
}
