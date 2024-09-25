package DynamicProgramming.LIS;

import java.util.Arrays;
import java.util.Comparator;

public class RussionDol {
        public int maxEnvelopes(int[][] envelopes) {
            if(envelopes.length < 2) return envelopes.length;

            Arrays.sort(envelopes, new Comparator<>() {
                @Override
                public int compare(int[] e1, int[] e2) {
                    return e1[0] == e2[0] ? e2[1] - e1[1] : e1[0] - e2[0];
                }
            });
            int[] dp = new int[envelopes.length];
            int size = 0;

            for(int[] envelope: envelopes) {
                // binary search to get the least high number position in dp
                int left =getLowerBound( size, dp, envelope);
                // left is the right position to 'replace' in dp array
                dp[left] = envelope[1];
                if(left == size) size++;
            }
            return size;
        }

        int getLowerBound(int size, int[] dp, int[] envelope ){
            int left = 0, right = size, middle = 0;     // right = size
            while(left < right) {
                middle = left + (right - left) / 2;
                if(dp[middle] < envelope[1]) left = middle + 1;
                else right = middle;
            }
            return left;
        }

}
