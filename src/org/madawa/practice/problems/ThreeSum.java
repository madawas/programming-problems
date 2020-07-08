package org.madawa.practice.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 2) {
            return result;
        }

        Arrays.sort(nums);
        for(int i = 0; i < nums.length; ++i) {
            if (nums[i] > 0)
                break;

            if (i == 0 || nums[i - 1] != nums[i]) {
                findTarget(nums, i, result);
            }
        }
        return result;
    }

    public void findTarget(int[] nums, int i, List<List<Integer>> result) {
        int left = i + 1;
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[i] + nums[left] +  nums[right];

            if (sum < 0 || (left > i + 1 && nums[left] == nums[left - 1])) {
                ++left;
            } else if (sum > 0 || (right < nums.length - 1 && nums[right] == nums[right + 1])) {
                --right;
            } else {
                result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                ++left;
                --right;
            }
        }
    }
}
