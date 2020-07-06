package org.madawa.practice.problems;

import java.util.Arrays;

public class RotateMatrix {

    public static void rotateInPlace(int[][] matrix) {
        int n = matrix.length;
        for (int r = 0; r < n/2; ++r) {
            for (int c = r; c < n - 1 - r; ++c) {
                int t1 = matrix[r][c];
                int t2 = matrix[c][n - 1 - r];
                int t3 = matrix[n - 1 - r][n - 1 - c];
                int t4 = matrix[n - 1 - c][r];

                matrix[c][n - 1 - r] = t1;
                matrix[n - 1 - r][n - 1 - c] = t2;
                matrix[n - 1 - c][r] = t3;
                matrix[r][c] = t4;
            }
        }
    }

    public static int[][] rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] res = new int[n][n];
        for (int r = 0; r < n; ++r) {
            for (int c = 0; c < n; ++c) {
                res[c][n - 1 - r] = matrix[r][c];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int [][] grid = new int[][] {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        int[][] x = rotate(grid);
        for (int[] y: x) {
            System.out.println(Arrays.toString(y));
        }
        System.out.println();
        rotateInPlace(grid);
        for (int[] y: grid) {
            System.out.println(Arrays.toString(y));
        }
    }
}
