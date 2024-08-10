package DynamicProgramming;

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
}
