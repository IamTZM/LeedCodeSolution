package Matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. Spiral Matrix
 */
public class Solution54 {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return res;
        }
        int n = matrix.length, m = matrix[0].length;
        int rowBegin = 0, colBegin = 0;
        int rowEnd = n - 1, colEnd = m - 1;
        while (res.size() < n * m) {
            // right
            for (int i = colBegin; i <= colEnd && res.size() < n * m; i++) {
                res.add(matrix[rowBegin][i]);
            }
            rowBegin++;
            // down
            for (int i = rowBegin; i <= rowEnd && res.size() < n * m; i++) {
                res.add(matrix[i][colEnd]);
            }
            colEnd--;
            // left
            for (int i = colEnd; i >= colBegin && res.size() < n * m; i--) {
                res.add(matrix[rowEnd][i]);
            }
            rowEnd--;
            // up
            for (int i = rowEnd; i >= rowBegin && res.size() < n * m; i--) {
                res.add(matrix[i][colBegin]);
            }
            colBegin++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] m = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        List<Integer> list = spiralOrder(m);
        System.out.println(list.toString());
    }
}
