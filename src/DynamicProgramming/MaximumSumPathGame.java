package DynamicProgramming;

import java.util.Arrays;

public class MaximumSumPathGame {
    public int get(int[][] matrix){

        int m = matrix.length;
        int n = matrix[0].length;
        int max= Integer.MIN_VALUE;
        System.out.println("0000000");
        int[] dp =  new int[matrix[0].length];
        for( int i=m-1; i>=0; i--){
            System.out.println("1");
            max= Integer.MIN_VALUE;
            for( int j=n-1; j>=0; j--){

                System.out.println("2");
                if(i==m-1){
                    dp[j] = matrix[i][j];
                }
                int value = matrix[i][j];
                if(j+1<n){
                    value=Math.max(dp[j+1], value) ;
                }
                if(j-1<n){
                    value= Math.max(dp[j-1], value);
                }

                dp[j] = value;
                if (i==0){
                    max = Math.max(max, dp[j]);
                }
            }

        }
        return max;
    }
}
