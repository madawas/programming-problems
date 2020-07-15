package org.madawa.practice.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
/*
https://leetcode.com/problems/word-break-ii/

Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
Example 1:

Input:
s = "catsanddog"
wordDict = ["cat", "cats", "and", "sand", "dog"]
Output:
[
  "cats and dog",
  "cat sand dog"
]
Example 2:

Input:
s = "pineapplepenapple"
wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
Output:
[
  "pine apple pen apple",
  "pineapple pen apple",
  "pine applepen apple"
]
Explanation: Note that you are allowed to reuse a dictionary word.
Example 3:

Input:
s = "catsandog"
wordDict = ["cats", "dog", "sand", "and", "cat"]
Output:
[]
 */
public class WordBreakII {
    private static String EMPTY = "";
    private static String SPACE = " ";

    public static List<String> wordBreak(String s, List<String> wordDict) {
        return generateSentences(s, new HashSet<>(wordDict), new HashMap<>());
    }

    private static List<String> generateSentences(String s, Set<String> wordDict, Map<String, List<String>> memo) {
        if (memo.containsKey(s)) {
            return memo.get(s);
        }
        List<String> sentences = new ArrayList<>();
        if (s.isEmpty()) {
            sentences.add(EMPTY);
           return sentences;
        }

       for (int index = 1; index <= s.length(); ++index) {
           String word = s.substring(0, index);
           if (wordDict.contains(word)) {
               List<String> postfix = generateSentences(s.substring(index), wordDict, memo);
               for (String pf : postfix) {
                   if (pf.isEmpty()) {
                       sentences.add(word + pf);
                   } else {
                       sentences.add(word + SPACE + pf);
                   }
               }
           }
       }
       memo.put(s, sentences);
       return sentences;
    }

    public static void main(String[] args) {
        List<String> wordDict = new ArrayList<>();
        wordDict.add("apple");
        wordDict.add("pen");
        wordDict.add("applepen");
        wordDict.add("pine");
        wordDict.add("pineapple");
        List<String> sentences = wordBreak("pineapplepenapple", wordDict);

        for(String sentence: sentences) {
            System.out.println(sentence);
        }
    }
}
