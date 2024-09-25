package Graph.TopologicalSort;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class KahnsAlgo {
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj){
        int[] indegree = assignIndegree(V, adj);
        Queue<Integer> zeroIndegree = getZeroIndegreeeVertex(indegree);
        int[] topologicalSort = new int[V];

        int i=0;
        while(zeroIndegree.size()!=0){
            int vertex = zeroIndegree.poll();
            topologicalSort[i++] = vertex;
            DecrementIndegreeOfNeighboursByOne(indegree, adj, vertex, zeroIndegree);
        }
        return topologicalSort;
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
