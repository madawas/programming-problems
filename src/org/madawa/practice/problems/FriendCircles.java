package org.madawa.practice.problems;

/*
https://leetcode.com/problems/friend-circles/

There are N students in a class. Some of them are friends, while some are not. Their friendship is transitive in nature. For example, if A is a direct friend of B, and B is a direct friend of C, then A is an indirect friend of C. And we defined a friend circle is a group of students who are direct or indirect friends.

Given a N*N matrix M representing the friend relationship between students in the class. If M[i][j] = 1, then the ith and jth students are direct friends with each other, otherwise not. And you have to output the total number of friend circles among all the students.

Example 1:
Input:
[[1,1,0],
 [1,1,0],
 [0,0,1]]
Output: 2
Explanation:The 0th and 1st students are direct friends, so they are in a friend circle.
The 2nd student himself is in a friend circle. So return 2.
Example 2:
Input:
[[1,1,0],
 [1,1,1],
 [0,1,1]]
Output: 1
Explanation:The 0th and 1st students are direct friends, the 1st and 2nd students are direct friends,
so the 0th and 2nd students are indirect friends. All of them are in the same friend circle, so return 1.
Note:
N is in range [1,200].
M[i][i] = 1 for all students.
If M[i][j] = 1, then M[j][i] = 1.
 */
public class FriendCircles {

    static int findCircleNum(int[][] M) {
        int m = M.length;
        int n = M[0].length;
        boolean[][] visited = new boolean[m][n];
        int groups = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (!visited[i][j] && M[i][j] == 1) {
                    ++groups;
                    dfs(M, i, j, visited);
                }
            }
        }
        return groups;
    }

    static void dfs(int[][] graph, int row, int col, boolean[][] visited) {
        if (row < 0 || row >= graph.length || col < 0 || col >= graph[0].length || graph[row][col] == 0 || visited[row][col]) {
            return;
        }
        visited[row][col] = true;
        visited[col][row] = true;
        for (int i = 0; i < graph[0].length; ++i) {
            if (!visited[col][i] && graph[col][i] == 1) {
                dfs(graph, col, i, visited);
            }
        }
    }

    public static void main(String[] args) {
        int[][] M = {{1, 1, 0, 0, 0, 0}, {1, 1, 0, 0, 0, 0}, {0, 0, 1, 1, 1, 0}, {0, 0, 1, 1, 0, 0}, {0, 0, 1, 0, 1, 0}, {0, 0, 0, 0, 0, 1}};
        System.out.println(findCircleNum(M));
    }
}
