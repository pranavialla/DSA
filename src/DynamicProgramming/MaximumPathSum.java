package DynamicProgramming;

import java.util.Arrays;

public class MaximumPathSum {
        public int getMaxPathSum(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            int[] dp =  matrix[m-1];
            for( int i=m-2; i>=0; i--){
                int[] cur = new int[matrix[0].length];
                for( int j=n-1; j>=0; j--){
                    int value = dp[j];
                    int right = Integer.MIN_VALUE;
                    int left = Integer.MIN_VALUE;
                    if(j+1<n){
                        right = dp[j+1] ;
                    }
                    if(j-1>=0){
                        left = dp[j-1] ;
                    }

                    cur[j] = Math.max(right, Math.max(value, left)) + matrix[i][j];


                }
                System.out.println(Arrays.toString(dp));
                dp = cur;
            }

            int max = Integer.MIN_VALUE;
            for( int i=m-1; i>=0; i--){
                max = Math.max(max, dp[i]);
            }

            return max;
        }
}

