package Graph.Dijakshatra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class NetworkDelay {
    class Solution {
    // public int networkDelayTime(int[][] times, int n, int k) {
    //     int[] timeToReach = new int[n];
    //     Arrays.fill(timeToReach, Integer.MAX_VALUE);
    //     timeToReach[k-1]=0;
    //     int networksToReach = n-1;

    //     for(int i=0; i<n; i++){
    //         int[] temp = Arrays.copyOf(timeToReach, n);
    //         for( int[] time:  times){
    //             if(timeToReach[time[0]-1]!=Integer.MAX_VALUE && timeToReach[time[0]-1]+time[2]<temp[time[1]-1]){
    //                 temp[time[1]-1] =  timeToReach[time[0]-1]+time[2];
    //             }
    //         }
    //         timeToReach = temp;
    //     }
    //     int result = Arrays.stream(timeToReach).max().orElse(-1);
    //     return  result!=Integer.MAX_VALUE ? result : -1;

    // }

    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<int[]>> adjList = new ArrayList<>();
        for( int i=0; i<=n; i++){
            adjList.add(new ArrayList<int[]>());
        }
        for(int[] time : times){
            adjList.get(time[0]).add(new int[]{time[1], time[2]});
        }

        int[] timeToReach = new int[n+1];
        Arrays.fill(timeToReach, Integer.MAX_VALUE);
        timeToReach[k]=0;
         timeToReach[0]=0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((int[] a, int[] b)->Integer.compare(a[0], b[0]));
        pq.offer(new int[]{0, k});

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            for(int[] neighbour : adjList.get(cur[1])){
                 //System.out.println(Arrays.toString(timeToReach));
                if(timeToReach[neighbour[0]]>timeToReach[cur[1]]+neighbour[1]){
                    timeToReach[neighbour[0]]=timeToReach[cur[1]]+neighbour[1];
                    pq.offer(new int[]{timeToReach[neighbour[0]], neighbour[0]});
                    //System.out.println(Arrays.toString(timeToReach));
                }
            }
        }
        int result = Arrays.stream(timeToReach).max().orElse(-1);
        return  result!=Integer.MAX_VALUE ? result : -1;

    }
}
