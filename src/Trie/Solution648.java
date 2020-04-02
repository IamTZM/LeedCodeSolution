package Trie;

import java.util.List;

/**
 * 648. Replace Words
 */
public class Solution648 {
    public String replaceWords(List<String> dict, String sentence) {
        Trie trie = new Trie();
        for (String word : dict) {
            trie.insert(word);
        }
        String[] strings = sentence.split(" ");
        for (int i = 0; i < strings.length; i++) {
            char[] arr = strings[i].toCharArray();
            boolean flag = true;
            Trie.TrieNode node = trie.root;
            StringBuilder sb = new StringBuilder();
            for (char ch : arr) {
                if (node.children[ch - 'a'] == null && !node.isWord) {
                    flag = false;
                    break;
                }
                if (node.isWord) {
                    break;
                }
                sb.append(ch);
                node = node.children[ch - 'a'];
            }
            if (flag) {
                strings[i] = sb.toString();
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            if (i != 0) {
                builder.append(" ");
            }
            builder.append(strings[i]);
        }
        return builder.toString();
    }
}
