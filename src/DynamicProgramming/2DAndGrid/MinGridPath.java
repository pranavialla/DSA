package DynamicProgramming.2DAndGrid;

public class MinGridPath {
   
    public int minPathSum(int[][] grid) {
        int r = grid.length;
        if(r==0) return 0;
        int c = grid[0].length;

        int[][] memo = new int[r+1][c+1];

        for(int i =0; i<=r; i++){
            memo[i][0] = Integer.MAX_VALUE;
            
        }
        for(int j=0; j<=c; j++){
            memo[0][j] = Integer.MAX_VALUE;
        }
        memo[1][1] = grid[0][0];
        //System.out.println(Arrays.deepToString(memo));
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(i==0 && j==0) continue;
                int top =  memo[i][j+1];
                int left = memo[i+1][j];
                memo[i+1][j+1] = Math.min(top, left) + grid[i][j]; 
            }
            //System.out.println(Arrays.deepToString(memo));
        }
        //System.out.println(Arrays.deepToString(memo));

        return  memo[r][c];
      
    }
    
    public int minPath(int i, int j, int[][] grid, int[][] memo){
        if(memo[i+1][j+1]!=-1) return memo[i+1][j+1];

        int top =  minPath( i-1,  j,  grid, memo);
        int left = minPath( i,  j-1, grid, memo);


        memo[i+1][j+1] = Math.min(top, left) + grid[i][j]; 
        return memo[i+1][j+1];
    }
}
}
