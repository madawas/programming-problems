package org.madawa.practice.problems;

import java.util.Arrays;

public class SpiralFillArray {
    public static int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int val = 1;

        int r0 = 0; // starting row index
        int rn = n; // max row index
        int c0 = 0; // starting column index
        int cn = n; // max row index

        // while starting indexes are less than the size of matrix
        // for m*n matrix r0 < m && c0 < n
        while (r0 < n && c0 < n) {
            // Filling left to right
            for (int i = r0; i < rn; ++i) {
                res[r0][i] = val++;
            }
            ++r0; // Incrementing the start index as first row has been filled

            // Filling top to bottom
            for (int i = r0; i < cn; ++i) {
                res[i][cn - 1] = val++;
            }
            --cn; // Decrementing the end column index as the end col has been filled

            // Filling right to left
            for (int i = cn - 1; i >= c0; --i) {
                res[rn - 1][i] = val++;
            }
            --rn; // Decrementing the end row index as the end row has been filled

            // Filling bottom to top
            for (int i = rn - 1; i >= r0; --i) {
                res[i][c0] = val++;
            }
            ++c0; // Incrementing the start col index as first row has been filled.
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] x = generateMatrix(10);

        for(int[] a:x) {
            System.out.println(Arrays.toString(a));
        }
    }
}
