package org.madawa.practice.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordBreakII {
    public static List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new ArrayList<>();
        Map<String, String> memo = new HashMap<>();

        String s2 = getSentence(s, 1, new HashSet<>(wordDict), memo);

        for (Map.Entry<String, String> entry: memo.entrySet()) {
            if (entry.getValue() != null) {
                result.add(entry.getKey() + " " +  entry.getValue());
            }
        }

        return result;
    }

    private static String getSentence(String s, int index, Set<String> wordDict, Map<String, String> memo) {
        String prefix;
        if (index == s.length()) {
            prefix = s.substring(0, index);
            return wordDict.contains(prefix) ? prefix : null;
        }
        prefix = s.substring(0, index);
        if (wordDict.contains(prefix)) {
            if (memo.containsKey(prefix)) {
                return memo.get(prefix);
            } else {
                String sentence = getSentence(s.substring(index), 1, wordDict, memo);
                memo.put(prefix, sentence);
            }
        } else {
            memo.put(prefix, null);
        }
        return getSentence(s, index + 1, wordDict, memo);
    }

    public static void main(String[] args) {
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cat");
        wordDict.add("cats");
        wordDict.add("and");
        wordDict.add("sand");
        wordDict.add("dog");
        List<String> sentences = wordBreak("catsanddog", wordDict);

        for(String sentence: sentences) {
            System.out.println(sentence);
        }
    }
}
