package DynamicProgramming.OneDimentional;

import java.util.* ;
import java.io.*;

public class HouseRoberry {
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

    public static int tabulation(int[] valueInHouse){
        int[] dp = new int[valueInHouse.length];

        for(int ind=0; ind<valueInHouse.length; ind++){
            if(ind==0) dp[0]= valueInHouse[ind];
            int pick=valueInHouse[ind]+ dp[ind-2];
            int notPick=dp[ind-1];
            dp[ind] =  Math.max(pick,notPick);
        }
        return dp[valueInHouse.length-1];
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
