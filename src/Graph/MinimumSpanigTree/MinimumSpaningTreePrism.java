package Graph.MinimumSpanigTree;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MinimumSpaningTreePrism {
    int[] leader ;
    int[] rank ;
    public int spanningTree(int V, int[][] edges) {
        // Build adjacency list: adj[u] = list of {v, weight}
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], wt = edge[2];
            adj.get(u).add(new int[]{v, wt});
            adj.get(v).add(new int[]{u, wt});
        }

        boolean[] visited = new boolean[V];
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        int mstWeight = 0;

        // Format: {weight, node}
        minHeap.offer(new int[]{0, 0}); // Start from node 0

        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int weight = current[0], node = current[1];

            if (visited[node]) continue;

            visited[node] = true;
            mstWeight += weight;

            for (int[] neighbor : adj.get(node)) {
                int nextNode = neighbor[0], edgeWeight = neighbor[1];
                if (!visited[nextNode]) {
                    minHeap.offer(new int[]{edgeWeight, nextNode});
                }
            }
        }

        return mstWeight;
    }

    public int spanningTree(int V, int[][] edges) {
        leader = new int[V];
        rank = new int[V];
        for(int i=0; i<V; i++) leader[i] = i;
        int mst = 0;
        Arrays.fill(rank, 1);
        Arrays.sort(edges, (int[] a, int[] b)->Integer.compare(a[2], b[2]));
        
        for(int[] edge : edges){
            int u =edge[0], v= edge[1], w = edge[2];
            int leaderU = findLeader(u);
            int leaderV = findLeader(v);
            if(leaderU!=leaderV){
                unionByRank(u, v);
                mst+=w;
            }
        }
        return mst;
        
    }
    
    int findLeader(int x){
          if(x==leader[x]) return x;
          leader[x] = findLeader(leader[x]);
          return leader[x] ;
    }
    
    void unionByRank(int x, int y){
        int leaderX = findLeader(x);
        int leaderY = findLeader(y);
        
        int rankX = rank[leaderX];
        int rankY =  rank[leaderY];
        
        if(rankX == rankY){
            leader[leaderX] = y;
            rank[leaderY]++;
        }
        else if(rankX > rankY){
            leader[leaderY] = x;
        }
        else{
             leader[leaderX] = y;
        }
        
        
        
    }
    
    
    
}
