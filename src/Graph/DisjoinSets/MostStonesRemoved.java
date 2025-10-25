package Graph.DisjoinSets;

import java.util.Arrays;

public class MostStonesRemoved {
    int[] leader;
    int[] rank;

    int find(int x){
        if(x==leader[x]) return x;
        leader[x] = find(leader[x]);
        return leader[x];
    }

    boolean union(int x, int y){
        int leaderX = find(x);
        int leaderY = find(y);
        
        if(leaderX==leaderY) return false;

        int rankX = rank[leaderX];
        int rankY = rank[leaderY];

        if(rankX==rankY){
            leader[leaderX] = leaderY;
            rank[leaderY]+=2;
            rank[leaderX]+=1;
        }
        else if(rankX<rankY){
            leader[leaderX] = leaderY;
            rank[leaderX]+=1;
        }
        else{
            leader[leaderY] = leaderX;
            rank[leaderY]+=1;
        }
        return true;
    }


    public int removeStones(int[][] stones) {
        int r=0, c = 0;
        for(int[] stone : stones){
            r= Math.max( r, stone[0]+1);
            c= Math.max( c, stone[1]+1);
        }
        
        // consider each row as a node and each col as a node and stone is connection. when stone is added
        // we make connection to the r and c. then all the stone in the row is connected to all the 
        // stone  in col
        int components = r + c;
        int totalStones = stones.length;

        leader = new int[components];
        for(int i=0 ; i<components ; i++){
            leader[i] = i;
        }
        rank = new int[components];
        
        for(int[] stone : stones){
            int x = stone[0], y= stone[1] + r  ; // connected node x to node y - >node x = x ,  node y = rows + y (0...r-1 r...r+c-1), 
            if(union(x, y)) components-- ;

        }

        System.out.println(Arrays.toString(rank));
        System.out.println(components);
        int nodesWithNoStones = 0;

        for(int eRank : rank){
            if(eRank==0) nodesWithNoStones++;
        } 

        return totalStones - components + nodesWithNoStones;

    }
    //  1   
    // 
    // 3-6-7-2-5-0-4
    // 
    //component = 2
}
