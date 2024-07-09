package GreedyAlgo;

import java.util.Arrays;

public class MinimumPlatforms {
    public MinimumPlatforms(int arr[], int dep[], int n){
        Arrays.sort(arr);
        Arrays.sort(dep);
        int ai=0;
        int di=0;
        int platformsNeeded=0;
        while (ai<n){
            if(arr[ai]<=dep[di]){
                platformsNeeded+=1;
                ai+=1;
            }
            else {
                ai+=1;
                di+=1;
            }
        }
        System.out.println(platformsNeeded);
    }
}
