package com.example.PriorityQueue;

import java.util.*;

public class Solution347 {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> tab = new HashMap<>();
        for (int num : nums) {
            int cnt = tab.getOrDefault(num, 0);
            cnt++;
            tab.put(num, cnt);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap =
                new PriorityQueue<>((e1, e2) -> e2.getValue().compareTo(e1.getValue()));
        for (Map.Entry<Integer, Integer> e : tab.entrySet()) {
            maxHeap.offer(e);
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = Objects.requireNonNull(maxHeap.poll()).getKey();
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
