

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

    public List<List<Integer>> subsetsWithDup1(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        Arrays.sort(nums);
        List<Integer> cur = new ArrayList();
        recur(nums, 0, result, cur);
        return result;
    }

    public static void recur(int[] nums, int i,List<List<Integer>> result, List<Integer> cur){
        if(i==nums.length){
            result.add(new ArrayList(cur));
            return;}

            cur.add(nums[i]);        
            recur( nums,  i+1, result, cur);
            cur.remove(cur.size()-1);

            int nextIndex = i+1;
            while (nextIndex < nums.length && nums[nextIndex] == nums[i]) {
            nextIndex++;
            }
            recur( nums,  nextIndex, result,  cur);

    }


}
