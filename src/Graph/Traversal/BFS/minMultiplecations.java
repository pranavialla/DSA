package Graph.Traversal.BFS;

import java.util.Queue;

public class minMultiplecations {
    // User function Template for Java
    int minimumMultiplications(int[] arr, int start, int end) {

        // Your code here
        int MOD = 100000;
        Queue<Integer> curValue = new LinkedList<>();
        int steps=0;
        curValue.add(start);
        boolean[] visited = new boolean[MOD];
        visited[start]=true;
        if(start==end) return steps;
        
      
        while(!curValue.isEmpty()){
            steps++;
            int s = curValue.size();
            
            for(int i=0; i<s; i++){
                int cur = curValue.poll();
                for(int ele : arr){
                    int val = (ele*cur)%MOD;
                    if(val==end) return steps;
                    else if (!visited[val]){
                        curValue.add(val);
                        visited[val]=true;
                    }
                 }
            }
            
        }
        return -1;
    }
}
