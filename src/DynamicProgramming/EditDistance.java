package DynamicProgramming;

import java.util.Arrays;

public class EditDistance {

    public int minDistance(String word1, String word2) {
        int[][] dp = initialise( word1, word2);

        int[][] dpTabulation = initialiseForTabulation(word1, word2);

        int recursive =  recurMinDistance(word1.length(), word2.length(), word1, word2);

        int memoRecursive = recurMemomMinDistance(word1.length(), word2.length(), word1, word2, dp);

        int tabulation = tabulation( word1, word2, dpTabulation);

        return tabulation;
    }

    public int[][] initialise(String word1, String word2){
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for(int i=1; i<=word1.length(); i++){
            for(int j=1; j<=word2.length(); j++){
                dp[i][j] = -1;
            }
        }
        return dp;
    }

    private int recurMinDistance(int i1, int i2, String word1, String word2) {
            if( i1==0){
                return i2;
            }
            if( i2==0 ){
                return i1;
            }
            if( word1.charAt(i1-1)==word2.charAt(i2-1) ){
                return recurMinDistance( i1-1, i2-1, word1, word2);
            }
            else {
                int insert = 1 + recurMinDistance( i1, i2-1, word1, word2);
                int delete = 1 + recurMinDistance( i1-1, i2, word1, word2);
                int update = 1 + recurMinDistance( i1-1, i2-1, word1, word2);

                return Math.min( insert, Math.min( delete,update ));
            }
    }


    private int recurMemomMinDistance(int i1, int i2, String word1, String word2, int[][] dp) {

        if( i1==0){
            return i2;}

        if( i2==0 ){
            return i1;}

        if (dp[i1][i2] != -1){
            return dp[i1][i2];}

        if( word1.charAt(i1-1)==word2.charAt(i2-1) ){
            dp[i1][i2] = recurMemomMinDistance( i1-1, i2-1, word1, word2, dp);
            return dp[i1][i2];}

        else {
            int insert = 1 + recurMemomMinDistance( i1, i2-1, word1, word2, dp);
            int delete = 1 + recurMemomMinDistance( i1-1, i2, word1, word2, dp);
            int update = 1 + recurMemomMinDistance( i1-1, i2-1, word1, word2, dp);

            dp[i1][i2] = Math.min( insert, Math.min( delete,update ));
            return dp[i1][i2];}
    }

    public int[][] initialiseForTabulation(String word1, String word2){
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for(int i=1; i<=word1.length(); i++){
            for(int j=1; j<=word2.length(); j++){
                dp[i][j] = -1;
            }
        }

        //base case
        for(int i=0; i<=word1.length(); i++){
            dp[i][0] = i;
        }

        //basecase 2
        for(int j=0; j<=word2.length(); j++){
            dp[0][j] = j;
        }


        return dp;
    }

    private int tabulation( String word1, String word2, int[][] dp){
        for( int i1=1; i1<=word1.length(); i1++){
            for( int i2=1; i2<=word2.length(); i2++){

                if( word1.charAt(i1-1)==word2.charAt(i2-1)){
                    dp[i1][i2] = dp[i1-1][i2-1];
                }
                else{
                    dp[i1][i2] = 1 + Math.min( dp[i1][i2-1], Math.min( dp[i1-1][i2], dp[i1-1][i2-1]));
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }

}
