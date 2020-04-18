package com.example.Trie;

/**
 * 211. Add and Search Word - Data structure design
 * 与Trie同理
 */
public class Solution211 {
}

class WordDictionary {

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
    public WordDictionary() {
        root = new TrieNode(' ');
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
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
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return this.match(word.toCharArray(), root, 0);
    }

    private boolean match(char[] word, TrieNode curNode, int level) {
        if (level == word.length) {
            return curNode.isWord;
        }
        if ('.' == word[level]) {
            for (TrieNode n : curNode.children) {
                if (null == n) {
                    continue;
                }
                if (match(word, n, level + 1)) {
                    return true;
                }
            }
        } else {
            TrieNode node = curNode.children[word[level] - 'a'];
            return (null != node) && match(word, node, level + 1);
        }
        return false;
    }
}
