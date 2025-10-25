package Graph.DisjoinSets;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Flipping0ForLargeIsland {  
    int[] leader ;
    int[] size ;
    int find(int x){
        if(x==leader[x]) return x;
        leader[x]=find(leader[x]);
        return leader[x];
    }

    boolean isValid(int x, int y, int r, int c){
        return x<r && x>=0 && y<c && y>=0;
    }

    
    int unionBySize(int x, int y){
        int leaderX = find(x);
        int leaderY = find(y);
        if(leaderX == leaderY) return 0;
        int sizeLeaderX = size[leaderX];
        int sizeleaderY = size[leaderY];

        if(sizeLeaderX<=sizeleaderY){
            leader[leaderX] = leaderY;
             size[leaderY] +=sizeLeaderX;
             return size[leaderY];
        }
        else if(sizeLeaderX>sizeleaderY){
            leader[leaderY] = leaderX;
            size[leaderX] +=sizeleaderY;
            return size[leaderX];
        }
        return -1;

    }


    public int largestIsland(int[][] grid) {
        int r= grid.length;
        int c = grid[0].length ;

       leader = new int[grid.length * grid[0].length];
       for(int i=0; i<r*c; i++) leader[i]=i;
       size = new int[grid.length * grid[0].length];
       Arrays.fill(size, 1);

       int[][] DIRECTIONS = new int[][]{{0, 1},{1, 0},{-1, 0},{0, -1}};

       for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(grid[i][j]==1){
                    for (int[] direction : DIRECTIONS){
                    int adjR = i+direction[0];
                    int adjC = j + direction[1];
                    
                    if(isValid(adjR, adjC, r, c) && grid[adjR][adjC]==1){
                        unionBySize(c*i+j, c*adjR+adjC);
                        }
                    }  
                }
                 
            }
       }
       
        int maxFlipable  = 0;
       for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                int temp = 1;
                if(grid[i][j]==0){
                    Set<Integer> seen = new HashSet<>();
                    for (int[] direction : DIRECTIONS){
                        int adjR = i+direction[0];
                        int adjC = j + direction[1];
                        if(isValid(adjR, adjC, r, c)  && grid[adjR][adjC] == 1 ){   
                         int root = find(c*adjR+adjC);
                            if (seen.add(root)) {
                                temp += size[root];
                            }   
                        }
                    }  
                }
               
                maxFlipable = Math.max(maxFlipable, temp );

            }
        }
        for (int i = 0; i < r*c; i++) {
            if (leader[i] == i) {
                maxFlipable = Math.max(maxFlipable, size[i]);
            }
        }
        return maxFlipable;

    }

}
