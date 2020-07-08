package org.madawa.practice.problems;

import java.util.Arrays;

/*
https://leetcode.com/problems/3sum-smaller/

Given an array of n integers nums and a target, find the number of index triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.

Example:

Input: nums = [-2,0,1,3], and target = 2
Output: 2
Explanation: Because there are two triplets which sums are less than 2:
             [-2,0,1]
             [-2,0,3]

 */
public class ThreeSumSmaller {
    public static int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int size = nums.length;
        int count = 0;
        for (int i = 0; i < size; ++i) {
            count += countPairs(nums, target - nums[i], i, size);
        }
        return count;
    }

    private static int countPairs(int[] nums, int target, int start, int size) {
        int left = start + 1;
        int right = size - 1;
        int count = 0;

        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum < target) {
                count += (right - left);
                ++left;
            } else {
                --right;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 0, 1, 3};
        System.out.println(threeSumSmaller(nums, 2));
    }
}
