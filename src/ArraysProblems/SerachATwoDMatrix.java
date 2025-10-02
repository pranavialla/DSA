


//https://leetcode.com/problems/search-a-2d-matrix/

public class SerachATwoDMatrix {
    public SerachATwoDMatrix(int[][] matrix, int target) {
        int lenghth = matrix.length*matrix[0].length;
        int left=0;
        int right= lenghth;
        Boolean isPresent=BinarySearch(matrix, left, right, target);
        System.out.println( isPresent);
    }


    boolean BinarySearch(int[][] matrix , int left, int right, int target){
        int mid=(left+right)/2;
        int cols=matrix[0].length;
        int rowIndex=mid/cols;
        int colIndex=mid%cols;
        /*//System.out.printf("left : %d, mid : %d, right: %d, rowIndex: %d, colIndex: %d",left, mid, right, rowIndex, colIndex);
        System.out.println();*/
        if (left<=right){
            if (matrix[rowIndex][colIndex]==target){
                //System.out.println(true);
                return true;

            }
            return BinarySearch(matrix, left, mid-1, target) || BinarySearch(matrix, mid+1, right, target);
        }
        return false;
    }
}
