package DynamicProgramming;

import java.util.Arrays;

public class WildCardMatching {
    public boolean isMatch(String s, String p) {
        int[][] dp = initializeDP(s, p);
        return recurMemo( s.length(), p.length(), s, p, dp);
    }

    public int[][] initializeDP(String word1, String word2){
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for(int i=0; i<=word1.length(); i++){
            for(int j=0; j<=word2.length(); j++){
                dp[i][j] = -1;
            }
        }
        return dp;
    }

    public boolean recurMemo(int i1, int i2, String sequence, String pattern, int[][] dp) {
        if( i1==0 & i2==0){
            return true;
        }
        else if( i1!=0  & i2==0 ){
            return false;
        }

        if( dp[i1][i2]!=-1 ){
            return dp[i1][i2]==1;
        }


        if( i1==0 & i2!=0 & pattern.charAt(i2-1)=='*'){
            dp[i1][i2] = recurMemo( i1, i2-1, sequence, pattern, dp)==true ? 1 : 0;
            return dp[i1][i2]==1;
        }
        else if(i1==0 & i2!=0 & pattern.charAt(i2-1)!='*'){
            return false;
        }
        else if( pattern.charAt(i2-1)!='*' & pattern.charAt(i2-1)!='?' ){
            if( sequence.charAt(i1-1)==pattern.charAt(i2-1) ){
                dp[i1][i2] = recurMemo( i1-1, i2-1, sequence, pattern, dp)==true ? 1 : 0;
                return dp[i1][i2]==1;
            }
            else {
                return false;
            }
        }
        else if( pattern.charAt(i2-1)=='?' ){
            dp[i1][i2] = recurMemo(i1-1, i2-1, sequence, pattern, dp)==true ? 1 : 0;
            return dp[i1][i2]==1;
        }
        else {
            dp[i1][i2] = (recurMemo( i1, i2-1, sequence, pattern, dp )||
                    recurMemo( i1-1, i2, sequence, pattern, dp )||
                    recurMemo( i1-1, i2-1, sequence, pattern, dp )) ==true ? 1 : 0;
            return  dp[i1][i2]==1;
        }
    }

    private boolean recur(int i1, int i2, String sequence, String pattern) {
        if( i1==0 & i2==0){
            return true;
        }
        else if( i1!=0  & i2==0 ){
            return false;
        }


        if( i1==0 & i2!=0 & pattern.charAt(i2-1)=='*'){
            return recur( i1, i2-1, sequence, pattern);
        }
        else if(i1==0 & i2!=0 & pattern.charAt(i2-1)!='*'){
            return false;
        }
        else if( pattern.charAt(i2-1)!='*' & pattern.charAt(i2-1)!='?' ){
            if( sequence.charAt(i1-1)==pattern.charAt(i2-1) ){
                return recur( i1-1, i2-1, sequence, pattern);
            }
            else {
                return false;
            }
        }
        else if( pattern.charAt(i2-1)=='?' ){
            return recur(i1-1, i2-1, sequence, pattern);
        }
        else {
            return recur( i1, i2-1, sequence, pattern ) ||
                    recur( i1-1, i2, sequence, pattern ) ||
                    recur( i1-1, i2-1, sequence, pattern );
        }
    }
}
