package DynamicProgramming;

public class Knapsack01 {

    public static int getMaxValue(int[] weight, int[] value, int n, int maxWeight) {
        int[][] dp = new int[n][maxWeight+1];
        for(int i=0; i<n; i++){
            dp[i][0] = 0;
        }

        for(int i=0; i<maxWeight+1; i++){
            if(i - weight[0] >=0){
                dp[0][i] = value[0];
            }
        }


        for(int i=1; i<n; i++){
            for(int w=1; w<=maxWeight; w++){
                int notTake = dp[i-1][w];
                int take = 0;

                if(w-weight[i]>=0){
                    take = value[i]+ dp[i-1][w-weight[i]];
                }

                dp[i][w] = Integer.max( take, notTake);
            }
        }
        //System.out.println(Arrays.deepToString(dp));
        return dp[n-1][maxWeight];
    }

    public static int getMaxValue2(int[] weight, int[] value, int n, int maxWeight)  {
        int[] dp = new int[maxWeight+1];

        for(int i=0; i<n; i++){
            int[] cur= new int[maxWeight+1];
            for(int w=1; w<=maxWeight; w++){
                int notTake = dp[w];
                int take = 0;

                if(w-weight[i]>=0){
                    take = value[i]+ dp[w-weight[i]];
                }

                cur[w] = Integer.max( take, notTake);
            }
            dp=cur;
        }
        //System.out.println(Arrays.deepToString(dp));
        return dp[maxWeight];
    }
}