package org.madawa.practice.problems;

import java.util.ArrayList;
import java.util.List;

public class ConnectedNetworkTrajans {
    public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        int[][] graph = ConnectedNetworkBruteForce.constructGraph(n, connections);
        List<List<Integer>> result = new ArrayList<>(); //todo: implement Trajan's algorithm
        return result;
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
