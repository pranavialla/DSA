package DynamicProgramming.SubsequenceSubarraySubset;

public class  coinChange{
    public int coinChange(int[] coins, int amount) {
        int minCoins = recur( coins.length-1,  amount, coins, amount+1);
        return minCoins==amount+1 ? -1 : minCoins;
    }

    public int recur(int i, int target, int[] coins, int maxCoins){
        if(target==0){
            return 0;
        }
        if(i<0) return maxCoins;

        int take =maxCoins;
        if(target-coins[i]>=0){
            take =  recur( i,  target-coins[i],  coins, maxCoins);
            if(take !=maxCoins){
                take +=1;
            }
        }
        int notTake= recur( i-1,  target,  coins, maxCoins);

        return Math.min(take, notTake);

    }
} {
    
}
