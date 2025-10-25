package DynamicProgramming.SubsequenceSubarraySubset;

public class CoinchangeInfiniteCoins {
       int maxCoins ;
    public int coinChange(int[] coins, int tamount) {
        maxCoins = tamount+1;
        int totalCoins = coins.length;
         
        int[][] dp = new int[totalCoins+1][tamount+1];

        //if(i<0) return maxCoins;
        for(int amount= 0; amount<=tamount ; amount++) dp[0][amount] = maxCoins;

        //if(amount==0) return 0;
        for(int coini= 0; coini<=totalCoins ; coini++) dp[coini][0] = 0; 

        
        for(int i=0; i<totalCoins ; i++){
            for(int amount = 1; amount<=tamount; amount++){
                int take = maxCoins;
                if(amount-coins[i]>=0){
                    take =  dp[i+1][amount-coins[i]]+1;
                }
                int notTake= dp[i][amount];
                dp[i+1][amount] =  Math.min(take, notTake);
            }
        }

        //System.out.println(Arrays.deepToString(dp));
        return  dp[totalCoins][tamount]>=tamount+1 ? -1 : dp[totalCoins][tamount];
    }

    public int recur(int i, int amount, int[] coins, int[][] dp){
        if(dp[i+1][amount]!=-1) return dp[i+1][amount];

        int take =maxCoins;
        if(amount-coins[i]>=0){
            take =  recur(i,  amount-coins[i],  coins, dp) +1;
        }
        int notTake= recur( i-1,  amount,  coins, dp);
        dp[i+1][amount] =  Math.min(take, notTake);

        return dp[i+1][amount] ;
    }
}