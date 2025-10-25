package DynamicProgramming.2DAndGrid;

public class TotalUniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] memo = new int[m+1][n+1]; // coordinate shift by 1 to accomodate 1 extra as recursive call -1 case
        if(m==0 || n==0) return 0;
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                memo[i][j] = -1;
            }
        }
        memo[1][1] = 1;
        return findUniquePaths( m-1, n-1, m, n, memo);
    }

    int findUniquePaths(int i, int j, int m, int n, int[][] memo){
        if(memo[i+1][j+1]!=-1) return memo[i+1][j+1];
        memo[i+1][j+1] = findUniquePaths(i-1,j, m, n, memo ) + findUniquePaths(i,j-1, m, n, memo ) ;

        return  memo[i+1][j+1];
    }

 public int uniquePathsTabulation(int m, int n) {
    int[][] memo = new int[m+1][n+1]; // coordinate shift by 1 to accomodate 1 extra as recursive call -1 case
        if(m==0 || n==0) return 0;
        // for(int i=1; i<=m; i++){
        //     for(int j=1; j<=n; j++){
        //         memo[i][j] = -1;
        //     }
        // }
        memo[1][1] = 1;
        System.out.println(Arrays.deepToString(memo));
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i==0 && j==0) continue; //as it is a base case
                memo[i+1][j+1] = memo[i][j+1] + memo[i+1][j] ;
            }
        }
        System.out.println(Arrays.deepToString(memo));
        return  memo[m][n];
        }

    public int uniquePathsTabulationOptimised(int m, int n) {
        int[] memo = new int[n+1]; // coordinate shift by 1 to accomodate 1 extra as recursive call -1 case
        if(m==0 || n==0) return 0;

        /* careful to only initialise base case in the current array we're using not the previous one
        as we have coordiate shif we may missue if we didn't handle carfully  */
        memo[1] = 1;
        int[] prevMemo = new int[n+1]; 
       
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
               if(i==0 && j==0) continue; //as it is a base case
               memo[j+1] = prevMemo[j+1] +memo[j] ;
            }

            prevMemo = memo;
        }
        return  memo[n];
    }

    //withObstables
     public int uniquePathsWithObstacles(int[][] obstacleGrid) {
       int m = obstacleGrid.length , n=obstacleGrid[0].length;
        int[] memo = new int[n+1]; // coordinate shift by 1 to accomodate 1 extra as recursive call -1 case
        if(m==0 || n==0) return 0;
        if(obstacleGrid[0][0]==1 || obstacleGrid[m-1][n-1]==1) return 0;

        /* careful to only initialise base case in the current array we're using not the previous one
        as we have coordiate shif we may missue if we didn't handle carfully  */
        memo[1] = 1;
        int[] prevMemo = new int[n+1]; 
       
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
               if(i==0 && j==0) continue; //as it is a base case
               if(obstacleGrid[i][j]==1){
                    memo[j+1] = 0;
                    continue;
               }
               memo[j+1] = prevMemo[j+1] +memo[j] ;
            }

            prevMemo = memo;
        }
        return  memo[n];
    }
}
