package Graph.Traversal;

import java.util.ArrayList;

public class AdjacencyMatrixTraversal {
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
        for(int j = 0; j < V; j++){
            if(adj.get(i).get(j) == 1 &&!visited[j]){
                DFSAdjacencyMatrix(adj, j, V, visited);
            }
        }
    }
}
