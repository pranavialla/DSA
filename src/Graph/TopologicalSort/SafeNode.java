package Graph.TopologicalSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

public class SafeNode {
    class Solution {
    public List<Integer> eventualSafeNodes1(int[][] graph) {
        ArrayList<List<Integer>> revAdj = new ArrayList<>();
        for(int i=0; i<graph.length; i++) revAdj.add(new ArrayList<>());
        int[] outDegree = new int[graph.length];
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> safeNode = new ArrayList<>();

        for ( int i=0; i<graph.length ; i++) {
            outDegree[i]= graph[i].length;
            if (outDegree[i] == 0) queue.offer(i);
            for(int neighbour : graph[i]){
                revAdj.get(neighbour).add(i);
            }  
        }

        int completed = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            safeNode.add(course);
            //System.out.println("len : "+ graph[course].length);
            for (int next : revAdj.get(course)) {
                //System.out.println(Arrays.toString(outDegree));
                if (--outDegree[next] == 0) queue.offer(next);
            }
        }

        Collections.sort(safeNode);
        return safeNode;
    }

     public boolean dfs(int node,int vis[],int safe[],int path[],int graph[][]){
        vis[node]=1;
        path[node]=1;

        for(int i:graph[node]){
            if(vis[i]==0) {
                if(dfs(i,vis,safe,path,graph)) return true;
            }
            else if(path[i]==1) return true; 
        }
      
        path[node]=0;
        safe[node]=1;
        return false;
    }
    public List<Integer> eventualSafeNodes2 (int[][] graph) {
        int V=graph.length;
        int vis[]=new int[V];
        int safe[]=new int[V];
        int path[]=new int[V];

        for(int i=0;i<V;i++){
            if(vis[i]==0) 
              dfs(i,vis,safe,path,graph);
        }
        
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<V;i++){
            if(safe[i]==1) ans.add(i);
        }

        return ans; 
}
