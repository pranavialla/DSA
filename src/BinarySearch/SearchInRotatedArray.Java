package BinarySearch;

class SearchInRotatedArray{
    public int search(int[] arr, int target) {
        int left =0;
        int right = arr.length-1;

        while(left<=right){
            int mid = left + (right-left)/2 ;
            
            //left half is sorted
            if(arr[mid] == target){
                return mid;
            } 
            else if(arr[left]<=arr[mid]){
                if(target<arr[mid] && target>=arr[left]){
                    right = mid-1;
                }
                else{
                    left = mid+1;
                }
            }
            else if(arr[mid]<=arr[right]){
                if(target>arr[mid] && target<=arr[right]){
                    left = mid+1;
                }
                else{
                    right = mid-1;
                }
            }
                
        }
        return -1;

        
    }


    int search2(int A[], int n, int target) {
        int lo=0,hi=n-1;
        // find the index of the smallest value using binary search.
        // Loop will terminate since mid < hi, and lo or hi will shrink by at least 1.
        // Proof by contradiction that mid < hi: if mid==hi, then lo==hi and loop would have been terminated.
        while(lo<hi){
            int mid=(lo+hi)/2;
            if(A[mid]>A[hi]) lo=mid+1;
            else hi=mid;
        }
        // lo==hi is the index of the smallest value and also the number of places rotated.
        int rot=lo;
        lo=0;hi=n-1;
        // The usual binary search and accounting for rotation.
        while(lo<=hi){
            int mid=(lo+hi)/2;
            int realmid=(mid+rot)%n;
            if(A[realmid]==target)return realmid;
            if(A[realmid]<target)lo=mid+1;
            else hi=mid-1;
        }
        return -1;
    }

    public boolean searchWithDuplicates(int[] arr, int target) {
        int left =0;
        int right = arr.length-1;

        while(left<=right){
            int mid = left + (right-left)/2 ;
            System.out.println("left : "+left + " right : "+right + " mid : "+mid);
            //left half is sorted
            if(arr[mid] == target){
                return true;
            } 
             if(arr[left]==arr[mid] && arr[mid]==arr[right]){
                left++;
                continue;
            }
             if(arr[left]<=arr[mid]){
                if(target<arr[mid] && target>=arr[left]){
                    right = mid-1;
                }
                else{
                    left = mid+1;
                }
            }
            else if(arr[mid]<=arr[right]){
                if(target>arr[mid] && target<=arr[right]){
                    left = mid+1;
                }
                else{
                    right = mid-1;
                }
            }
            
                
        }
        return false;
    }
}