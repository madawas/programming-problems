package org.madawa.practice.problems;

import org.madawa.util.TrieNode;

/*
https://leetcode.com/problems/implement-trie-prefix-tree/

Implement a trie with insert, search, and startsWith methods.

Example:

Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // returns true
trie.search("app");     // returns false
trie.startsWith("app"); // returns true
trie.insert("app");
trie.search("app");     // returns true
Note:

You may assume that all inputs are consist of lowercase letters a-z.
All inputs are guaranteed to be non-empty strings.
 */
public class PrefixTree {
    /**
     * {@link TrieNode}
     */
    private final TrieNode root;

    public PrefixTree() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = this.root;

        for (int i = 0; i < word.length(); ++i) {
            char ch = word.charAt(i);
            if (!node.getChildren().containsKey(ch)) {
                node.getChildren().put(ch, new TrieNode());
            }
            node = node.getChildren().get(ch);
        }
        node.setWord(true);
    }

    private boolean search(String word, TrieNode node, int index) {
        if (index == word.length()) {
            return node.isWord();
        }

        if (!node.getChildren().containsKey(word.charAt(index))) {
            return false;
        }

        return search(word, node.getChildren().get(word.charAt(index)), index + 1);
    }

    public boolean search(String word) {
        return this.search(word, this.root, 0);
    }

    public boolean startsWith(String prefix) {
        return this.searchPrefix(prefix, this.root, 0);
    }

    private boolean isWordExist(TrieNode node) {
        if (node.isWord()) {
            return true;
        } else {
            for (char ch : node.getChildren().keySet()) {
                if (isWordExist(node.getChildren().get(ch))) {
                    return true;
                }
            }
            return false;
        }
    }

    private boolean searchPrefix(String word, TrieNode node, int index) {
        if (index < word.length()) {
            if (!node.getChildren().containsKey(word.charAt(index))) {
                return false;
            } else {
                return searchPrefix(word, node.getChildren().get(word.charAt(index)), index + 1);
            }
        } else {
            if (node.isWord()) {
                return true;
            } else {
                for (char ch : node.getChildren().keySet()) {
                    if (isWordExist(node.getChildren().get(ch))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        PrefixTree prefixTree = new PrefixTree();
        prefixTree.insert("apple");
        System.out.println(prefixTree.search("apple"));
        System.out.println(prefixTree.search("app"));
        System.out.println(prefixTree.startsWith("app"));
        prefixTree.insert("app");
        System.out.println(prefixTree.search("app"));
    }
}
