package org.madawa.practice.problems;

import java.util.LinkedList;
import java.util.Queue;

public class RottenTomatoes {
    public static int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int minute = -1;
        int fresh = 0;
        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    ++fresh;
                }
            }
        }
        queue.offer(new int[]{-1, -1});

        while (!queue.isEmpty()) {
            int[] element = queue.poll();
            int row = element[0];
            int col = element[1];

            if (row == -1) {
                ++minute;
                if (!queue.isEmpty()) {
                    queue.offer(new int[]{-1, -1});
                }
            } else {
                for (int[] d: directions) {
                    int nextRow = row + d[0];
                    int nextCol = col + d[1];

                    if (nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n) {
                        if (grid[nextRow][nextCol] == 1) {
                            grid[nextRow][nextCol] = 2;
                            --fresh;
                            queue.offer(new int[]{nextRow, nextCol});
                        }
                    }
                }
            }
        }
        return fresh == 0 ? minute : -1;
    }

    public static void main(String[] args) {
        System.out.println(orangesRotting(new int[][]{{2, 1, 1},{1, 1, 0}, {0, 1, 1}}));
    }
}
