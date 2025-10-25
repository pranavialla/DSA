package Graph.TopologicalSort.SortestDistance.WeighedAcyclicGraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class ShortestDistanceDAG {
    //https://www.geeksforgeeks.org/problems/shortest-path-in-undirected-graph/1
    static class Pair {
        int node, weight;
        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    public int[] shortestPath(int V, int E, int[][] edges) {
        List<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) graph.add(new ArrayList<>());

        int[] indegree = new int[V];
        for (int[] edge : edges) {
            graph.get(edge[0]).add(new Pair(edge[1], edge[2]));
            indegree[edge[1]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++)
            if (indegree[i] == 0) queue.offer(i);

        List<Integer> topoOrder = new ArrayList<>();
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            topoOrder.add(curr);
            for (Pair neighbor : graph.get(curr)) {
                if (--indegree[neighbor.node] == 0)
                    queue.offer(neighbor.node);
            }
        }

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        for (int node : topoOrder) {
            if (dist[node] == Integer.MAX_VALUE) continue;
            for (Pair neighbor : graph.get(node)) {
                dist[neighbor.node] = Math.min(dist[neighbor.node], dist[node] + neighbor.weight);
            }
        }

        for (int i = 0; i < V; i++)
            if (dist[i] == Integer.MAX_VALUE) dist[i] = -1;

        return dist;
    }

}
