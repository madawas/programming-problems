package org.madawa.practice.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] inDegree = new int[numCourses];
        int[] result = new int[numCourses];

        // Construct graph
        for (int[] prerequisite : prerequisites) {
            int dest = prerequisite[0];
            int src = prerequisite[1];
            List<Integer> lst = graph.getOrDefault(src, new ArrayList<>());
            lst.add(dest);
            graph.put(src, lst);
            ++inDegree[dest];
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int i = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            result[i++] = node;

            if (graph.containsKey(node)) {
                for (Integer neighbor : graph.get(node)) {
                    --inDegree[neighbor];

                    if (inDegree[neighbor] == 0) {
                        queue.offer(neighbor);
                    }
                }
            }
        }

        if (i == numCourses) {
            return result;
        }

        return new int[0];
    }

    public static void main(String[] args) {
        CourseScheduleII courseScheduleII = new CourseScheduleII();
        System.out.println(Arrays.toString(courseScheduleII.findOrder(5, new int[][]{{1, 0}, {2, 4}, {3, 1}, {0, 3},{2, 0}})));
    }
}
