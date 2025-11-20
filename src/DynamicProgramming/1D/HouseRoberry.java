package DynamicProgramming.OneDimentional;

import java.util.* ;
import java.io.*;

public class HouseRoberry {

    public static int tabulation(int[] nums){
        int n= nums.length;
        int[] memo = new int[nums.length+2]; 
        Arrays.fill(memo, -1);
        memo[0]=0;
        memo[1]=0;
        
        for(int curHouse=0; curHouse<n; curHouse++){
            int take = nums[curHouse] + memo[curHouse];
            int notTake = memo[curHouse+1];
        
            memo[curHouse+2]= Math.max(take, notTake);
        }
        
        return memo[n-1+2];
    }

    //recursion + memoization

    public int rob(int[] nums) {
        int[] memo = new int[nums.length+2]; 
        Arrays.fill(memo, -1);
        memo[0]=0;
        memo[1]=0;
        return robe(nums.length-1, nums, memo);
    }

    public int robe(int curHouse, int[] nums, int[] memo){
        if(memo[curHouse+2]!=-1) return memo[curHouse+2];
        int take = nums[curHouse] + robe(curHouse-2, nums, memo);
        int notTake = robe(curHouse-1, nums, memo);
    
        return Math.max(take, notTake);
    }

    public static long houseRobber(int[] valueInHouse) {
        if(valueInHouse.length==1){
            return valueInHouse[0];
        }
        // Write your code here.
        long prev1=0;
        long prev2=0;
        long cur = 0;
        for ( int i=0; i<valueInHouse.length-1; i++){
            cur = Math.max(prev2 + valueInHouse[i], prev1);
            prev2 = prev1;
            prev1 = cur ;
        }
        long withOutLast = cur;
        prev1=0;
        prev2=0;
        cur = 0;
        for ( int i=1; i<valueInHouse.length; i++){
            cur = Math.max(prev2 + valueInHouse[i], prev1);
            prev2 = prev1;
            prev1 = cur ;
        }
        return Math.max(cur, withOutLast);
    }

    public static void driver(){
        int[] valueInHouse = {2, 7, 9, 3, 1};
        System.out.println(recursive(valueInHouse, valueInHouse.length-1));
    }


    public static int recursive(int[] valueInHouse, int ind){
        if(ind==0) return valueInHouse[ind];
        if(ind<0) return 0;
        int pick=valueInHouse[ind]+ recursive(valueInHouse, ind-2);
        int notPick=recursive(valueInHouse, ind-1);
        return Math.max(pick,notPick);
    }




    public static int spaceOptimisedtabulation(int[] valueInHouse){
        int previous = 0;
        int previousPrevious = 0;
        int current = 0;

        for(int ind=0; ind<valueInHouse.length; ind++){
            if(ind==0) {
                previous= valueInHouse[ind];
                current = valueInHouse[ind];
                continue;
            }
            int pick=valueInHouse[ind]+ previousPrevious;
            int notPick=previous;
            current =  Math.max(pick,notPick);
            previousPrevious = previous;
            previous = current;
        }
        return current;
    }
}
