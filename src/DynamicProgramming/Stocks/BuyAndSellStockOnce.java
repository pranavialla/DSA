package DynamicProgramming.Stocks;


//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
public class BuyAndSellStockOnce {
    public BuyAndSellStockOnce(int[] prices){
        int maxProfit=0;
        //min value before it
        int bestPossibleBuyPrice=prices[0];
        int profitSellingHere=0;

        for(int i=1; i<prices.length; i++ ){
            profitSellingHere=prices[i]-bestPossibleBuyPrice;
            maxProfit=Math.max(profitSellingHere, maxProfit);
            bestPossibleBuyPrice=Math.min(bestPossibleBuyPrice, prices[i]);
        }

        System.out.println("max profit : "+ maxProfit);
    }

    public int buyAndSellStock(int[] prices){
        int minPriceSoFar  = prices[0];
        int profit =0;

        for (int i=0; i<prices.length; i++){
            int profiIfSoldToday = prices[i]-minPriceSoFar;
            profit = Math.max(profit, profiIfSoldToday);
            minPriceSoFar = Math.min( prices[i], minPriceSoFar);

        }

        return profit;
    }
}
