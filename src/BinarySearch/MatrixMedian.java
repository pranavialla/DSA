package BinarySearch;

public class MatrixMedian {
    int median(int mat[][]) {
        // code here
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for( int i=0; i<mat.length; i++){
            if(mat[i][0]<min){
                min = mat[i][0];
            }
            if(mat[i][mat[0].length-1]>max){
                max = mat[i][mat[0].length-1];
            }
        }
        

        int desired = (mat[0].length*mat.length+1)/2 ;
        

        while (min<max) {
            int place = 0;
            int mid = min + (max-min)/ 2;
            for(int row=0; row<mat[0].length; row++){
                place = place + numsLessThanMid(mat[row], mid);
            }

            if(place >=desired){
                max = mid ;
            }
            else{
                min = mid+1;
            }
        }
   
        return max;
                    
    }
            
     int numsLessThanMid(int[] arr, int val) {
        if(val>=arr[arr.length-1]) return arr.length;
        int left = 0;
        int right = arr.length-1;
        while (left<right) {
            int mid= left+(right-left)/ 2 ;
            if(arr[mid]<=val){
                left = mid+1;
            }
            
            else{
                right = mid;
            }
            
        }
        return left;
    }
}
                
                    
