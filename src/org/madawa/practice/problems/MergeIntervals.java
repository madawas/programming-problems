package org.madawa.practice.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

/*
https://leetcode.com/problems/merge-intervals/

Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 */
public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        LinkedList<int[]> result = new LinkedList<>();

        for (int[] interval : intervals) {
            if (result.isEmpty() || result.getLast()[1] < interval[0]) {
                result.add(interval);
            } else {
                result.getLast()[1] = Math.max(result.getLast()[1], interval[1]);
            }
        }
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,2}, {4,6}, {2,3}, {9, 12}, {6, 8}};
        merge(intervals);
    }
}
