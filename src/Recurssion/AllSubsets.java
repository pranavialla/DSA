package Recurssion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllSubsets {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> subsetsWithDuplicates=new ArrayList<>();
        List<Integer> subset=new ArrayList<>();
        Arrays.sort(nums);
        subsetsWithDuplicates.add(new ArrayList<>());
        return getsubsetsWithDuplicates(nums, subsetsWithDuplicates, subset, 0);

    }

    private List<List<Integer>> getsubsetsWithDuplicates(int[] nums, List<List<Integer>> subsetsWithDuplicates, List<Integer> subset, int startIndex) {
        for(int i=startIndex; i<nums.length; i++){
            if(i==startIndex || (i!=startIndex & nums[i]!=nums[i-1])){
                List<Integer> newSubset=new ArrayList<>(subset);
                newSubset.add(nums[i]);
                subsetsWithDuplicates.add(newSubset);
                getsubsetsWithDuplicates(nums,subsetsWithDuplicates ,  newSubset, i+1);
            }
        }
        return subsetsWithDuplicates;
    }
}
