package DynamicProgramming;

public class PrintLonngestCommonSubsequence {
    public static  void goAhead( String text1, String text2){
        int[][] dp = initialising(text1, text2);
        dp = getLCSMatrix(text1, text2, dp);
        String LCS = getLCSString(text1, text2, dp);
        System.out.println(LCS);


    }

    private static String getLCSString(String text1, String text2, int[][] dp) {
        int i1 = text1.length();
        int i2 = text2.length();
        String LCS = "";
        while(i1!=0 && i2!=0){
            if(text1.charAt(i1-1)==text2.charAt(i2-1)){
                LCS = text1.charAt(i1-1) + LCS;
                i1--;
                i2--;
            }
            else if(dp[i1-1][i2]>dp[i1][i2-1]){
                i1--;
            }
            else{
                i2--;
            }
        }
        return LCS;
    }

    public static  int[][] getLCSMatrix(String text1, String text2, int[][] dp){
        int l1 = text1.length();
        int l2 = text2.length();
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
        return dp;
    }

    public static int[][] initialising(String text1, String text2){
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        int l1 = text1.length();
        int l2 = text2.length();
        for(int i=0; i<l1; i++ ){
            for(int j=0; j<l2; j++){
                dp[i][j]=0;
            }
        }
        return dp;
    }
}
