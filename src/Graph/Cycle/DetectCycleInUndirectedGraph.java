package Graph.Cycle;

import java.util.ArrayList;
import java.util.Queue;

class Solution {
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();
        for(int i=0; i<V; i++) adjacencyList.add(new ArrayList<Integer>()); 
        for( int[] edge : edges){
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }
        
        boolean[] visited = new boolean[V];
        for(int i =0 ; i<V; i++){
            if(!visited[i]){
                // if(BFS(i, visited, adjacencyList)){
                //     return true;
                // }
                if(DFS(i,-1, visited, adjacencyList)){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean BFS(int i, boolean[] visited, ArrayList<ArrayList<Integer>> adjacencyList){
        Queue<int[]> queue = new LinkedList<>();
        visited[i] = true;
        queue.offer(new int[]{i, -1});
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int vertex = cur[0], parent = cur[1];
            for(int  neighbour : adjacencyList.get(vertex)){
                if(visited[neighbour] && neighbour!=parent){
                    return true;
                }
                else if(!visited[neighbour]){
                    visited[neighbour] = true;
                    queue.offer(new int[]{neighbour, vertex});
                }
            }
        }
        return false;
    }
    
    public boolean DFS(int i, int parent, boolean[] visited, ArrayList<ArrayList<Integer>> adjacencyList){
       visited[i] = true;
       for(int  neighbour : adjacencyList.get(i)){
            if(visited[neighbour] && neighbour!=parent){
                return true;}
            else if(!visited[neighbour]){
                visited[neighbour] = true;
                if(DFS(neighbour, i, visited, adjacencyList)){
                    return true;
                }
            }
        }
        return false;
    }
}