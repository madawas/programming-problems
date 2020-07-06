package org.madawa.practice.problems;

import java.util.Arrays;

/*
https://leetcode.com/problems/find-k-th-smallest-pair-distance/
Given an integer array, return the k-th smallest distance among all the pairs. The distance of a pair (A, B) is defined as the absolute difference between A and B.

Example 1:
Input:
nums = [1,3,1]
k = 1
Output: 0
Explanation:
Here are all the pairs:
(1,3) -> 2
(1,1) -> 0
(3,1) -> 2
Then the 1st smallest distance pair is (1,1), and its distance is 0.
 */
public class KthSmallestDistance {
    public static int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int min = nums[1] - nums[0];
        int max = nums[n - 1] - nums[0];

        while (min < max) {
            int mid = (max + min)/2;

            if (countPairs(nums, n, mid) < k) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }
        return min;
    }

    private static int countPairs(int[] nums, int n, int mid) {
        int result = 0;
        for (int i = 0; i < n; ++i) {
            int upperBound = upperBound(nums, n, nums[i]+mid);
            result += (upperBound - (i + 1));
        }
        return result;
    }

    private static int upperBound(int[] nums, int n, int value) {
        int low = 0;
        int high = n;

        while (low < high) {
            int mid = (low + high)/2;
            if (value >= nums[mid]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
