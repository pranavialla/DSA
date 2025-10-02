package Stack.MonotonicStack;

import java.util.Stack;

class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        int[] PSE = new int[heights.length];
        int[] NSE = new int[heights.length];
        Stack<Integer> stack = new Stack();

        int i=0, n= heights.length;
        while(i<n){
            while( !stack.isEmpty() && heights[stack.peek()]>=heights[i]){
                stack.pop();
            }
            PSE[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
            i++;
        }

         i=heights.length-1;
          n= heights.length;
        stack = new Stack();
        while(i>=0){
            while( !stack.isEmpty() && heights[stack.peek()]>heights[i]){
                stack.pop();
            }
            NSE[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i--);
        }

        int histogram = 0;
        for(i=0; i<heights.length; i++){
            int width = NSE[i]-PSE[i]-1;
            histogram = Math.max(heights[i]*width, histogram);
        }

        return histogram;
    }


        public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;

        int rows = matrix.length, cols = matrix[0].length;
        int[] heights = new int[cols];
        int maxArea = 0;

        for (int i = 0; i < rows; i++) {
            // Build histogram for current row
            for (int j = 0; j < cols; j++) {
                heights[j] = matrix[i][j] == '0' ? 0 : heights[j] + 1;
            }

            // Compute largest rectangle in histogram
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }

        return maxArea;
    }

    private int largestRectangleArea1(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i <= n; i++) {
            int h = (i == n) ? 0 : heights[i];
            while (!stack.isEmpty() && h < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }

        return maxArea;
    }
}