import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class NonDecreasingSubsequence {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        backtrack(nums, 0, new ArrayList<>(), set);
        return new ArrayList<>(set);
    }

    private void backtrack(int[] nums, int index, List<Integer> cur, Set<List<Integer>> set) {
        if (cur.size() >= 2) {
            set.add(new ArrayList<>(cur));
        }
        if (index == nums.length) return;

        // CHOOSE
        if (cur.isEmpty() || nums[index] >= cur.get(cur.size() - 1)) {
            cur.add(nums[index]);
            backtrack(nums, index + 1, cur, set);
            cur.remove(cur.size() - 1);
        }

        // NOT CHOOSE
        int nextStep = index+1;
        while(nextStep!=nums.length && nums[nextStep]==nums[index]){
            nextStep++;
        }
        backtrack(nums, nextStep, cur, set);
    }
}