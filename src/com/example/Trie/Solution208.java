package com.example.Trie;

/**
 * 208. Implement com.example.Trie (Prefix Tree)
 */
public class Solution208 {
}
class Trie {

    static class TrieNode {
        static final int CHAR_COUNT = 26;
        char val;
        boolean isWord;
        TrieNode[] children;

        TrieNode(char c) {
            val = c;
            isWord = false;
            children = new TrieNode[CHAR_COUNT];
        }
    }

    TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TrieNode(' ');
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode node = root;
        char[] chars = word.toCharArray();
        for (char ch : chars) {
            if (null == node.children[ch - 'a']) {
                node.children[ch - 'a'] = new TrieNode(ch);
            }
            node = node.children[ch - 'a'];
        }
        node.isWord = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode node = root;
        char[] chars = word.toCharArray();
        for (char ch : chars) {
            if (null == node.children[ch - 'a']) {
                return false;
            }
            node = node.children[ch - 'a'];
        }
        return node.isWord;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        char[] chars = prefix.toCharArray();
        for (char ch : chars) {
            if (null == node.children[ch - 'a']) {
                return false;
            }
            node = node.children[ch - 'a'];
        }
        return true;
    }
}
