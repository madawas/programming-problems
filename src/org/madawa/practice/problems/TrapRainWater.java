package org.madawa.practice.problems;

public class TrapRainWater {
    public int trapBruteForce(int[] height) {
        int result = 0;
        int n = height.length;

        for (int i = 0; i < n; ++i) {
            int maxLeft = 0, maxRight = 0;

            for (int j = i; j > -1; --j) {
                maxLeft = Math.max(height[j], maxLeft);
            }

            for (int j = i; j < n; ++j) {
                maxRight = Math.max(height[j], maxRight);
            }

            result += Math.min(maxLeft, maxRight) - height[i];
        }
        return result;
    }

    public int trapDP(int[] height) {
        if (height.length == 0) {
            return 0;
        }

        int result = 0;
        int n = height.length;
        int[] maxLeft = new int[n];
        int[] maxRight = new int[n];

        maxLeft[0] = height[0];
        maxRight[n - 1] = height[n - 1];
        for (int i = 1; i < n; ++i) {
            maxLeft[i] = Math.max(height[i], maxLeft[i-1]);
            maxRight[n - i - 1] = Math.max(height[n - i - 1], maxRight[n - i]);
        }

        for (int i = 1; i < n; ++i) {
            result += Math.min(maxLeft[i], maxRight[i]) - height[i];
        }

        return result;
    }

    public int trapTwoPointer(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int result = 0, leftMax = 0, rightMax = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] > leftMax) {
                    leftMax = height[left];
                } else {
                    result += leftMax - height[left];
                }
                ++left;
            } else {
                if (height[right] > rightMax) {
                    rightMax = height[right];
                } else {
                    result += rightMax - height[right];
                }
                --right;
            }
        }
        return result;
    }
}
