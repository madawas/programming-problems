package org.madawa.practice.problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    public static boolean wordBreak(String s, List<String> wordDict) {
        return canGenerate(s, new HashSet<>(wordDict), 0, new Boolean[s.length()]);
    }

    public static boolean canGenerate(String s, Set<String> wordDict, int index, Boolean[] memo) {
        if (index == s.length()) {
            return true;
        }

        if (memo[index] != null) {
            return memo[index];
        }

        for (int i = index + 1; i <= s.length(); ++i) {
            if (wordDict.contains(s.substring(index, i)) && canGenerate(s, wordDict, i, memo)) {
                memo[index] = true;
                return true;
            }
        }
        memo[index] = false;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(wordBreak("ccaccc", Arrays.asList("cc", "ac")));
    }
}
