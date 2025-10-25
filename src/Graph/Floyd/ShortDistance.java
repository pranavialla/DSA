package Graph.Floyd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class ShortDistance {
    public int findTheCity(int totalCities, int[][] edgeList, int distanceThreshold) {
        int[][] shortestDistances = new int[totalCities][totalCities];

        // Initialize all distances to infinity
        for (int source = 0; source < totalCities; source++) {
            Arrays.fill(shortestDistances[source], Integer.MAX_VALUE);
        }

        // Populate direct edge distances
        for (int[] edge : edgeList) {
            int cityA = edge[0], cityB = edge[1], weight = edge[2];
            shortestDistances[cityA][cityB] = weight;
            shortestDistances[cityB][cityA] = weight;
        }

        // Floyd-Warshall: update shortest paths using intermediate cities
        for (int intermediate = 0; intermediate < totalCities; intermediate++) {
            for (int source = 0; source < totalCities; source++) {
                for (int destination = 0; destination < totalCities; destination++) {
                    if (source == destination) {
                        shortestDistances[source][destination] = 0;
                        continue;
                    }
                    

                    if (shortestDistances[source][intermediate] == Integer.MAX_VALUE ||
                        shortestDistances[intermediate][destination] == Integer.MAX_VALUE) {
                        continue;
                    }

                    int newDistance = shortestDistances[source][intermediate] + shortestDistances[intermediate][destination];
                    if (newDistance < shortestDistances[source][destination]) {
                        shortestDistances[source][destination] = newDistance;
                    }
                }
            }
        }

        // Find the city with the fewest reachable neighbors within the threshold
        int optimalCity = -1;
        int minReachableCount = Integer.MAX_VALUE;

        for (int currentCity = 0; currentCity < totalCities; currentCity++) {
            int reachableCount = 0;

            for (int targetCity = 0; targetCity < totalCities; targetCity++) {
                if (currentCity != targetCity && shortestDistances[currentCity][targetCity] <= distanceThreshold) {
                    reachableCount++;
                }
            }

            // Prefer higher-indexed city in case of tie
            if (reachableCount <= minReachableCount) {
                minReachableCount = reachableCount;
                optimalCity = currentCity;
            }
        }

        return optimalCity;
    }

    class Solution {
    public int findTheCity(int totalCities, int[][] edgeList, int distanceThreshold) {
        List<List<int[]>> adjacencyList = new ArrayList<>();
        for (int city = 0; city < totalCities; city++) {
            adjacencyList.add(new ArrayList<>());
        }

        // Build the graph: each edge connects two cities with a weight
        for (int[] edge : edgeList) {
            int cityA = edge[0], cityB = edge[1], weight = edge[2];
            adjacencyList.get(cityA).add(new int[]{cityB, weight});
            adjacencyList.get(cityB).add(new int[]{cityA, weight});
        }

        int minReachableCities = Integer.MAX_VALUE;
        int selectedCity = -1;

        // Run Dijkstra from each city
        for (int sourceCity = 0; sourceCity < totalCities; sourceCity++) {
            int[] shortestDistances = new int[totalCities];
            Arrays.fill(shortestDistances, Integer.MAX_VALUE);
            shortestDistances[sourceCity] = 0;

            PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
            minHeap.offer(new int[]{sourceCity, 0}); // {city, distance}

            while (!minHeap.isEmpty()) {
                int[] current = minHeap.poll();
                int currentCity = current[0], currentDistance = current[1];

                for (int[] neighbor : adjacencyList.get(currentCity)) {
                    int neighborCity = neighbor[0], edgeWeight = neighbor[1];
                    int newDistance = currentDistance + edgeWeight;

                    if (newDistance < shortestDistances[neighborCity]) {
                        shortestDistances[neighborCity] = newDistance;
                        minHeap.offer(new int[]{neighborCity, newDistance});
                    }
                }
            }

            // Count how many cities are reachable within the threshold
            int reachableCount = 0;
            for (int targetCity = 0; targetCity < totalCities; targetCity++) {
                if (sourceCity != targetCity && shortestDistances[targetCity] <= distanceThreshold) {
                    reachableCount++;
                }
            }

            // Prefer higher-indexed city in case of tie
            if (reachableCount <= minReachableCities) {
                minReachableCities = reachableCount;
                selectedCity = sourceCity;
            }
        }

        return selectedCity;
    }
}

}
