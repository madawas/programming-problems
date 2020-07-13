package org.madawa.practice.problems;

import java.util.Arrays;

/*
https://leetcode.com/problems/3sum-closest/

Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

Example 1:

Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).


Constraints:

3 <= nums.length <= 10^3
-10^3 <= nums[i] <= 10^3
-10^4 <= target <= 10^4
 */
public class ThreeSumClosest {
    public static int threeSumClosest(int[] nums, int target) {
        int cSum = 0;
        int size = nums.length;
        int difference = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < size; ++i) {
            int left = i + 1;
            int right = size -1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                int diff = Math.abs(sum - target);
                if (diff < difference) {
                    cSum = sum;
                    difference = diff;
                }
                if (sum < target) {
                    ++left;
                } else {
                    --right;
                }
            }
        }
        return cSum;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        System.out.println(threeSumClosest(nums, 1));
    }
}
