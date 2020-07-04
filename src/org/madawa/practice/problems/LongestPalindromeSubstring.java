package org.madawa.practice.problems;

/*
https://leetcode.com/problems/longest-palindromic-substring/

Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:
Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.

Example 2:
Input: "cbbd"
Output: "bb"
 */
public class LongestPalindromeSubstring {
    public static String longestPalindrome(String s) {
        if (s == null || s.trim().equals("")) {
            return "";
        }

        int start = 0;
        int len = s.length();
        int max = 1;

        int left, right;

        for (int i = 1; i < len; ++i) {
            left = i-1;
            right = i+1;
            //Find all odd palindrome length
            while(left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
                if (right - left + 1 > max) {
                    max = right - left + 1;
                    start = left;
                }
                ++right;
                --left;
            }


            left = i-1;
            right = i;
            //Find all even palindrome length
            while(left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
                if (right - left + 1 > max) {
                    max = right - left + 1;
                    start = left;
                }
                ++right;
                --left;
            }
        }
        return s.substring(start, start + max);
    }

    public static void main(String[] args){
        System.out.println(longestPalindrome("babad"));
    }
}
