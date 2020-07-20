package org.madawa.practice.problems;

import org.madawa.util.TrieNode;

/*
https://leetcode.com/problems/add-and-search-word-data-structure-design/

Design a data structure that supports the following two operations:

void addWord(word)
bool search(word)
search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

Example:

addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true
Note:
You may assume that all words are consist of lowercase letters a-z.
 */
public class WordDictionary {
    /**
     * {@link TrieNode}
     */
    private final TrieNode root;

    public WordDictionary() {
        this.root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;

        for (char ch: word.toCharArray()) {
            if (!node.getChildren().containsKey(ch)) {
                node.getChildren().put(ch, new TrieNode());
            }
            node = node.getChildren().get(ch);
        }
        node.setWord(true);
    }

    public boolean search(String word) {
        return search(word, this.root);
    }

    public boolean search(String word, TrieNode node) {
        for (int i  = 0; i < word.length(); ++i) {
            char ch = word.charAt(i);

            if (!node.getChildren().containsKey(ch)) {
                if (ch == '.') {
                    for (char x: node.getChildren().keySet()) {
                        if (search(word.substring(i+1), node.getChildren().get(x))) {
                            return true;
                        }
                    }
                }
                return false;
            } else {
                node = node.getChildren().get(ch);
            }
        }
        return node.isWord();
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("a");
        wordDictionary.addWord("a");
        System.out.println(wordDictionary.search("."));
        System.out.println(wordDictionary.search("a"));
        System.out.println(wordDictionary.search("aa"));
    }
}
