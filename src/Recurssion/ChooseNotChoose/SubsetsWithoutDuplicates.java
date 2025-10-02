import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        List<Integer> cur = new ArrayList();
        recur(nums, 0, result, cur);
        return result;
    }

    public static void recur(int[] nums, int i,List<List<Integer>> result, List<Integer> cur){
        if(i==nums.length){
            result.add(new ArrayList(cur));
            return;
        }

        cur.add(nums[i]);        
        recur( nums,  i+1, result, cur);
        cur.remove(cur.size()-1);

        recur( nums,  i+1, result,  cur);

    }
}