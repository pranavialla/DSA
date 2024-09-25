package GreedyAlgo;

import java.util.Arrays;


//maximum overlapping subintervals

//. The total platforms needed at one time can be found by taking the difference of arrivals and departures at that time
// and the maximum value of all times will be the final answer.
/*Intuition: At first we need to sort both arrays. When the events will be sorted, it will be easy to track the count of
trains that have arrived but not departed yet. The total platforms needed at one time can be found by taking the difference
 between arrivals and departures at that time and the maximum value of all times will be the final answer.

Approach:  At first we need to sort both arrays. When the events will be sorted, it will be easy to track the count of
trains that have arrived but not departed yet. The total platforms needed at one time can be found by taking the difference
of arrivals and departures at that time and the maximum value of all times will be the final answer. If(arr[i]<=dep[j]) means
  if arrival time is less than or equal to the departure time then- we need one more platform. So increment count as well as increment i.
   If(arr[i]>dep[j]) means the arrival time is more than the departure time then- we have one extra platform which we can reduce.
    So decrement count but increment j. Update the ans with max(ans, count) after each iteration of the while loop.

*/
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


    public int MinimumPlajtforms(int[] arr, int[] dep, int n){
        Arrays.sort(arr);
        Arrays.sort(dep);

        int plat_needed = 1, result = 1;
        int i = 1, j = 0;

        while (i < n && j < n) {

            if (arr[i] <= dep[j]) {
                plat_needed++;
                i++;
            }

            else if (arr[i] > dep[j]) {
                plat_needed--;
                j++;
            }

            if (plat_needed > result)
                result = plat_needed;
        }

        return result;
    }
}
