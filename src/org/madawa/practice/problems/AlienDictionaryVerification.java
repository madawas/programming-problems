package org.madawa.practice.problems;

/*
https://leetcode.com/problems/verifying-an-alien-dictionary/

In an alien language, surprisingly they also use english lowercase letters, but possibly in a different order. The order of the alphabet is some permutation of lowercase letters.

Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only if the given words are sorted lexicographicaly in this alien language.



Example 1:

Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
Output: true
Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
Example 2:

Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
Output: false
Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.
Example 3:

Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
Output: false
Explanation: The first three characters "app" match, and the second string is shorter (in size.) According to lexicographical rules "apple" > "app", because 'l' > '∅', where '∅' is defined as the blank character which is less than any other character (More info).
 */
public class AlienDictionaryVerification {
    public boolean isAlienSorted(String[] words, String order) {
        int[] chars = new int[26];

        for (int i = 0; i < order.length(); ++i) {
            chars[order.charAt(i) - 'a'] = i;
        }

        outer:
        for (int i = 1; i < words.length; ++i) {
            String s1 = words[i-1];
            String s2 = words[i];

            int index = 0;

            while (s1.charAt(index) == s2.charAt(index)) {
                ++index;

                if (index == s1.length()) {
                    continue outer;
                } else if (index == s2.length()) {
                    return false;
                }
            }

            if (chars[s1.charAt(index) - 'a'] > chars[s2.charAt(index) - 'a']) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] words = {"hellocode", "hello"};
        String order = "hlabcdefgijkmnopqrstuvwxyz";

        System.out.println(new AlienDictionaryVerification().isAlienSorted(words, order));
    }
}
