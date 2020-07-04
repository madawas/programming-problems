package org.madawa.searching;

import java.util.Stack;

public class DFS {

    public static void iterativeDfs(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{0,0});

        while(!stack.empty()) {
            int[] element = stack.pop();
            int row = element[0];
            int col = element[1];

            if (row < 0 || row >= m || col < 0 || col >= n || visited[row][col]) {
                continue;
            }
            visited[row][col] = true;
            System.out.print(grid[row][col] + " ");
            for (int[] d: directions) {
                stack.push(new int[]{row + d[0], col + d[1]});
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
        iterativeDfs(grid);
    }
}
