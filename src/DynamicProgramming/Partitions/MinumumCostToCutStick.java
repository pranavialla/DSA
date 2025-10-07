package DynamicProgramming.Partitions;

import java.util.Arrays;

public class MinumumCostToCutStick {
   
    int len;
    public int minCost(int n, int[] cuts) {
       Arrays.sort(cuts);
       this.len = n;
        return recur(cuts, 0, cuts.length-1);
                                   
    }

    public int recur(int[] cuts, int left, int right){
        if(left>right) return 0;
        
        int cost = Integer.MAX_VALUE;
        for(int i=left; i<=right; i++){
            int leftCost = recur(cuts, left, i-1);
            int rightCost = recur(cuts, i+1, right);
            int stickLeft = left==0 ? 0 : cuts[left-1];
            int stickRight = right==cuts.length-1 ? this.len : cuts[right+1];
            cost = Math.min(leftCost + rightCost + stickRight- stickLeft, cost);
        }
        return cost;
    }


    //memorization
     public int minCost1(int n, int[] cuts) {
       Arrays.sort(cuts);
       this.len = n;
        int[][] memo = new int[cuts.length][cuts.length];
        for(int[] edp : memo ) Arrays.fill(edp,  -1);
        return recur(cuts, 0, cuts.length-1, memo);
                                   
    }

    public int recur(int[] cuts, int left, int right, int[][] memo){
        if(left>right ) return 0;
        if(memo[left][right]!=-1) return memo[left][right];
        
        int cost = Integer.MAX_VALUE;
        for(int i=left; i<=right; i++){
            int leftCost = recur(cuts, left, i-1, memo);
            int rightCost = recur(cuts, i+1, right, memo);
            int stickLeft = left==0 ? 0 : cuts[left-1];
            int stickRight = right==cuts.length-1 ? this.len : cuts[right+1];
            cost = Math.min(leftCost + rightCost + stickRight- stickLeft, cost);
        }
        memo[left][right] = cost;
        return cost;
    }
    
}
