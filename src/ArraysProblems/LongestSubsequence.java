

import java.util.HashMap;
import java.util.Map;

public class LongestSubsequence {


    public int calculateLongestSubsequence(int[] nums) {
        int max_cons_sub = 0;
        Map<Integer, Integer> dic = new HashMap<>();
        for (int idx = 0; idx < nums.length; idx++) {
            int s = 1;
            int l = 0;
            int r = 0;
            if (dic.containsKey(nums[idx])) {
                continue;
            }
            if (dic.containsKey(nums[idx] - 1)) {
                l = dic.get(nums[idx] - 1);
            }
            if (dic.containsKey(nums[idx] + 1)) {
                r = dic.get(nums[idx] + 1);
            }
            s += l + r;
            dic.put(nums[idx], s);
            dic.put(nums[idx] - l, s);
            dic.put(nums[idx] + r, s);
            max_cons_sub = Math.max(s, max_cons_sub);

        }
        return max_cons_sub;

    }
}
