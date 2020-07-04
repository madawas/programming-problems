package org.madawa.searching;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    public static void bfs(int[][] grid) {
        int m = grid.length;
        if (m == 0) {
            return;
        }
        int n = grid[0].length;
        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];

        queue.offer(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] element = queue.poll();
            int row = element[0];
            int col = element[1];

            if (row < 0 || row >= m || col >= n || col < 0 || visited[row][col]) {
                continue;
            }

            visited[row][col] = true;
            System.out.print(grid[row][col] + " ");
            for (int[] d: directions) {
                queue.offer(new int[]{row + d[0], col + d[1]});
            }
        }
    }

    public static void main(String[] args) {

        int [][] grid = new int[][] {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        bfs(grid);
    }
}
