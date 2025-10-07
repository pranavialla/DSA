package DynamicProgramming.LIS;

import java.util.ArrayList;
import java.util.Arrays;

public // User function Template for Java

class PrintLIS {
    public ArrayList<Integer> getLIS(int arr[]) {
        int[] prevLink = new int[arr.length];
        int[] LISTillIndex = new int[arr.length];
        Arrays.fill(LISTillIndex, 1);
        for(int i=0; i<arr.length; i++) prevLink[i] = i;
        
        for(int i =0 ; i<arr.length; i++){
            for(int prev = 0; prev<i; prev++){
                if(arr[prev] < arr[i] && LISTillIndex[prev]+1 >LISTillIndex[i]){
                    LISTillIndex[i]+=1;
                    prevLink[i]=prev;
                }
            }
        }
        
        int maxIndex = -1;
        for(int i = 0; i<LISTillIndex.length; i++){
            if(maxIndex==-1 || LISTillIndex[maxIndex]<LISTillIndex[i]){
                maxIndex =i;
            }
        }
        
        ArrayList<Integer> LIS =new ArrayList<Integer>();
        LIS.add(arr[maxIndex]);
        while(prevLink[maxIndex]!=maxIndex){
            LIS.add(0, arr[prevLink[maxIndex]]);
            maxIndex = prevLink[maxIndex];
        }
        
        return LIS;
    }

}
