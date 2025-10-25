package Graph.BipatiteGraph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BipatiteGraphCheck {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1); // -1 means unvisited

        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                // You can switch to BFS(i, color, graph) if preferred
                if (!dfs(i, 0, color, graph)) return false;
            }
        }
        return true;
    }

    private boolean dfs(int node, int currentColor, int[] color, int[][] graph) {
        color[node] = currentColor;

        for (int neighbor : graph[node]) {
            if (color[neighbor] == -1) {
                if (!dfs(neighbor, 1 - currentColor, color, graph)) return false;
            } else if (color[neighbor] == currentColor) {
                return false;
            } //ignoring already colored with different color
        }
        return true;
    }

    private boolean bfs(int start, int[] color, int[][] graph) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        color[start] = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : graph[node]) {
                if (color[neighbor] == -1) {
                    color[neighbor] = 1 - color[node];
                    queue.offer(neighbor);
                } else if (color[neighbor] == color[node]) {
                    return false;
                } //ignoring already colored with different color
            }
        }
        return true;
    
}

}
