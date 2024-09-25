package Graph.TopologicalSort;

import java.util.*;

public class AllienDictionary {
    public String findOrder(String[] dict, int n, int k) {
        // Write your code here
        ArrayList<ArrayList<Integer> > adjacencyList = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<26; i++)
            adjacencyList.add(new ArrayList<Integer>());
        for(int i = 0; i < n-1; i++){
            String s1 = dict[i];
            String s2 = dict[i+1];
            for(int j=0; j<Math.min(s1.length(),s2.length()); j++) {
                if (s1.charAt(j) != s2.charAt(j)) {
                    adjacencyList.get(s1.charAt(j) - 'a').add(s2.charAt(j) - 'a') ;
                    break;
                }
            }
        }
        int[] dictionaryOrder = topoSort(k, adjacencyList);
        String result= "";
        System.out.println(Arrays.toString(dictionaryOrder));
        for(int word : dictionaryOrder) {
            result += Character.toString((char) word+'a');
        }
        return result;

    }

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
