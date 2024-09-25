package GreedyAlgo;

public class MajorityElements {
    int getMajorityElements(int[] nums){
        int majorityElement=nums[0];
        int count = 1;
        for( int i=1; i<nums.length; i++){
            if(nums[i]!=majorityElement){
                if(count==0){
                    count=1;
                    majorityElement=nums[i];
                }else {
                    count--;
                }
            }
            else{
                count++;
            }
        }
        return majorityElement;
    }
}

