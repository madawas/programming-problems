package org.madawa.practice.problems;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class CheapestFlightsKStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, Map<Integer, Integer>> prices = new HashMap();
        for (int[] flight : flights) {
            if (!prices.containsKey(flight[0])) prices.put(flight[0], new HashMap());
            prices.get(flight[0]).put(flight[1], flight[2]);
        }

        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        heap.add(new int[]{0, src, 0});

        while(!heap.isEmpty()) {
            int[] cur = heap.poll();
            int cost = cur[0], city = cur[1], stops = cur[2];
            if (city == dst) return cost;

            if (stops <= K) {
                Map<Integer, Integer> nextCities = prices.getOrDefault(city, Collections.EMPTY_MAP);
                for (int nextCity : nextCities.keySet()) {
                    heap.add(new int[]{cost + nextCities.get(nextCity), nextCity, stops + 1});
                }
            }
        }
        return -1;
    }
}
