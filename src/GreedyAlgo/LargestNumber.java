package GreedyAlgo;

import java.util.ArrayList;
import java.util.Collections;

//leetcode.com/problems/largest-number/
public class LargestNumber {
    public String largestNumber(int[] nums)
    {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++)
            list.add(Integer.toString(nums[i]));
        Collections.sort(list,(a, b) -> (int)(Long.parseLong(b+a) - Long.parseLong(a+b)) );
        //Collections.sort(list,(a, b) -> (b + a).compareTo(a + b)) ;
        StringBuilder sb = new StringBuilder();
        for(String x:list) {
            sb.append(x);
        }
        //remove leading 0
        return sb.toString();
    }
}
