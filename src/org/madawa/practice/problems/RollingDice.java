package org.madawa.practice.problems;

import java.util.Arrays;

public class RollingDice {

    public static int numRollsToTarget(int d, int f, int target) {
        int[][] table = new int[d+1][target+1];

        for (int i = 1; i <= f && i < target; ++i) {
            table[1][i] = 1;
        }

        for (int i = 2; i < d; ++i) {
            for (int j = 1; j <= target; ++j) {
                if (j > i * f) break;
                for (int k = 0; k < j && k < f; ++k) {
                    table[i][j] = (table[i][j] + table[i-1][j-k])%1000000007;
                }
            }
        }

        return table[d][target];
    }

    public static void main(String[] args) {
        numRollsToTarget(2, 6, 7);
    }
}
