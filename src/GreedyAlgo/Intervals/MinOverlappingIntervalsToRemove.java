class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b)->a[1]-b[1]);
        if(intervals.length<=1) return 0;
        int minOverlap = 0, i=0;
        int prevConsideredIntervalEnd = Integer.MIN_VALUE;
        while(i<intervals.length){
            if(intervals[i][0]<prevConsideredIntervalEnd){
                minOverlap++;
                /*
                    not considering the interval 
                    as it started earlier than cur meeting end by didn't ended quickly as previous
                    skipping that interval so we're not storing it's end time to compare with next interval.
                    as we assume we skipped in our assumption previous interval is still previous interval for coming intervals
                */

            }
            else{
                prevConsideredIntervalEnd = intervals[i][1];
            }
            i++;
        }
        return minOverlap;
    }
}