package DynamicProgramming.LIS;

import java.rmi.MarshalledObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        //getRecurLIS(nums.length-1, Integer.MAX_VALUE, nums);
        int ans = getMemoRecurLIS(nums.length-1, nums.length, nums, initializeDP(nums));
        System.out.println(ans);
        return ans;
    }

    private int getRecurLIS(int i, int previous, int[] nums) {
        if( i<0 ){
            return 0;
        }

        if( nums[i]<previous ){
            int take = 1 + getRecurLIS(i-1, nums[i], nums);
            int notTake = getRecurLIS(i-1, previous, nums);
            return Math.max( take, notTake);
        }
        return getRecurLIS(i-1, previous, nums);
    }

    private int[][] initializeDP(int[] nums){
        int[][] dp = new int[nums.length+1][nums.length+1];

        for(int i=0; i<=nums.length; i++){
            for(int j=0; j<=nums.length; j++){
                dp[i][j] = -1;
            }
        }

        return dp;
    }


    private int getMemoRecurLIS(int i, int previousIndex, int[] nums, int[][] dp) {
        //System.out.println(Arrays.deepToString(dp));
        if( i<0 ){
            return 0;
        }

        if( dp[i][previousIndex]!=-1){
            return dp[i][previousIndex];
        }

        int take = 0;
        if( previousIndex==nums.length || nums[i]<nums[previousIndex] ){
            take = 1 + getMemoRecurLIS(i-1, i, nums, dp);
        }

        int notTake = getMemoRecurLIS(i-1, previousIndex, nums, dp);
        dp[i][previousIndex] = Math.max( take, notTake );
        return dp[i][previousIndex];
    }


    private  int getTabulation( int[] nums, int[][] dp){
        for( int i=1; i<nums.length; i++){
            for(int previousIndex=1; previousIndex<nums.length; previousIndex++){

                int take = 0;
                if( previousIndex==nums.length || nums[i-1]<previousIndex ){
                    take = 1 + dp[i-1][i];
                }

                int notTake = dp[i-1][previousIndex];
                dp[i][previousIndex] = Math.max( take, notTake );
            }
        }
        return dp[nums.length][nums.length];
    }



















    public int getLongestIncreasingSubarray(int[] nums) {
        if (nums.length==0) return 0;
        int LIS = 1;
        int curLIS = 1;
        int previousNumber = nums[0];
        for( int i=1; i<nums.length; i++ ){
            if( nums[i]>previousNumber){
                previousNumber = nums[i];
                curLIS+=1;
            }
            else {
                previousNumber = nums[i];
                curLIS = 1;
            }
            LIS = Math.max(LIS, curLIS);
        }
        return LIS;
    }

    public void getLongestIncreasingSubsequence(int[] nums) {
        Map<Integer, ArrayList<ArrayList>> possibleSubsequences = new HashMap<>();
        int numsLength = nums.length;

        if (numsLength==0) return ;

        getAllLengthOneSubsequence(possibleSubsequences, numsLength, nums);


    }

    private void getAllLengthOneSubsequence(Map<Integer, ArrayList<ArrayList>> possibleSubsequences, int numsLength, int[] nums) {
        possibleSubsequences.put(1, new ArrayList<>());
        for(int i=0; i<numsLength; i++){
            ArrayList<Integer> lengthOneSubsequence = new ArrayList<>();
            lengthOneSubsequence.add(nums[i]);
            possibleSubsequences.get(1).add(lengthOneSubsequence);
        }
    }


}
