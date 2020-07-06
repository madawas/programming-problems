package org.madawa.practice.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ConnectedNetworkBruteForce {
    public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        int[][] graph = constructGraph(n, connections);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (graph[i][j] == 1) {
                    graph[i][j] = 0;
                    graph[j][i] = 0;
                    if (!isConnected(n, graph)) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(i);
                        temp.add(j);
                        result.add(temp);
                    }
                    graph[i][j] = 1;
                    graph[j][i] = 1;
                }
            }
        }
        return result;
    }

    public static int[][] constructGraph(int n, List<List<Integer>> connections) {
        int[][] graph = new int[n][n];

        for (List<Integer> connection: connections) {
            int n1 = connection.get(0);
            int n2 = connection.get(1);
            graph[n1][n2] = 1;
            graph[n2][n1] = 1;
        }

        return graph;
    }

    private static boolean isConnected(int n, int[][] graph) {
        boolean[] visited = new boolean[n];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        while (!stack.isEmpty()) {
            int current = stack.pop();
            if (!visited[current]) {
                visited[current] = true;
                for (int i = 0; i < n; ++i) {
                    if (graph[current][i] == 1) {
                        stack.push(i);
                    }
                }
            }
        }
        for(int i = 0; i < n; ++i) {
            if(!visited[i])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 4;
        List<List<Integer>> connections = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        l1.add(0);
        l1.add(1);

        List<Integer> l2 = new ArrayList<>();
        l2.add(1);
        l2.add(2);

        List<Integer> l3 = new ArrayList<>();
        l3.add(2);
        l3.add(0);

        List<Integer> l4 = new ArrayList<>();
        l4.add(1);
        l4.add(3);

        connections.add(l1);
        connections.add(l2);
        connections.add(l3);
        connections.add(l4);

        List<List<Integer>> x = criticalConnections(n, connections);
        for(List<Integer> y: x) {
            System.out.print("[" +y.get(0) + "," + y.get(1) + "] ");
        }
    }
}
