package DynamicProgramming.1D;

public class CircularRobery {
        public int rob(int[] nums) {
        int n= nums.length;
        int[] memo = new int[nums.length+2]; 

        if(nums.length==1) return nums[0];
        
        memo[0]=0;
        memo[1]=0;
        
        for(int curHouse=0; curHouse<n-1; curHouse++){
            int take = nums[curHouse] + memo[curHouse];
            int notTake = memo[curHouse+1];
        
            memo[curHouse+2]= Math.max(take, notTake);
        }
        
        int notConsideringLast =  memo[n-1+1];
        
        memo[2]=0;
        for(int curHouse=1; curHouse<n; curHouse++){
            int take = nums[curHouse] + memo[curHouse];
            int notTake = memo[curHouse+1];
        
            memo[curHouse+2]= Math.max(take, notTake);
        }
        int notConsideringFirst =  memo[n-1+2];

        return Math.max(notConsideringLast, notConsideringFirst);
    }
}
