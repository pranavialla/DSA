package BinarySearch;

public class BinarySearch {
    int search(int[] arr, int key){
        int length = arr.length;
        int left = 0;
        int right = length-1;
        while (left<=right) {
            /*
             * If (r - l) is even, the result is exact.
                If (r - l) is odd, the result is floored (i.e., rounded down).
             * 
            */
            int mid= left+Math.floorDiv(right-left, 2) ;
            if(arr[mid]==key){
                return mid;
            }
            else if(arr[mid]>key){
                right = mid-1;
            }
            else{
                left = mid+1;
            }
            
        }
        return -1;
    }


    int lowerBound(int[] arr, int target) {
        // code here
        int length = arr.length;
        int left = 0;
        int right = length-1;
        int result =-1;
        while (left<=right) {
            /*
             * If (r - l) is even, the result is exact.
                If (r - l) is odd, the result is floored (i.e., rounded down).
             * 
            */
            int mid= left+Math.floorDiv(right-left, 2) ;
            //System.out.println(mid+" -> "+arr[mid]);
            if(arr[mid]==target){
                result = mid;
                right= mid-1;
            }
            else if(arr[mid]>target){
                right = mid-1;
            }
            else{
                left = mid+1;
            }
            
        }
        return left==length? length-1 : left;
    }

        public int findFloor(int[] arr, int key) {
        // code here
        int length = arr.length;
        int left = 0;
        int right = length-1;
        int result = -1;
        while (left<=right) {
            /*
             * If (r - l) is even, the result is exact.
                If (r - l) is odd, the result is floored (i.e., rounded down).
             * 
            */
            int mid= left+Math.floorDiv(right-left, 2) ;
            if(arr[mid]==key){
                result =  mid;
                left = mid+1;
            }
            else if(arr[mid]>key){
                right = mid-1;
            }
            else{
                left = mid+1;
            }
            
        }
        return result!=-1 ? result : right;
    }
    

    public int[] searchRange(int[] arr, int key) {
        int[] result = new int[2];
        result[0] = findBound(arr, key, true);  // leftmost index
        result[1] = findBound(arr, key, false); // rightmost index
        return result;
    }

    private int findBound(int[] arr, int key, boolean searchLeft) {
        int left = 0, right = arr.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == key) {
                result = mid;
                if (searchLeft) {
                    right = mid - 1; // keep searching left
                } else {
                    left = mid + 1;  // keep searching right
                }
            } else if (arr[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }
}
