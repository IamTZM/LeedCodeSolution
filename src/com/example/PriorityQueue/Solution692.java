package com.example.PriorityQueue;

import java.util.*;

public class Solution692 {

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> tab = new HashMap<>();
        for (String word : words) {
            tab.put(word, tab.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<Map.Entry<String, Integer>> minHeap =
                new PriorityQueue<>(k + 1, (e1, e2) -> {
                    if (e1.getValue().equals(e2.getValue())) {
                        return e2.getKey().compareTo(e1.getKey());
                    }
                    return e1.getValue().compareTo(e2.getValue());
                });
        for (Map.Entry<String, Integer> e : tab.entrySet()) {
            minHeap.offer(e);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        List<String> res = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            res.add(minHeap.poll().getKey());
        }
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {

    }
}
