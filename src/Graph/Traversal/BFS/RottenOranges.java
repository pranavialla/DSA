package Graph.Traversal.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    public int orangesRotting(int[][] grid) {
        int row = grid.length;
        int col=grid[0].length;
        int freshOranges = 0;
        Queue<int[]> rottenOranges = new LinkedList<>();


        /*consider all rotten oranges are in a single level and traverse all of the oranges level my level(vy loading all rotten oranges)
        till there nothing to reach
        there are no fresh oranges or no rotten oranges to traverse */
        for(int r= 0; r<row; r++){
            for(int c=0; c<col; c++){
                if(grid[r][c]==1){
                    freshOranges++;
                }
                if(grid[r][c]==2){
                    rottenOranges.offer(new int[]{r,c});
                }
            }
        }

        //boolean[][] visited = new boolean[grid.length][grid[0].length];
        //visited[r][c] = true;
        int level=0; //timeToSpoil
        if(freshOranges==0) return level;
        while(!rottenOranges.isEmpty()){
            int levelSize = rottenOranges.size();
            level++;
            for( int i=0; i<levelSize; i++){
                int[] cur = rottenOranges.poll();
                for(int[] direction : new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}}){
                    if(cur[0]+direction[0]>=0 && cur[0]+direction[0]<row && cur[1]+direction[1]>=0 && cur[1]+direction[1]<col){
                        if(grid[cur[0]+direction[0]][cur[1]+direction[1]]==1){
                            //visited[r][c] = true;
                            freshOranges--;
                            grid[cur[0]+direction[0]][cur[1]+direction[1]] = 2;
                            rottenOranges.offer(new int[]{cur[0]+direction[0], cur[1]+direction[1]});
                            }
                        }
                        if(freshOranges==0) return level;
                }  
            }
        }
        return freshOranges==0 ? level : -1;
    }
}
