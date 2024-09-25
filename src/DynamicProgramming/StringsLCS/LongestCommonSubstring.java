package DynamicProgramming.StringsLCS;

public class LongestCommonSubstring {
    public static int longestCommonSubstring(String s1, String s2){
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        int maxLength = 0;
        for(int i=1; i<=s1.length(); i++){
            for(int j=1; j<=s2.length(); j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    maxLength = Math.max(maxLength, dp[i][j]);
                }
            }
        }
        return maxLength;
    }

    static int LCSubStr(char str1[], char str2[], int N, int M){
        int LCStuff[][] = new int[N + 1][M + 1];

        int mx = 0;

        for (int i = 0; i <= N; i++)
        {
            for (int j = 0; j <= M; j++)
            {
                if (i == 0 || j == 0)
                    LCStuff[i][j] = 0;
                else if (str1[i - 1] == str2[j - 1])
                {
                    LCStuff[i][j]
                            = LCStuff[i - 1][j - 1] + 1;
                    mx = Integer.max(mx,
                            LCStuff[i][j]);
                }
                else
                    LCStuff[i][j] = 0;
            }
        }
        return mx;
    }


}
