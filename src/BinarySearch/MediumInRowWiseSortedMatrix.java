package BinarySearch;

import java.util.Arrays;

public class MediumInRowWiseSortedMatrix {
    public void mediumInRowWiseSortedMatrix(int matrix[][], int R, int C) {
        int colLength=matrix[0].length;
        int[] IndexOfmaximumOfEachRow= eachRowMaximumIndex(R, colLength);
        int nthMaximumOfMatrix = (matrix.length * matrix[0].length)/2;
        int matrixMedium = 0;
        while (nthMaximumOfMatrix>=0){
            matrixMedium = getNthMaximum(IndexOfmaximumOfEachRow, matrix);
            nthMaximumOfMatrix -=1;
        }
        System.out.println(matrixMedium);

    }

    private int getNthMaximum(int[] IndexOfmaximumOfEachRow, int[][] matrix) {
        int maximumOfEachRowIndex = -1;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<IndexOfmaximumOfEachRow.length; i++){
            if(IndexOfmaximumOfEachRow[i]>=0){
                if( matrix[i][IndexOfmaximumOfEachRow[i]]>max){
                    maximumOfEachRowIndex = i;
                    max = matrix[i][IndexOfmaximumOfEachRow[i]];
                }
            }
        }
        IndexOfmaximumOfEachRow[maximumOfEachRowIndex] = IndexOfmaximumOfEachRow[maximumOfEachRowIndex]-1;
        return max;

    }

    private int[] eachRowMaximumIndex(int r, int colLength) {
        int[] maximumOfEachRowIndex = new int[r];
        Arrays.fill(maximumOfEachRowIndex, colLength-1);
        return maximumOfEachRowIndex;

    }


    //diff method

    static int upperBound(int[] arr, int x, int n) {
        int low = 0, high = n - 1;
        int ans = n;

        while (low <= high) {
            int mid = (low + high) / 2;
            // maybe an answer
            if (arr[mid] > x) {
                ans = mid;
                // look for a smaller index on the left
                high = mid - 1;
            } else {
                low = mid + 1; // look on the right
            }
        }
        return ans;
    }

    static int countSmallEqual(int[][] matrix, int m, int n, int x) {
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            cnt += upperBound(matrix[i], x, n);
        }
        return cnt;
    }

    static int median(int[][] matrix, int m, int n) {
        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;

        // point low and high to right elements
        for (int i = 0; i < m; i++) {
            low = Math.min(low, matrix[i][0]);
            high = Math.max(high, matrix[i][n - 1]);
        }

        int req = (n * m) / 2;
        while (low <= high) {
            int mid = (low + high) / 2;
            int smallEqual = countSmallEqual(matrix, m, n, mid);
            if (smallEqual <= req) low = mid + 1;
            else high = mid - 1;
        }
        return low;
    }
}
