package BinarySearch;

public class SmallestInRotatesArray{
    public int getIndex(int[] arr){
        int left = 0;
        int right = arr.length-1;
        while(left<right){
            int mid = left +(left+right)/2;
            if(arr[mid]>arr[right]){
                left = mid+1;
            }
            else{
                right = mid;
            }
        }
        return left;
    }
}