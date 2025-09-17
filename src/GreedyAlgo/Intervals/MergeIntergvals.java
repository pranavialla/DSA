package ArraysProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntergvals {
    public MergeIntergvals(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int end, start;
        List<int[]> ans = new ArrayList<>();
        if (intervals.length == 0) {
            System.out.println(Arrays.deepToString(ans.toArray(new int[0][0])));
        }
        start = intervals[0][0];
        end = intervals[0][1];
        int i = 1;
        ans.add(new int[]{start, end});
        while (i < intervals.length) {
            if (end >= intervals[i][0]) {
                end = Math.max(end, intervals[i][1]);
                ans.set(ans.size() - 1, new int[]{ans.get(ans.size() - 1)[0], end});
            } else {
                start = intervals[i][0];
                end = intervals[i][1];
                ans.add(new int[]{start, end});
            }
            i += 1;
        }
        System.out.println(Arrays.deepToString(ans.toArray(new int[ans.size()][])));
    }

}
