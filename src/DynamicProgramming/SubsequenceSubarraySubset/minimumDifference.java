package DynamicProgramming.SubsequenceSubarraySubset;

import java.util.Arrays;

public class minimumDifference {
    public int minimumDifference(int[] nums) {
        int totalSum = Arrays.stream(nums).sum();
        return recur(nums.length-1, 0 ,0, totalSum,   nums);
    }

    public int recur(int i, int array1Length ,int array1Sum, int array2Sum, int[] nums){
        
        if(array1Length==nums.length/2) return Math.abs(array1Sum - array2Sum);
        if(i==-1){
            return Integer.MAX_VALUE;
        }
        
        int take = recur( i-1,  array1Length+1 , array1Sum+nums[i], array2Sum-nums[i],  nums);
        int notTake = recur( i-1,  array1Length , array1Sum, array2Sum,  nums);

        return Math.min(take, notTake);
    }

} 