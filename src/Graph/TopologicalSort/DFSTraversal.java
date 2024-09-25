package Graph.TopologicalSort;

import java.util.ArrayList;
import java.util.Stack;

public class DFSTraversal {
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // add your code here
        boolean[] visited = new boolean[adj.size()];
        Stack<Integer> stack = new Stack<Integer>();

        int curPosition = 0;

        for (int i = 0; i < V; i++){
            if (!visited[i])
                DFS(i, visited, stack, adj, curPosition);
        }



        return getArray(stack, V);
    }

    private static int[] getArray(Stack<Integer> stack, int V) {
        int[] result = new int[V];
        for (int i = 0; i < V; i++){
            result[i] = stack.pop();
        }
        return result;

    }

    private static void DFS(int i, boolean[] visited, Stack<Integer> stack, ArrayList<ArrayList<Integer>> adj, int curPosition) {
        visited[i] = true;
        for (Integer neighbor : adj.get(i)) {
            if (!visited[neighbor])
                DFS(neighbor, visited, stack, adj, curPosition);
        }
        stack.push(i);
    }
}
