package DynamicProgramming.SubsequenceSubarraySubset;

import java.util.Arrays;

public class PartitionDSum {
    int countPartitions(int[] arr, int d) {
        // code here
        int totalSum = Arrays.stream(arr).sum();
        
        if ((totalSum + d) % 2 != 0 || totalSum < d) return 0;
        int target =(d+totalSum)/2;
        
        int[][] memo = new int[arr.length][target+1];
        for(int[] e : memo) Arrays.fill(e, -1);
        
        return recur(arr.length-1, target, arr, memo);
    }
    
    int recur(int i, int target,  int[] arr, int[][] memo){
        if(i<0 && target==0){
            return 1;
        }
        if(i<0) return 0;
        
        if(memo[i][target]!=-1) return memo[i][target];
        
        int take = 0;
        if(target - arr[i]>=0){
            take = recur( i-1,  target - arr[i],  arr, memo);
        }
        int nottake = recur( i-1,  target,  arr, memo);
        
        memo[i][target] =  take+nottake ;
        
        return memo[i][target];
    }


    int countPartitions1(int[] arr, int d) {
        // code here
        int totalSum = Arrays.stream(arr).sum();
        int[][] memo = new int[arr.length+1][totalSum+1];

        return recur( totalSum, d , arr, memo);
    }
    
    int recur1(  int totalSum, int d , int[] arr, int[][] memo){
        // if(i<0 && curSum-exCluded==d){
        //     return 1;
        // }
        if ((totalSum + d) % 2 != 0 || totalSum < d) return 0;
        for(int i=0; i<=arr.length; i++) memo[i][0]=1;
        int s1 =(d+totalSum)/2;
        
        for(int i=1; i<=arr.length; i++){
            for(int curSum=0; curSum<=s1; curSum++){
                int take=0;
                if(curSum-arr[i-1]>=0){
                    take =memo[i-1][curSum - arr[i-1]];
                }
                int nottake = memo[i-1][curSum];
                
                memo[i][curSum] =  take+nottake ;
            }
        }
        
        return memo[arr.length][s1];
    }
}
