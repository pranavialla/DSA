
​import java.util.Arrays;
class ShiftArrayToLeftByD {
    
    // Function to rotate array
    static void rotateArr0(int[] arr, int d) {
        int n = arr.length;
        // Handle case when d > n
        d %= n;
        
        // Storing rotated version of array
        int[] temp = new int[n];
        // Copy last n - d elements to the front of temp
        for (int i = 0; i < n - d; i++)
            temp[i] = arr[d + i];
        // Copy the first d elements to the back of temp
        for (int i = 0; i < d; i++)
            temp[n - d + i] = arr[i];
        // Copying the elements of temp in arr
        // to get the final rotated array
        for (int i = 0; i < n; i++)
            arr[i] = temp[i];
    }
    

         // Function to rotate an array by d elements to the left
    static void rotateArr(int[] arr, int d) {
        int n = arr.length;

        // Handle the case where d > size of array
        d %= n;

        // Reverse the first d elements
        reverse(arr, 0, d - 1);

        // Reverse the remaining n-d elements
        reverse(arr, d, n - 1);

        // Reverse the entire array
        reverse(arr, 0, n - 1);
    }

    // Function to reverse a portion of the array
    static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    
    public  void shift(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6 };
        int d = 2;
        rotateArr(arr, d);
        // Print the rotated array
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }


}
