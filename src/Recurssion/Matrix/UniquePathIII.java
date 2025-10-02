package Recurssion.Matrix;

class SolUNiquePathIII {
    public int uniquePathsIII(int[][] grid) {
        if (grid.length==0) return 0;
        int[] cur = new int[2];
        int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int totalNonObstables= findTotalNonObstables(grid, cur);
        return recur(cur, dirs,  visited, grid, totalNonObstables);
    }

    public int findTotalNonObstables(int[][] grid, int[] cur){
        int totalNonObstables=0;
        //boolean isSet = false;
        for(int r=0; r<grid.length; r++){
            for(int c=0; c<grid[0].length; c++){
                if(grid[r][c]==1){
                    cur[0]=r;
                    cur[1]=c;
                    //isSet =true;
                    totalNonObstables++;
                } 
                if(grid[r][c]==0) totalNonObstables++;
            }
        }
        return totalNonObstables;
    }

        
    public int recur(int[] cur,int[][] dirs,boolean[][] visited,int[][] grid, int totalNonObstables){
        if(grid[cur[0]][cur[1]]==2){
            return totalNonObstables== 0 ? 1 : 0;    
        }
        
        int possinilities = 0;
        for(int[] dir: dirs){
            int[] next = {cur[0] + dir[0] , cur[1] + dir[1]};

            if(isValid(next, visited, grid)){
                visited[next[0]][next[1]] = true;
                possinilities += recur(next, dirs, visited, grid, totalNonObstables - 1);
                visited[next[0]][next[1]] = false;                
            }  
        }
        return possinilities;
    }

    public boolean isValid(int[] next, boolean[][] visited, int[][] grid) {
        if (next[0]>=0 && next[1]>=0&& next[0]<grid.length && next[1]<grid[0].length ){
            if(grid[next[0]][next[1]]==2 || !visited[next[0]][next[1]] && grid[next[0]][next[1]]==0 )  return true;
        }   
        return false;
    }
}