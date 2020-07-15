package org.madawa.practice.problems;

import java.util.ArrayList;
import java.util.List;

/*
Heap's algorithm
 */
public class GeneratePermutations {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        generatePermutations(nums, nums.length, result);
        return result;
    }

    private static void generatePermutations(int[] nums, int size, List<List<Integer>> result) {
        if (size == 1) {
            List<Integer> temp  = new ArrayList<>();
            for(int num: nums)
                temp.add(num);
            result.add(temp);
        }

        for (int i = 0; i < size; ++i) {
            generatePermutations(nums, size - 1, result);
            if (size%2 == 1) {
                swap(nums, 0, size - 1);
            } else {
                swap(nums, i, size - 1);
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = permute(nums);
        for(List<Integer> x: result) {
            System.out.print("[ ");
            for (Integer y: x) {
                System.out.print(y + " ");
            }
            System.out.print("]\n");
        }
    }

}
