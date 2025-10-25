package Graph.Cycle;

import java.util.ArrayList;
import java.util.List;

public class DetectCycleInDirectedGraph {
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        List<List<Integer>> adjList = new ArrayList<>();
        boolean[] path = new boolean[V];
        
        for (int i = 0; i < V; i++) adjList.add(new ArrayList<>());
        for( int[] edge :  edges){
            adjList.get(edge[0]).add(edge[1]);
        }
        
        boolean[] visited = new boolean[adjList.size()];
        
        for( int i=0; i<visited.length; i++){
            if(visited[i]==false){
                if(DFS(i,visited, adjList, path)) return true;
            }
        }
        return false;
    }
    
     public boolean DFS(int i,boolean[] visited, List<List<Integer>> adjList, boolean[] path){
        visited[i] = true;
        path[i]=true;
        for(int neighbour : adjList.get(i)){
            if(!visited[neighbour] ){
                if(DFS(neighbour, visited, adjList, path)) return true;
                //path[i]=false;
            }
            else if(path[neighbour]){
                //we came across this node in the path
                return true;
            }
        }
        path[i]=false;
        return false;
     }
}
