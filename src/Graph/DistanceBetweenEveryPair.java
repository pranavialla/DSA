package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class DistanceBetweenEveryPair {

    // Dijkstra's algorithm to find the city with the smallest number of reachable cities within the distance threshold
    //this is suitable for sparse graphs : when graph has less edges
   public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            adj.get(edge[0]).add(new int[]{edge[1], edge[2]});
            adj.get(edge[1]).add(new int[]{edge[0], edge[2]});
        }

        int minReachable = Integer.MAX_VALUE;
        int resultCity = -1;

        for (int i = 0; i < n; i++) {
            int[] dist = new int[n];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[i] = 0;

            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
            pq.offer(new int[]{i, 0});

            while (!pq.isEmpty()) {
                int[] cur = pq.poll();
                int u = cur[0], d = cur[1];

                for (int[] neighbor : adj.get(u)) {
                    int v = neighbor[0], w = neighbor[1];
                    if (d + w < dist[v]) {
                        dist[v] = d + w;
                        pq.offer(new int[]{v, dist[v]});
                    }
                }
            }

            int count = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && dist[j] <= distanceThreshold) count++;
            }

            if (count <= minReachable) {
                minReachable = count;
                resultCity = i;
            }
        }

        return r
        
    }

    // Floyd-Warshall algorithm to find the city with the smallest number of reachable cities within the distance threshold
    // this is suitable for dense graphs : when graph has more edges
    public int findTheCityFloydWarshall(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];  
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            dist[i][i] = 0;
        }
}
