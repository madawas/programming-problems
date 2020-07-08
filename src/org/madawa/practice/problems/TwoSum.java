package org.madawa.practice.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static int[] twoSumHMap(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer pos = map.get(target - nums[i]);
            if (pos != null) {
                return new int[]{i, pos};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    public static int[] twoSumBinarySearch(int[] nums, int target) {
        int[] temp = new int[nums.length];
        System.arraycopy(nums, 0, temp, 0, nums.length);
        Arrays.sort(nums);
        int left = 0;
        int right = -1;
        for (int i = 0; i < nums.length - 1; ++i) {
            ++left;
            right = search(nums, left, nums.length, target - nums[i]);
            if (right != -1) {
                break;
            }
        }
        int[] r = {-1, -1};
        for (int i = 0; i < temp.length; ++i) {
            if (nums[left - 1] == temp[i] && r[0] == -1) {
                r[0] = i;
                temp[i] = -1;
            } else if (nums[right] == temp[i]) {
                r[1] = i;
            }
        }
        return r;
    }

    public static int[] twoSumDP(int[] nums, int target) {
        boolean[][] table = new boolean[nums.length + 1][target + 1];
        for (int i = 0; i <= nums.length; ++i) {
            table[i][0] = true;
        }

        for (int i = 1; i <= nums.length; ++i) {
            for (int j = 1; j <= target; ++j) {
                if (j - nums[i - 1] >= 0) {
                    table[i][j] = table[i - 1][j] ? table[i - 1][j]: table[i - 1][j - nums[i - 1]];
                } else {
                    table[i][j] = table[i - 1][j];
                }
            }
        }
        int x = 0;
        for (boolean[] t : table) {
            int val = x > 0 ? nums[x - 1]: x;
            System.out.println(val + " - " + Arrays.toString(t));
            ++x;
        }

        int[] result = new int[2];
        int k = 0;
        int i = nums.length;
        int j = target;

        while (j != 0 && k < 2) {
            while (table[i - 1][j]) {
                --i;
            }
            result[k] = i - 1;
            j -= nums[i - 1];
            ++k;
        }
        Arrays.sort(result);
        return result;
    }

    public static int search(int[] nums, int start, int end, int value) {
        int mid = (start + end) / 2;

        if (start >= end) {
            return -1;
        }

        if (nums[mid] == value) {
            return mid;
        } else if (value > nums[mid]) {
            return search(nums, mid + 1, end, value);
        } else {
            return search(nums, start, mid, value);
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 4, 3, 0};
        System.out.println(Arrays.toString(twoSumBinarySearch(nums, 0)));

        System.out.println(Arrays.toString(twoSumDP(nums, 0)));

        System.out.println(Arrays.toString(twoSumHMap(nums, 0)));
    }
}
