package DynamicProgramming.LIS;

import java.util.Arrays;
import java.util.List;

class largestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        //if we don't sort and get smaller multiple after large then we assume that larget number is divisible by next large [90, 9, 99]
        Arrays.sort(nums);
        int[] prevLink = new int[nums.length];
        int[] LISTillIndex = new int[nums.length];
        Arrays.fill(LISTillIndex, 1);
         int maxIndex = -1;
        for(int i=0; i<nums.length; i++) prevLink[i] = i;
        

        for(int i =0 ; i<nums.length; i++){
            LISTillIndex[i]=1;
            for(int prev = 0; prev<i; prev++){
                //if(prev==i) continue;
                if((nums[prev] % nums[i]==0 || nums[i] % nums[prev]==0) && LISTillIndex[prev]+1 >LISTillIndex[i]){
                    LISTillIndex[i]=LISTillIndex[prev]+1;
                    prevLink[i]=prev;
                }
            }
            if( maxIndex==-1 || LISTillIndex[i]>LISTillIndex[maxIndex]) maxIndex=i;

        }
        
        
        ArrayList<Integer> LIS =new ArrayList<Integer>();
        LIS.add(nums[maxIndex]);
        while(prevLink[maxIndex]!=maxIndex){
            LIS.add(nums[prevLink[maxIndex]]);
            maxIndex = prevLink[maxIndex];
        }
        
        return LIS;
    }
}