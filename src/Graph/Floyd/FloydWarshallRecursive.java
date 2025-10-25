package Graph.Floyd;
    import java.util.Arrays;

public class FloydWarshallRecursive {

    private static final int INF = 1000000; // Represents infinity

    /**
     * Finds the shortest path from i to j using intermediate vertices {1, ..., k}.
     * @param graph The initial adjacency matrix (0-indexed).
     * @param i The source vertex.
     * @param j The destination vertex.
     * @param k The set of allowed intermediate vertices {0, ..., k-1}.
     * @return The shortest distance.
     */
    public int shortestPathRecursive(int[][] graph, int i, int j, int k) {
        // Base Case: k = 0 (No intermediate vertices allowed)
        if (k == 0) {
            // Distance is the direct edge weight D(0)[i][j]
            return graph[i][j]; 
        }

        // Recursive Case: D(k)[i][j] = min(D(k-1)[i][j], D(k-1)[i][k] + D(k-1)[k][j])

        // Path that does NOT use vertex k-1 (since k-1 is the k-th vertex)
        int pathWithoutK = shortestPathRecursive(graph, i, j, k - 1); 

        // Path that DOES use vertex k-1
        int pathThroughK = INF;
        
        int dist_i_k = shortestPathRecursive(graph, i, k - 1, k - 1);
        int dist_k_j = shortestPathRecursive(graph, k - 1, j, k - 1);

        // Check for overflow before addition
        if (dist_i_k != INF && dist_k_j != INF) {
            pathThroughK = dist_i_k + dist_k_j;
        }

        return Math.min(pathWithoutK, pathThroughK);
    }
    
    // Helper method to call the recursive function for all pairs
    public int[][] computeAllPairs(int[][] graph) {
        int V = graph.length;
        int[][] dist = new int[V][V];
        
        // Initialize with initial distances (k=0 equivalent)
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                dist[i][j] = graph[i][j];
            }
        }
        
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                // Find shortest path using all V vertices as intermediates (k=V)
                dist[i][j] = shortestPathRecursive(dist, i, j, V);
            }
        }
        return dist;
    }
}
