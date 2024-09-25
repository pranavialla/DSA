package GreedyAlgo;

import java.util.ArrayList;
import java.util.List;

public class MajorityElements2 {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int candidate1=0;
        int count1 = 0;

        int candidate2=0;
        int count2 = 0;

        for(int i=0; i<nums.length; i++){
            if(nums[i]==candidate1){
                count1++;
            }
            else if(nums[i]==candidate2){
                count2++;
            }
            else if (count1==0){
                candidate1=nums[i];
                count1++;
            }
            else if (count2==0){
                candidate2=nums[i];
                count2++;
            }
            else {
                count1--;
                count2--;
            }
        }

        int countCheck1=0;
        int countCheck2=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]==candidate1){
                countCheck1++;
            }
            else if (nums[i]==candidate2){
                countCheck2++;
            }
        }
        if(countCheck1>nums.length/3){
            ans.add(candidate1);
        }

        if(countCheck2>nums.length/3){
            ans.add(candidate2);
        }

        return ans;

    }
}
