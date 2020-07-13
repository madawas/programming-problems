package org.madawa.practice.problems;

import java.util.HashMap;
import java.util.Map;

public class RollingDice {
    private static final int MOD = 1000000007;

    // dp
    public static int numRollsToTarget(int d, int f, int target) {
        int[][] table = new int[d+1][target+1];
        table[0][0] = 1;
        for (int i = 1; i <= d; ++i) {
            for (int j = 1; j <= target; ++j) {
                for (int k = 1; k <= j && k <= f; ++k) {
                    table[i][j] = (table[i][j] + table[i-1][j-k])%MOD;
                }
            }
        }
        return table[d][target];
    }

    // Num rolls to target with recursion with memoization
    public static int numRollsToTargetII(int d, int f, int target) {
        Map<String, Integer> mem = new HashMap<>();
        return countRolls(d, f, target, mem);
    }

    // recursive function
    private static int countRolls(int d, int f, int target, Map<String, Integer> mem) {
        String key = d + ":" + target;
        Integer existing = mem.get(key);
        // If the solution is previously calculated return the value.
        if (existing != null) {
            return existing;
        }

        // If number of dices is 0, only value it can create is 0
        if (d == 0) {
            return target == 0 ? 1 : 0;
        }

        // If the target is higher than the maximum number that dices can make => d * f (All rolls with highest face value)
        // Or if the target is less than the minimum num that dices can make => 1 * d (All rolls with face 1)
        if (target > f * d || target < d) {
            return 0;
        }

        int result = 0;
        for (int i = 1; i <= f; ++i) {
            // for each face value calculate the sub problem with dices = dices - 1 and target = target - (currently rolled face)
            result = (result + countRolls(d - 1, f, target - i, mem))%MOD;
        }
        //store the calculated value in mem
        mem.put(key, result);
        return mem.get(key);
    }

    public static void main(String[] args) {
        System.out.println(numRollsToTarget(2, 6, 7));
        System.out.println(numRollsToTargetII(2, 6, 7));
    }
}
