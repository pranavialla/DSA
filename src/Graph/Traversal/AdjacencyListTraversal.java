package Graph.Traversal;

import java.util.ArrayList;

public class AdjacencyListTraversal {
    public void traverse(ArrayList<ArrayList<Integer>> adj, int V){
        boolean[] visited = new boolean[V];
        for(int i =0; i < V; i++){
            if(!visited[i]){
                DFSAdjacencyMatrix(adj, i, V, visited);
            }
        }
    }

    private void DFSAdjacencyMatrix(ArrayList<ArrayList<Integer>> adj, int i, int V, boolean[] visited) {
        visited[i] = true;
        for(int neighbor : adj.get(i)){
            if(!visited[neighbor]){
                DFSAdjacencyMatrix(adj, neighbor, V, visited);
            }
        }
    }
}