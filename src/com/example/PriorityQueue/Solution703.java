package com.example.PriorityQueue;

import java.util.PriorityQueue;

/**
 * 703. Kth Largest Element in a Stream
 */
public class Solution703 {

}
class KthLargest {
    private final PriorityQueue<Integer> queue;
    private final int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        queue = new PriorityQueue<>(k);
        for (int i : nums)
            this.add(i);
    }

    public int add(int val) {
        if (queue.size() < k) {
            queue.add(val);
        } else if (val > queue.element()) {
            queue.poll();
            queue.add(val);
        }
        return queue.element();
    }
}
