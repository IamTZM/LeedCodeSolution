package Queue;

import java.util.Deque;
import java.util.LinkedList;

public class Solution239 {

    /**
     * 239. Sliding Window Maximum 方法1
     *
     * @param nums 给定数组
     * @param k    给定窗口大小
     * @return 每次滑动窗口里的最大值
     */
    public static int[] maxSlidingWindow1(int[] nums, int k) {
        if (k == 0 || nums.length == 0)
            return new int[0];
        Deque<Integer> win = new LinkedList<>();
        Deque<Integer> res = new LinkedList<>();
        int l = nums.length;
        for (int i = 0; i < l; i++) {
            int v = nums[i];
            if (i >= k && win.getFirst() <= i - k)
                win.removeFirst();
            while (win.size() > 0 && nums[win.getLast()] <= v)
                win.removeLast();
            win.addLast(i);
            if (i >= k - 1)
                res.addLast(nums[win.getFirst()]);
        }
        int res_l = res.size();
        int[] arr = new int[res_l];
        for (int i = 0; i < res_l; i++) {
            arr[i] = res.removeFirst();
        }
        return arr;
    }

    /**
     * 239. Sliding Window Maximum 方法2 (推荐)
     *
     * @param nums 给定数组
     * @param k    给定窗口大小
     * @return 每次滑动窗口里的最大值
     */
    public static int[] maxSlidingWindow2(int[] nums, int k) {
        if (k == 0 || nums.length == 0)
            return new int[0];
        int maxi = -1;
        int[] res = new int[nums.length - k + 1];
        for (int left = 0, right = k - 1; right < nums.length; left++, right++) {
            if (maxi < left) {
                maxi = left;
                for (int i = left + 1; i <= right; i++)
                    if (nums[i] > nums[maxi])
                        maxi = i;
            } else if (nums[maxi] < nums[right])
                maxi = right;
            res[left] = nums[maxi];
        }
        return res;
    }

}
