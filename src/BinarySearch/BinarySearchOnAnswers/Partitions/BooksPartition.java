package BinarySearch.BinarySearchOnAnswers.Partitions;

import java.util.Arrays;

public class BooksPartition {
    public boolean canWePartitionToKPartsOfMidSum(int[] arr, int partitions, int maxPages) {
        int curPages =0;
        for(int ele : arr){
            curPages+=ele;
            if(curPages>=maxPages){
                partitions-=1;
                if(curPages==maxPages) curPages =0;
                else if (curPages>maxPages) curPages =ele ;
            }
            if (partitions<0) return false;
        }
        return curPages!=0 ? partitions-1>=0 : partitions>=0 ;
    }
    
    
    public int findPages(int[] arr, int k) {
        // code here
        
        if (arr.length<k) return -1;
        int left = Arrays.stream(arr).max().getAsInt();
        int right = Arrays.stream(arr).sum();
        
        int ans = -1;
        
        while(left<=right){
            int mid = left +(right-left)/2;
            
            boolean isTrue = canWePartitionToKPartsOfMidSum(arr, k, mid);
            if(isTrue){
                ans = mid;
                right  = mid -1;}
            else{
                left  = mid+1;}
        }
        return ans;
    }

}
