package BinarySearch.BinarySearchOnAnswers;

import java.util.Arrays;

class AggressiveCow {
    
    public boolean canBePlacedWithThisDistance(int[] stalls, int k, int distance) {
        int preStall = stalls[0];
        k-=1;
        for(int i=1; i<stalls.length; i++){
            if(stalls[i]-preStall >= distance){
                preStall = stalls[i];
                k-=1;
                if(k==0) return true;
            }
            
        }
        return false;
    }
    
    public int aggressiveCows(int[] stalls, int k) {
        // code here
        Arrays.sort(stalls);
        int left = Integer.MAX_VALUE;
        for(int i=1; i<stalls.length; i++ ){
            left = Math.min( left, stalls[i]-stalls[i-1]);
        }
        
        int right = stalls[stalls.length-1] - stalls[0];
        int ans = -1;
        
        while(left<=right){
            int mid = left +(right-left)/2;
            boolean canBePlacedWithThisDistance = canBePlacedWithThisDistance(stalls, k, mid);
            if(canBePlacedWithThisDistance){
                ans = mid;
                left  = mid+1;
                }
            else{
                right  = mid -1;}}
        return ans;
    }
}