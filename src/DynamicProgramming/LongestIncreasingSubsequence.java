package DynamicProgramming;

import java.rmi.MarshalledObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestIncreasingSubsequence {
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
