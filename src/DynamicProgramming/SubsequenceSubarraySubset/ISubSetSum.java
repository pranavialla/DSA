package DynamicProgramming.SubsequenceSubarraySubset;

class IsSubsetSum {


 static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        
        int n = arr.length;
        
        //observe we are doing coordinate shift for only i not sum. sum is
        //we added as required as sum can be 0 to sum as per our logic
        int[][] memo = new int[n+1][sum+1];
        for(int cursum=0; cursum<=sum; cursum++) memo[0][cursum] = -1 ;
        for(int i=0; i<=n; i++) memo[i][0] = 1 ;
        
        for(int i=0 ; i<n; i++){
            for(int curSum=0; curSum<=sum; curSum++ ){
                int take = -1;
                if(curSum-arr[i]>=0){
                    take =memo[i][curSum-arr[i]];
                }
                int notTake =memo[i][curSum];
                
                memo[i+1][curSum] = take==-1 &&  notTake==-1 ? -1 : 1;
            }
        }
        return memo[n][sum]==1;
    }
    
    static int recur(int i, int sum, int[] arr, int[][] memo){
        if(memo[i+1][sum]!=0) return memo[i+1][sum] ;
        
        int take = -1;
        if(sum-arr[i]>=0){
            take =recur(i-1, sum-arr[i], arr, memo);
        }
        int notTake =recur(i-1, sum, arr, memo);
        
        memo[i+1][sum] = take==-1 &&  notTake==-1 ? -1 : 1;
        
        return memo[i+1][sum];
    }

    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        
        int n = arr.length;
        
        //observe we are doing coordinate shift for only i not sum. sum is
        //we added as required as sum can be 0 to sum as per our logic
        int[][] memo = new int[n+1][sum+1];
        for(int cursum=0; cursum<=sum; cursum++) memo[0][cursum] = -1 ;
        for(int i=0; i<=n; i++) memo[i][0] = 1 ;
        return recur(n-1, sum, arr, memo)==1;
    }
    
    static int recur(int i, int sum, int[] arr, int[][] memo){
        if(memo[i+1][sum]!=0) return memo[i+1][sum] ;
        
        int take = -1;
        if(sum-arr[i]>=0){
            take =recur(i-1, sum-arr[i], arr, memo);
        }
        int notTake =recur(i-1, sum, arr, memo);
        
        memo[i+1][sum] = take==-1 &&  notTake==-1 ? -1 : 1;
        
        return memo[i+1][sum];
    }

    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        
        int n = arr.length;
        return recur(n-1, sum, arr)==1;
    }
    
    static int recur(int i, int sum, int[] arr){
        if(sum==0) return 1;
        if(i<0) return -1;
        
        int take = -1;
        if(sum-arr[i]>=0){
            take =recur(i-1, sum-arr[i], arr);
        }
        int notTake =recur(i-1, sum, arr);
        
        return take==-1 &&  notTake==-1 ? -1 : 1;
    }











    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        int[][] dp = new int[arr.length][sum+1];
        
        return recur(arr.length-1, sum, arr, dp)>0;
    }
    
    static int recur(int i, int sum, int[] arr, int[][] dp){
        
        if(sum==0){
            return 1;
        }
        
        if(sum<0){
            return -1;
        }
        if(i<0) return -1;
        
        if(dp[i][sum]!=0) return dp[i][sum];
        
        int take = recur( i-1, sum-arr[i], arr, dp);
        int notTake = recur( i-1, sum,  arr, dp) ;
        
        dp[i][sum] =  take==1 || notTake==1 ? 1 : -1;
        return dp[i][sum];
    }

         static Boolean isSubsetSum1(int arr[], int sum) {
        // code here
        boolean[][] dp = new boolean[arr.length+1][sum+1];
        
        int n= arr.length;
        
        for(int i=0; i<=n; i++){
            dp[i][0] = true;
        }
        
        for(int i=1; i<=n; i++){
            for(int cursum=1; cursum<=sum; cursum++){
                if(cursum-arr[i-1]<0) {
                    
                    dp[i][cursum] = dp[i-1][cursum];
                    continue;
                }

                boolean take = dp[i-1][cursum-arr[i-1]] ;
                boolean notTake = dp[i-1][cursum] ;
                
                dp[i][cursum] =  take || notTake? true: false;
            }
        }
        
        return dp[n][sum];
    }

        static Boolean isSubsetSum3(int arr[], int sum) {
        // code here
        boolean[] dp = new boolean[sum+1];
        
        int n= arr.length;
        dp[0] = true;
       
        
        for(int i=1; i<=n; i++){
            boolean[] temp= new boolean[sum+1];
            temp[0]=true;
            for(int cursum=1; cursum<=sum; cursum++){
                if(cursum-arr[i-1]<0) {
                    temp[cursum]  = dp[cursum] ;
                    continue;
                }

                boolean take = dp[cursum-arr[i-1]] ;
                boolean notTake = dp[cursum] ;
                
                temp[cursum] =  take || notTake ? true: false;
            }
            dp = temp;
        }
        
        return dp[sum];
    }
    
    
}