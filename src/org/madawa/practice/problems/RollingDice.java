package org.madawa.practice.problems;

public class RollingDice {

    public static int numRollsToTarget(int d, int f, int target) {
        int[][] table = new int[d+1][target+1];
        table[0][0] = 1;
        for (int i = 1; i <= d; ++i) {
            for (int j = 1; j <= target; ++j) {
                for (int k = 1; k <= j && k <= f; ++k) {
                    table[i][j] = (table[i][j] + table[i-1][j-k])%1000000007;
                }
            }
        }
        return table[d][target];
    }

    public static void main(String[] args) {
        System.out.println(numRollsToTarget(2, 6, 7));
    }
}
