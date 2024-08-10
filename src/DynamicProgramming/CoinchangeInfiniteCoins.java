package DynamicProgramming;

public class CoinchangeInfiniteCoins {
    public static  long getpossibleways(int denominations[], int value){
        int n = denominations.length;
        long[][] dp = new long[n][value+1];

        for(int i=0; i<n; i++){
            dp[i][0] = 1;
        }

        for(int i=0; i<=value; i++){
            if(i-denominations[0]>=0){
                dp[0][i] = dp[0][i-denominations[0]];
            }
        }

        for(int i=1; i<n; i++){
            for(int curValue=1; curValue<=value; curValue++){

                long take=0;
                if(curValue-denominations[i]>=0){
                    take = dp[i][curValue-denominations[i]];
                }

                long notTake = dp[i-1][curValue];

                dp[i][curValue] = take + notTake ;
            }
        }
        //System.out.print(Arrays.deepToString(dp));
        return dp[n-1][value];
    }
}
