package DynamicProgramming.SubsequenceSubarraySubset;

import java.util.Arrays;

public class PerfectSubSum {

    public int perfectSum1(int[] nums, int target) {
        // code here
        int[][] dp = new int[nums.length][target+1];
        for(int[] a : dp) Arrays.fill(a, -1);
        return recur1(nums.length-1, target, nums, dp);
    }
    
    public int recur1( int i, int target, int[] nums, int[][] dp ) {
        // code here
        if(i<0 && target==0) return 1;
        if (i<0) return 0;
        
        if( dp[i][target]!=-1) return  dp[i][target];
        
        int take=0;
        if(target-nums[i]>=0){
            take = recur1(i-1, target-nums[i], nums, dp);
        }
        
        int notTake = recur1(i-1, target, nums, dp) ;
        
        dp[i][target] = take+notTake;
        return dp[i][target];
        
    }


    // Function to calculate the number of subsets with a given sum
    public int perfectSum(int[] nums, int target) {
        // code here
        int[][] dp = new int[nums.length+1][target+1];
        //for(int[] a : dp) Arrays.fill(a, -1);
        return recur( target, nums, dp);
    }
    
    public int recur( int target, int[] nums, int[][] dp ) {
        // code here

        for(int i=0; i<=nums.length; i++) dp[i][0]= 1;
        
        for(int i=1; i<=nums.length; i++){
            for(int curtarget=0; curtarget<=target; curtarget++){
        
                int take=0;
                if(curtarget-nums[i-1]>=0){
                    take = dp[i-1][curtarget-nums[i-1]];
                }
                
                int notTake = dp[i-1][curtarget];
                
                dp[i][curtarget] = take+notTake;
            }
        }
        
        return dp[nums.length][target];
        
    }
} {
    
}
