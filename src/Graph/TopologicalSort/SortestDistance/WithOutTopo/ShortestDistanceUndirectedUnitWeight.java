package Graph.TopologicalSort.SortestDistance.WithOutTopo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistanceUndirectedUnitWeight {
    public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
        int v = adj.size();
        int[] dist = new int[v];
        Arrays.fill(dist, -1);
        
         if (src < 0 || src >= v) return dist; // invalid source check

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(src);
        dist[src] = 0;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int neighbor : adj.get(cur)) {
                if (dist[neighbor] == -1) {
                    dist[neighbor] = dist[cur] + 1;
                    queue.offer(neighbor);
                }
            }
        }

        return dist;
    }
}
