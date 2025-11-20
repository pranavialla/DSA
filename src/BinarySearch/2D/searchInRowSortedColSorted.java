package BinarySearch.2D;

public class searchInRowSortedColSorted {
    public static boolean matSearch(int mat[][], int x) {
        // your code here
        int r = mat.length, c = mat[0].length-1;
        int leftBound  =  c, rowBound = r-1;
        for(int i=0; i<r; i++){
            leftBound = BS(mat[i], leftBound, x);
            if(leftBound==-1 ) return false;
            rowBound = BS(mat,i,  rowBound, x, leftBound);
            if( rowBound==-1) return false;
            if(mat[i][leftBound]==x) return true;
        }
        return false;
    }
    
    public static int BS(int[] arr, int r, int x){
        int l=0;
        while(l<=r){
            int m = l+(r-l)/2;
            if(arr[m]==x) return m;
            else if(arr[m]<x){
                l = m+1;
            }
            else{
                r = m-1;
            }
        }
        return r;
    }
    
     public static int BS(int[][] arr, int l, int r, int x, int colConstant){
        while(l<=r){
            int m = l+(r-l)/2;
            if(arr[m][colConstant]==x) return m;
            else if(arr[m][colConstant]<x){
                l = m+1;
            }
            else{
                r = m-1;
            }
        }
        return r;
    }
}
