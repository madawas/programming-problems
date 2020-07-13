package org.madawa.practice.problems;

import java.util.ArrayList;
import java.util.List;
/*
https://leetcode.com/problems/partition-labels/

A string S of lowercase English letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.



Example 1:

Input: S = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
 */
public class PartitionLabels {
    public static List<Integer> partitionLabels(String S) {
        List<Integer> lengths = new ArrayList<>();

        int start = 0;
        int lIndex = 0;
        int len = S.length();
        while (start < len) {
            char temp = S.charAt(start);
            lIndex = S.lastIndexOf(temp);
            // Find if there are any characters included outside of the selected partition
            // and adjust lastIndex if so
            for (int i = start; i <= lIndex; ++i) {
                lIndex = Math.max(lIndex, S.lastIndexOf(S.charAt(i)));
            }
            lengths.add(lIndex - start + 1);
            start = lIndex + 1;
        }
        return lengths;
    }

    public static void main(String[] args) {
        List<Integer> x = partitionLabels("ababcbacadefegdehijhklij");
        for (Integer y: x) {
            System.out.print(y + " ");
        }
    }
}
