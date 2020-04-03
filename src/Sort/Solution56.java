package Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 56. Merge Intervals
 */
public class Solution56 {
    public static int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> res = new ArrayList<>();
        int[] tmp = intervals[0];
        res.add(tmp);
        int len = intervals.length;
       for (int[] interval : intervals) {
           if (interval[0] <= tmp[1]) {
               tmp[1] = Math.max(interval[1], tmp[1]);
           } else {
               tmp = interval;
               res.add(tmp);
           }
       }
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        int[][] tst = {{1,2},{2,6},{8,10},{15,18}};
        int[][] res = merge(tst);
        for (int[] a : res) {
            System.out.println(Arrays.toString(a));
        }
    }
}
