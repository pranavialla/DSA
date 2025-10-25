package Graph.TopologicalSort;

import java.util.*;

public class AllienDictionary {
    public String findOrder(String[] words) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < 26; i++) adjList.add(new ArrayList<>());

        boolean[] visited = new boolean[26];
        boolean[] path = new boolean[26];
        boolean[] present = new boolean[26];
        StringBuilder result = new StringBuilder();

        for (String word : words)
            for (char c : word.toCharArray())
                present[c - 'a'] = true;

        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i], w2 = words[i + 1];
            if (w1.startsWith(w2) && w1.length() > w2.length()) return ""; // prefix conflict

            int len = Math.min(w1.length(), w2.length());
            for (int j = 0; j < len; j++) {
                char c1 = w1.charAt(j), c2 = w2.charAt(j);
                if (c1 != c2) {
                    adjList.get(c1 - 'a').add(c2 - 'a');
                    break;
                }
            }
        }

        for (int i = 0; i < 26; i++) {
            if (present[i] && !visited[i]) {
                if (dfs(i, adjList, visited, path, result)) return "";
            }
        }

        return result.reverse().toString();
    }

    private boolean dfs(int node, List<List<Integer>> adjList, boolean[] visited, boolean[] path, StringBuilder result) {
        visited[node] = true;
        path[node] = true;

        for (int neighbor : adjList.get(node)) {
            if (!visited[neighbor]) {
                if (dfs(neighbor, adjList, visited, path, result)) return true;
            } else if (path[neighbor]) {
                return true;
            }
        }

        path[node] = false;
        result.append((char)(node + 'a'));
        return false;
    }

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
