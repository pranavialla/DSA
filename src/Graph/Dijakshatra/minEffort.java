package Graph.Dijakshatra;

import java.util.PriorityQueue;

public class minEffort {

    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->Integer.compare(a[2], b[2]));
        boolean[][] visited = new boolean[heights.length][heights[0].length];
        queue.offer(new int[]{0, 0, 0});
        visited[0][0]=true;
        int[][] DIRECTION = new int[][]{{1,0}, {0,1}, {-1,0}, {0, -1}};

        while(!queue.isEmpty()){
            int x = queue.peek()[0];
            int y = queue.peek()[1];
            visited[x][y] = true;
            int tempeffort =queue.peek()[2];
            queue.poll();
            if(x==heights.length-1 && y==heights[0].length-1) {
                return tempeffort;
            } 
            for(int[] direction : DIRECTION){
                int newX = x+direction[0];
                int newY = y+direction[1];
                if(isValid(newX,  newY,  heights,  visited)){
                    queue.offer( new int[]{newX, newY,Math.max(Math.abs(heights[newX][newY]-heights[x][y]),tempeffort)});
                }
            }
        }
        return -1;
    }

    public boolean isValid(int newX, int newY, int[][] heights, boolean[][] visited){
        int r=heights.length;
        int c=heights[0].length;
        return newX>=0 && newX<r && newY>=0 && newY<c && !visited[newX][newY];
    }
}
