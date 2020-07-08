package org.madawa.practice.problems;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static int totalScore(int num, List<String> blocks)
    {
        int total = 0;
        int[] scores = new int[blocks.size()];
        int index = 0;
        for (String s: blocks) {
            int score;
            switch(s) {
                case "X":
                    score = index > 0 ? 2 * scores[index - 1] : 0;
                    scores[index] = score;
                    total += score;
                    break;
                case "+":
                    if (index - 1 < 0) {
                        score = 0;
                    } else if (index - 2 < 0) {
                        score = scores[index - 1];
                    } else {
                        score = scores[index - 1] + scores[index - 2];
                    }
                    scores[index] = score;
                    total += score;
                    break;
                case "Z":
                    if (index > 0) {
                        total -= scores[index - 1];
                        index -= 2;
                    }
                    break;
                default:
                    score = Integer.parseInt(s);
                    scores[index] = score;
                    total += score;
                    break;
            }
            ++index;
        }
        return total;
    }
    public static void main(String[] args) {
        List<String> l = new ArrayList<>();
//        l.add("5");
//        l.add("-2");
//        l.add("4");
//        l.add("-2");
        l.add("X");
        l.add("Z");
        l.add("+");
        l.add("+");
        System.out.println(totalScore(4, l));
    }
}
