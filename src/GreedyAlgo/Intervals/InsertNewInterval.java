import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i=0;
        while(i<intervals.length){ 
            int[] interval = intervals[i];
            if (interval[1] < newInterval[0]) {
                result.add(interval);   
            } else if (interval[0] > newInterval[1]) {
                /* new interval is added without overlap either by merging overlabs in the previous
                iterations in case overlap present or
                inserting at right place if overlap is not present */
                result.add(newInterval);
                while(i<intervals.length){
                    result.add(intervals[i++]);
                }
                return  result.toArray(new int[result.size()][]);
            } else {
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
            i++;
        }
        result.add(newInterval);
        return result.toArray(new int[result.size()][]);
    }
}