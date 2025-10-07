package DynamicProgramming.SubsequenceSubarraySubset;

import java.util.Arrays;

public class PartitionEqualSubsets {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
         for(int num:nums){
            totalSum+=num;
         }
         if( totalSum%2!=0 ) return false;
         int[][] dp = new int[nums.length][(totalSum/2)+1];
         
         fill2DArrayWithMinusOne(dp);
        return recur( nums.length-1, totalSum/2,  nums, dp)>0;
    }

    public int recur(int i, int remainingSum, int[] arr, int[][] dp){
        if(i==0) return remainingSum==arr[i] ? 1 : 0;
        if(remainingSum<0) return -1;
        if(dp[i][remainingSum]!=-1) return dp[i][remainingSum];
        
        int take = recur( i-1,  remainingSum - arr[i],  arr, dp);
        if (take>0){
            dp[i][remainingSum] = 1 ; 
            return dp[i][remainingSum];
        }
        int notTake = recur( i-1,  remainingSum, arr, dp);
        dp[i][remainingSum] =  notTake ; 
        return dp[i][remainingSum] >=1 ? dp[i][remainingSum] : 0;

    }

    public static void fill2DArrayWithMinusOne(int[][] arr) {
        for (int[] row : arr) {
            Arrays.fill(row, -1);
        }
    }
      
} 

class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
         for(int num:nums){
            totalSum+=num;
         }
        // System.out.println(totalSum%2);
         if( totalSum%2!=0 ) return false;
         int[][] dp = new int[nums.length][(totalSum/2)+1];
         
         fill2DArrayWithMinusOne(dp);
        return recur(totalSum/2,  nums, dp)>0;
    }

    public int recur(int remainingSum, int[] arr, int[][] dp){
        for(int i=0; i<arr.length; i++){
             dp[i][0]=1;
        }
        for(int curSum=1; curSum<=remainingSum; curSum++){
            if(curSum- arr[0]<0){
                dp[0][curSum] = 0;
                continue;
            }
            dp[0][curSum]=curSum - arr[0]==0 ? 1: 0;
            
        }
        
        for(int i=1; i<arr.length; i++){
            for(int curSum=1; curSum<=remainingSum; curSum++){
                if(curSum - arr[i]<0){
                    dp[i][curSum] = dp[i-1][curSum];
                    continue;
                }
                int take =dp[i-1][curSum - arr[i]];
                if (take>0){
                    dp[i][curSum] = 1 ; 
                    continue;
                }
                int notTake = dp[i-1][curSum];
                dp[i][curSum] =  notTake  ;
            }
        }
        // System.out.println("answer");
        // System.out.println(Arrays.deepToString(dp));
        
        return dp[arr.length-1][remainingSum] >=1 ? dp[arr.length-1][remainingSum] : 0;

    }

    public static void fill2DArrayWithMinusOne(int[][] arr) {
        for (int[] row : arr) {
            Arrays.fill(row, -1);
        }
    }

    //[[1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1], [1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0], [1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1], [1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1]]
      
}

lass Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
         for(int num:nums){
            totalSum+=num;
         }
        // System.out.println(totalSum%2);
         if( totalSum%2!=0 ) return false;
         int[] dp = new int[(totalSum/2)+1];
         
         fill2DArrayWithMinusOne(dp);
        return recur(totalSum/2,  nums, dp)>0;
    }

    public int recur(int remainingSum, int[] arr, int[] dp){
        
        dp[0]=1;
        
        for(int curSum=1; curSum<=remainingSum; curSum++){
            if(curSum- arr[0]<0){
                dp[curSum] = 0;
                continue;
            }
            dp[curSum]=curSum - arr[0]==0 ? 1: 0;
            
        }
        
        for(int i=1; i<arr.length; i++){
            int[] temp = new int[remainingSum+1];
            for(int curSum=1; curSum<=remainingSum; curSum++){
                if(curSum - arr[i]<0){
                    temp[curSum] = dp[curSum];
                    continue;
                }
                int take =dp[curSum - arr[i]];
                if (take>0){
                    temp[curSum] = 1 ; 
                    continue;
                }
                int notTake = dp[curSum];
                temp[curSum] =  notTake  ;
            }
            dp = temp;
        }
        return dp[remainingSum] >=1 ? dp[remainingSum] : 0;

    }

    public static void fill2DArrayWithMinusOne(int[] arr) {
            Arrays.fill(arr, -1);
    }

    //[[1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1], [1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0], [1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1], [1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1]]
      
}