

class EquilibriumPoint {

    // Function to find equilibrium point in the array.
    public static int equilibriumPoint(long arr[])
    {
        int n = arr.length;
        int left = 0, pivot = 0, right = 0;

        // Calculate the right sum
        for (int i = 1; i < n; i++) {
            right += arr[i];
        }

        // Iterate pivot over all the elements of the array
        // and until left != right
        while (pivot < n - 1 && right != left) {
            pivot++;
            right -= arr[pivot];
            left += arr[pivot - 1];
        }

        // If left == right, return pivot as the equilibrium
        // index
        return (left == right) ? pivot + 1 : -1;
    }

    public static void main(String[] args)
    {
        // Sample Input
        long[] arr = { 1, 7, 3, 6, 5, 6 };

        int result = equilibriumPoint(arr);
        System.out.println(result);
    }
}
