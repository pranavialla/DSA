package DynamicProgramming;

public class MinimumPathSum {
    int get(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n];
        for(int i=m-1; i>=0; i-- ){
            for(int j=n-1; j>=0; j--){
                if(i==m-1 && j==n-1){
                    dp[j] =grid[i][j];
                    continue;
                }
                if(j==n-1){
                    dp[j] =grid[i][j] + dp[j];
                    continue;
                }
                if(i==m-1){
                    dp[j] =grid[i][j] + dp[j+1];
                    continue;
                }
                dp[j] = Math.min( dp[j], dp[j+1]) + grid[i][j];
            }
        }
        return dp[0];
    }
}
