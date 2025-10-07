package DynamicProgramming.Partitions;

import java.util.Arrays;

class MatrixMultiplication {
    static int matrixMultiplication(int arr[]) {
        // code here
        if(arr.length<3) return 0;
        return recur(1, arr.length-1, arr);
    }
    
    static int recur(int start, int end, int[] arr){
        
        if(start==end || start>end) return 0;
        if(end-start==1) return arr[start-1]*arr[start]*arr[end];
        
        int cost = Integer.MAX_VALUE;
        for(int partition=start; partition<end; partition++){
            
            int l= recur(start, partition, arr);
            int r = recur(partition+1, end, arr);
            
            int cur = l+r +arr[start-1]*arr[partition]*arr[end];
            cost = Math.min(cur, cost);
        }
        return cost;
    }


    static int matrixMultiplication1(int arr[]) {
        // code here
        if(arr.length<3) return 0;
        int[][] memo = new int[arr.length][arr.length];
        for(int [] ememo : memo) Arrays.fill(ememo, -1);
        return recur(1, arr.length-1, arr, memo);
    }
    
    static int recur(int start, int end, int[] arr, int[][] memo){
        
        if(start==end || start>end) return 0;
        if(end-start==1) return arr[start-1]*arr[start]*arr[end];
        if(memo[start][end]!=-1) return memo[start][end];
        
        int cost = Integer.MAX_VALUE;
        for(int partition=start; partition<end; partition++){
            
            int l= recur(start, partition, arr, memo);
            int r = recur(partition+1, end, arr, memo);
            
            int cur = l+r +arr[start-1]*arr[partition]*arr[end];
            cost = Math.min(cur, cost);
        }
        memo[start][end]=cost;
        return cost;
        
    }

        static int matrixMultiplication(int arr[]) {
        // code here
        if(arr.length<3) return 0;
        int[][] memo = new int[arr.length][arr.length];
        for(int [] ememo : memo) Arrays.fill(ememo, -1);
        return recur( arr, memo);
    }
    
    static int recur( int[] arr, int[][] memo){
        
        for( int i = 1; i<arr.length; i++){
            for(int j=0; j<arr.length; j++){
                if (i==j) memo[i][j] = 0;
                if(j-i==1) memo[i][j] = arr[i-1]*arr[i]*arr[j];}}
        
        for( int start = arr.length-1; start>0; start--){
            for( int end = 0; end<arr.length; end++){
                if (start==end) continue;
                if(end-start==1) continue;
                
                int cost = Integer.MAX_VALUE;
                for(int partition=start; partition<end; partition++){
                    
                    int l= memo[start][partition];
                    int r = memo[partition+1][end];
                    
                    int cur = l+r +arr[start-1]*arr[partition]*arr[end];
                    cost = Math.min(cur, cost);
                }
                memo[start][end]=cost;
            }
        }
        return memo[1][arr.length-1];
    }
}