package BinarySearch;

public class FindMin {
        public int findMin(int[] arr) {
        int left =0, right = arr.length-1;

        while(left<right){
            int mid = left + (right-left)/2;
            //all about considering 1 part and discarding other part. need to identify which part to consider and logic neededto identify

            //not sorted part

            if(arr[mid]>arr[right]){
                left=mid+1;
            }
            else if(arr[left]>arr[mid]){
                right = mid;
            }
             
        }
        return arr[left];
    }
}
