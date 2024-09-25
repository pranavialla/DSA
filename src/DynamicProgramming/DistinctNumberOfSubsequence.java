package DynamicProgramming;

import java.util.Arrays;

public class DistinctNumberOfSubsequence {
    public static int distinctSubsequences(String s, String t) {
        int[] dp = new int[s.length()+1];
        Arrays.fill(dp, 1);

        for( int i1=1; i1<=t.length(); i1++){
            int[] cur = new int[s.length()+1];
            for(int i2=1; i2<=s.length(); i2++){
                if( t.charAt(i1-1)==s.charAt(i2-1)){
                    cur[i2] = cur[i2-1] + dp[i2-1];
                }
                else {
                    cur[i2] = cur[i2-1];
                }
            }
            dp = cur;
        }
        return dp[s.length()];
    }
}