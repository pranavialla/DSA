package DynamicProgramming;

import java.util.Arrays;

public class LongestCommonSubsequenceIn2Strings {
    public static int get(String text1, String text2){
        int[][] dp = new int[text1.length()][text2.length()];
        int l1 = text1.length();
        int l2 = text2.length();
        for(int i=0; i<l1; i++ ){
            for(int j=0; j<l2; j++){
                dp[i][j]=-1;
            }
        }
//        System.out.println("wdfw");
//        int[] dp = new int[text2.length()+1];
//        int l1 = text1.length();
//        int l2 = text2.length();
//
//        for(int j=0; j<l2; j++){
//            dp[j]=-1;
//        }
        //return memoSpaceOpt(l1-1, l2-1 , text1, text2, dp );
        return recurGet(l1-1, l2-1 , text1, text2, dp);
    }

    public static int recurGet(int i1, int i2, String text1, String text2, int[][] dp){
        if(i1<0 || i2<0){
            return  0 ;
        }

        if( dp[i1][i2]!=-1) return dp[i1][i2];

        int case1 = 0;
        int case2 = 0;
        int case3 = 0;

        if(text1.charAt(i1)==text2.charAt(i2)){
            case1 = 1 + recurGet(i1-1, i2-1, text1, text2, dp);
        }
        else{
            case2 = recurGet(i1-1, i2, text1, text2, dp);
            case3 = recurGet(i1, i2-1, text1, text2, dp);
        }

        dp[i1][i2] = Math.max(case1, Math.max(case2, case3));
        return dp[i1][i2];
    }

    public int longestCommonSubsequence(String text1, String text2){
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        int l1 = text1.length() ;
        int l2 = text2.length() ;
        return memo(l1, l2 , text1, text2, dp);
    }

    public static  int memo(int l1, int l2, String text1, String text2, int[][] dp){

        for(int i1=1; i1<=l1; i1++){
            for(int i2=1; i2<=l2; i2++){

                if(text1.charAt(i1-1)==text2.charAt(i2-1)){
                    dp[i1][i2] = 1 + dp[i1-1][i2-1];
                }
                else{
                    dp[i1][i2] = Math.max( dp[i1-1][ i2], dp[i1][ i2-1] );
                }

            }
        }
        //System.out.println(Arrays.deepToString(dp));
        return dp[l1][l2];
    }

    public int longestCommonSubsequenceOpt(String text1, String text2){
        int[] dp = new int[text2.length()+1];
        int l1 = text1.length() ;
        int l2 = text2.length() ;
        return memo(l1, l2 , text1, text2, dp);
    }

    public static  int memo(int l1, int l2, String text1, String text2, int[]dp){

        for(int i1=1; i1<=l1; i1++){
            int[] cur = new int[text2.length()+1];
            for(int i2=1; i2<=l2; i2++){
                int previous = cur[i2-1];
                if(text1.charAt(i1-1)==text2.charAt(i2-1)){
                    cur[i2] = 1 + dp[i2-1];
                }
                else{
                    cur[i2] = Math.max( dp[ i2], cur[ i2-1] );
                }

            }
            dp = cur;
        }

        int max =0;
        for(int i=0; i<=l2; i++){
            max = Math.max( dp[i], max);
        }
        System.out.println(Arrays.toString(dp));
        return max;
    }

}
