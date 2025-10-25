package Graph.MinimumSpanigTree;

public class network {
    
    public int makeConnected(int n, int[][] connections) {
        boolean[] visited = new boolean[n];
        List<List<Integer>> adj = new ArrayList<>();
        for( int i=0; i<n; i++) adj.add( new ArrayList<Integer>());
        
        for( int[] connection : connections){
            int u = connection[0], v= connection[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int components = 0, extra = 0;

        for(int i=0; i<n ; i++){
        
            if(!visited[i]){
                components++;
                System.out.println(" extras : "+ extra + " components : "+components+" i :"+i);
                Queue<Integer> q = new LinkedList<>();
                q.offer(i);
                while(!q.isEmpty()){
                    int u =  q.poll();
                    if(visited[u]) {
                        extra++;
                        continue;
                    }
                    visited[u]=true;
                    for( int v : adj.get(u)){
                        if(!visited[v]){
                            q.offer(v);
                        }
                    }
                }
                
            }
        }
        System.out.println(" extras : "+ extra + " components : "+components);
        return components-1> extra ? -1 : components-1;
    }
    int[] leader;
    int[] rank;
    public int makeConnected(int V, int[][] edges) {
        if (edges.length < V - 1) return -1;
        leader = new int[V];
        for(int i=0; i<V; i++) leader[i] = i;
        int components = V;

        int extra = 0;
        for(int[] edge : edges){
            int u =edge[0], v= edge[1];
            if(unionByRank(u, v)) components--;

        }

        return components-1;
        
    }
    
    int findLeader(int x){
        int given = x;
        while(x!=leader[x]){
            x= leader[x];
        }
        
        while(given!=leader[given]){
            leader[given] = x;
            given= leader[given];
        }
          return x ;
    }
    
    boolean unionByRank(int x, int y){
        int leaderX = findLeader(x);
        int leaderY = findLeader(y);
        
        if(leaderX==leaderY) return false;
        leader[leaderX] = leaderY;
        return true; 
    }
      
}


}
