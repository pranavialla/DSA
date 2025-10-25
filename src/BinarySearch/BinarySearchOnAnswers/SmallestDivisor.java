package BinarySearch.BinarySearchOnAnswers;

import java.util.Arrays;

public class SmallestDivisor {
   

    public boolean isLessThanThreshold(int[] nums, int threshold, int curDivisor) {
        int curThresold = 0;
        for(int num : nums){
            curThresold += Math.ceil((double)num/curDivisor);
        }
        return curThresold <=threshold;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        Arrays.sort(nums);
        //left - thershold high right -low
        int left = nums[0], right = nums[nums.length-1], ans = -1;

        while(left<=right){
            int mid = left +(right-left)/2;

            if(isLessThanThreshold(nums, threshold, mid)){
                ans = mid;
                right = mid-1;}
            else{
                left= mid+1;}
        }
        return ans;
    }
}
