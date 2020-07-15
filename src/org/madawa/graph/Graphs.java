package org.madawa.graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graphs {
    public static void dijkstra(int n, int[][] graph, int src) {
        int[] distances = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE); // fill all distances to max
        distances[src] = 0; // set source distance to 0
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; ++i) {
            int u = getMinimumVertex(n, visited, graph[i]);
            for (int v = 0; v < n; ++v) {
                if (graph[u][v] > 0 && distances[v] > distances[u] + graph[u][v]) { // if direct distance to V is greater than
                    distances[v] = distances[u] + graph[u][v];                      // the distance through U
                }
            }
            visited[i] = true;
        }

        System.out.println("Source: " + src);
        System.out.println(Arrays.toString(distances));
    }

    public static void bfs(int n, int[][] graph, int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);

        boolean[] visited = new boolean[n];
        visited[start] = true;
        System.out.println("Visited: " + start);
        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int i = 0; i < n; ++i) {
                if (graph[node][i] != 0 && !visited[i]) {
                    System.out.println("Visited: " + i);
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }

    public static void dfs(int node, int[][] graph, boolean[] visited) {
        if (!visited[node]) {
            System.out.println("Visited: " + node);
            visited[node] = true;

            for (int i = 0; i < graph[node].length; ++i) {
                if (!visited[i] && graph[node][i] != 0)
                    dfs(i, graph, visited);
            }
        }
    }

    private static int getMinimumVertex(int n, boolean[] visited, int[] distances) {
        int min = Integer.MAX_VALUE;
        int vertex = 0;

        for (int i = 0; i < n; ++i) {
            if (!visited[i] && distances[i] < min) { // if not visited and distance to the node is less than current min
                min = distances[i];
                vertex = i;
            }
        }
        return vertex;
    }

    private static int[][] constructGraph(int n, int[][] connections) {
        int[][] graph = new int[n][n];
        for (int[] connection: connections) {
            graph[connection[0]][connection[1]] = connection[2];
            graph[connection[1]][connection[0]] = connection[2];
        }
        return graph;
    }

    public static void main(String[] args) {
        int[][] connections = new int[7][3];
        connections[0] = new int[]{0, 1, 4};
        connections[1] = new int[]{0, 2, 3};
        connections[3] = new int[]{1, 3, 2};
        connections[4] = new int[]{2, 3, 4};
        connections[5] = new int[]{3, 4, 2};
        connections[6] = new int[]{4, 5, 6};
        int[][] graph = constructGraph(6, connections);
        dijkstra(6, graph, 0);
        bfs(6, graph, 3);
        boolean[] visited = new boolean[6];
        System.out.println("--------------------");
        dfs(3, graph, visited);
    }
}
