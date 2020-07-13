package org.madawa.practice.problems;

import java.util.Arrays;
/*
https://leetcode.com/problems/reorder-data-in-log-files/

You have an array of logs.  Each log is a space delimited string of words.

For each log, the first word in each log is an alphanumeric identifier.  Then, either:

Each word after the identifier will consist only of lowercase letters, or;
Each word after the identifier will consist only of digits.
We will call these two varieties of logs letter-logs and digit-logs.  It is guaranteed that each log has at least one word after its identifier.

Reorder the logs so that all of the letter-logs come before any digit-log.  The letter-logs are ordered lexicographically ignoring identifier, with the identifier used in case of ties.  The digit-logs should be put in their original order.

Return the final order of the logs.



Example 1:

Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]


Constraints:

0 <= logs.length <= 100
3 <= logs[i].length <= 100
logs[i] is guaranteed to have an identifier, and a word after the identifier.
 */
public class ReorderDataInLogFiles {
    public String[] reorderLogFiles(String[] logs) {
        sort(logs, 0, logs.length - 1);
        return logs;
    }

    private void sort(String[] logs, int start, int end) {
        if (start < end) {
            int mid = (start +  end)/2;

            sort(logs, start, mid);
            sort(logs, mid+1, end);
            merge(logs, start, mid, end);
        }
    }

    private void merge(String[] logs, int start, int mid, int end) {
        String[] left = new String[mid - start + 1];
        String[] right = new String[end - mid];

        System.arraycopy(logs, start, left, 0, mid - start + 1);
        System.arraycopy(logs, mid + 1, right, 0, end - mid);

        int i = 0, j = 0;

        int k = start;
        while (i < left.length && j < right.length) {
            if (compare(left[i], right[j]) >= 0) {
                logs[k] = left[i];
                ++i;
            } else {
                logs[k] = right[j];
                ++j;
            }
            ++k;
        }

        while (i < left.length) {
            logs[k] = left[i];
            ++k;
            ++i;
        }

        while (j < right.length) {
            logs[k] = right[j];
            ++k;
            ++j;
        }
    }

    private int compare(String a, String b) {
        int indexA = a.indexOf(' ') + 1;
        int indexB = b.indexOf(' ') + 1;

        if (a.charAt(indexA) - '0' <= 9 && b.charAt(indexB) - '0' <= 9) {
            return 1;
        } else if (a.charAt(indexA) - '0' <= 9) {
            return -1;
        } else if (b.charAt(indexB) - '0' <= 9) {
            return 1;
        } else {
            int val = b.substring(indexB).compareTo(a.substring(indexA));
            if (val == 0) {
                return b.compareTo(a);
            }
            return val;
        }
    }

    public static void main(String[] args) {
        ReorderDataInLogFiles obj = new ReorderDataInLogFiles();
        System.out.println(Arrays.toString(
                obj.reorderLogFiles(new String[]{"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"})));
    }
}
