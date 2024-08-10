package DynamicProgramming;

public class RodCutting {
    public static int cutRod(int price[], int n) {
        int[][] dp = new int[price.length][n+1];

        for(int curRodLength=1; curRodLength<=n; curRodLength++){
            if(curRodLength-price[0]>=0){
                dp[0][curRodLength] = dp[0][curRodLength-(0+1)] + price[0];
            }
        }

        for(int i=1; i<n; i++){
            for(int curLength=1; curLength<=n; curLength++){

                int take = 0;
                if(curLength-(i+1)>=0){
                    take = price[i] + dp[i][curLength-(i+1)];
                }

                int notTaking = dp[i-1][curLength];

                dp[i][curLength] = Math.max( take, notTaking );
            }
        }
        return dp[price.length-1][n];
    }
}
