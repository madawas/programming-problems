package org.madawa.practice.problems;

import java.util.LinkedHashMap;

/*
https://leetcode.com/problems/word-search/

Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.


Constraints:

board and word consists only of lowercase and uppercase English letters.
1 <= board.length <= 200
1 <= board[i].length <= 200
1 <= word.length <= 10^3
 */
public class WordSearch {
    public static boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (dfs(board, i, j, word, 0))
                    return true;
            }
        }
        return false;
    }

    private static boolean dfs(char[][] board, int row, int col, String word, int index) {
        if (index >= word.length())
            return true;

        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != word.charAt(index)) {
            return false;
        }
        // marking current cell to stop revisiting from the next node.
        board[row][col] = '?';
        boolean b = false;
        int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        for (int i = 0; i < 4; ++i) {
            b = dfs(board, row + directions[i][0], col + directions[i][1], word, index + 1);
            if (b)
                break; //break if result found
        }
        board[row][col] = word.charAt(index);
        return b;
    }


    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}};
        System.out.println(exist(board, "ABCCED"));
        System.out.println(exist(board, "SEE"));
        System.out.println(exist(board, "ABCB"));
    }
}
