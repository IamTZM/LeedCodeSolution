package com.example.Trie;

/**
 * 677. Map Sum Pairs
 */
public class Solution677 {
    public static void main(String[] args) {
        MapSum mapSum = new MapSum();
        mapSum.insert("app", 3);
        System.out.println(mapSum.sum("app"));
        mapSum.insert("app", 2);
        System.out.println(mapSum.sum("ap"));
        mapSum.insert("app", 1);
        System.out.println(mapSum.sum("ap"));
        mapSum.insert("apple", 4);
        System.out.println(mapSum.sum("ap"));
    }
}

class MapSum {

    static class TrieNode {
        static final int CHAR_COUNT = 26;
        int val;
        char ch;
        boolean isWord;
        TrieNode[] children;
        TrieNode(char c) {
            ch = c;
            val = 0;
            isWord = false;
            children = new TrieNode[CHAR_COUNT];
        }
    }

    TrieNode root;

    /** Initialize your data structure here. */
    public MapSum() {
        root = new TrieNode(' ');
    }

    public void insert(String key, int val) {
        if (search(key)) {
            overridden(key, val);
            return;
        }
        TrieNode node = root;
        char[] chs = key.toCharArray();
        for (char c : chs) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode(c);
            }
            node.children[c - 'a'].val += val;
            node = node.children[c - 'a'];
        }
        node.isWord = true;
    }

    public int sum(String prefix) {
        TrieNode node = root;
        char[] preArr = prefix.toCharArray();
        int res = 0;
        for (char c : preArr) {
            if (node.children[c - 'a'] == null) {
                res = 0;
                break;
            }
            node = node.children[c - 'a'];
            res = node.val;
        }
        return res;
    }
    private boolean search(String word) {
        TrieNode node = root;
        char[] chs = word.toCharArray();
        for (char c : chs) {
            if (node.children[c - 'a'] == null) {
                return false;
            }
            node = node.children[c - 'a'];
        }
        return node.isWord;
    }

    private void overridden(String word, int val) {
        TrieNode node = root;
        char[] chs = word.toCharArray();
        for (char c : chs) {
            node = node.children[c - 'a'];
            node.val = val;
        }
    }
}