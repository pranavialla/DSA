package ArraysProblems;
import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans=new LinkedList<>();
        for (int i=0; i<nums.length-2; i++){
            if (i==0 || (i>0 && nums[i]!=nums[i-1])){
                int sum=nums[i];
                int l=i+1;
                int r=nums.length-1;
                while(l<r){
                    int s=nums[l]+nums[r];
                    if(s+sum==0){
                        ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        while(l<r && nums[l]==nums[l+1]) l++;
                        while(l<r && nums[r]==nums[r-1]) r--;
                        l++;
                        r--;
                    }
                    else if(s+sum>0) r--;
                    else if(s+sum<0) l++;
                }
            }
        }

        return ans;
    }

}
