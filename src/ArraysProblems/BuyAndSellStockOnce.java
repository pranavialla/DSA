package ArraysProblems;

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
}
