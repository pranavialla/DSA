package Graph.Cycle;

import java.util.ArrayList;
import java.util.Queue;
import java.util.ArrayDeque;

public class DetectCycleInGraph {
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj){
        int[] indegree = assignIndegree(V, adj);
        Queue<Integer> zeroIndegree = getZeroIndegreeeVertex(indegree);
        boolean[] visited = new boolean[V];

            while(zeroIndegree.size()!=0){
                int vertex = zeroIndegree.poll();
                visited[vertex] = true;
                DecrementIndegreeOfNeighboursByOne(indegree, adj, vertex, zeroIndegree);
        }
        return isAllVerticesVisited(visited);
}

    private boolean isAllVerticesVisited(boolean[] visited) {
        for(int i=0; i<visited.length; i++) {
            if(!visited[i])
                return true;
        }
        return false;
    }

    private static void DecrementIndegreeOfNeighboursByOne(int[] indegree,
                                                       ArrayList<ArrayList<Integer>> adj,
                                                       int vertex,
                                                       Queue<Integer> zeroIndegree) {
    for(int neighbor : adj.get(vertex)){
        indegree[neighbor]--;
        if(indegree[neighbor]==0){
            zeroIndegree.add(neighbor);
        }
    }
}

    private static Queue<Integer> getZeroIndegreeeVertex(int[] indegree) {
        Queue<Integer> zeroIndegree = new ArrayDeque<>();
        for( int i=0; i<indegree.length; i++){
            if( indegree[i]==0){
                zeroIndegree.add(i);
            }
        }
        return zeroIndegree;
    }

    private static int[] assignIndegree(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] indegree = new int[V];
        for(int i = 0; i < V; i++){
            for(int neighbor : adj.get(i)){
                indegree[neighbor]++;
            }
        }
        return indegree;
    }
}

