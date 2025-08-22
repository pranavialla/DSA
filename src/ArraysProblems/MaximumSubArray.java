package ArraysProblems;

public class MaximumSubArray {

    public int maxSubArray(int[] nums) {
        int curMaximumSubArray=nums[0];
        int maximumSubArraySoFar=nums[0];
        int prevCurMax=nums[0];
        for(int i=1; i<nums.length ; i++){
            curMaximumSubArray=Math.max(nums[i], prevCurMax + nums[i]) ;
            maximumSubArraySoFar=Math.max(maximumSubArraySoFar, curMaximumSubArray);
        }
        return maximumSubArraySoFar;
    }
}
