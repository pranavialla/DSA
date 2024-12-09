package BinarySearch;

public class BinarySearch {
    int search(int[] arr, int key){
        int length = arr.length;
        int left = 0;
        int right = length-1;
        while (left<=right) {
            int mid= left+Math.floorDiv(right-left, 2) ;
            if(arr[mid]==key){
                return mid;
            }
            else if(arr[mid]<key){
                right = mid-1;
            }
            else{
                left = right+1;
            }
            
        }
        return -1;
    }
    
}
