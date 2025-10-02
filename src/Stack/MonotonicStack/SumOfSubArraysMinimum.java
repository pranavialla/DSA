package Stack.MonotonicStack;

import java.util.Stack;

class SumOfSubArraysMinimum {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int mod = (int)1e9 + 7;
        Stack<Integer> stack = new Stack<>();
        int[] prev = new int[n];
        int[] next = new int[n];

        // Previous Smaller Element
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            prev[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();

        // Next Smaller Element
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            next[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        long res = 0;
        for (int i = 0; i < n; i++) {
            long count = (i - prev[i]) * (next[i] - i);
            res = (res + arr[i] * count) % mod;
        }

        return (int) res;
    }
}
