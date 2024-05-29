package ArraysProblems;

import java.util.HashMap;
import java.util.Map;

public class LargestSubsequenceWithZeroSum {
    public int getLargestSubsequenceWithZeroSum(int[] arr, int n){
        Map<Integer, Integer> Hash= new HashMap<>();
        int prefixSum=0;
        int result=0;
        for(int i=0; i<n; i++){
            prefixSum+=arr[i];
            if(prefixSum==0){
                result=i+1;
            }
            else{
                if(Hash.containsKey(prefixSum)){
                    int l=Hash.get(prefixSum);
                    int r= i;

                    result=Math.max(r-l, result);
                }
                else{
                    Hash.put(prefixSum, i);
                }
            }
        }
        return result;
    }
}
