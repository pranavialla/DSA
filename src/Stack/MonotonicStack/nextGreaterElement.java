package Stack.MonotonicStack;

import java.util.Stack;

public class nextGreaterElement {
    int[] get(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] nextGreaterElementIndex = new int[nums.length];

        for (int i = nums.length - 1; i >= 0; i--) {
            if (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    nextGreaterElementIndex[i] = -1;
                    
                } else {
                    nextGreaterElementIndex[i] = stack.peek();
                }
            }
            else {
                nextGreaterElementIndex[i] = stack.peek();    
            }
            stack.push(i);
        }
        return nextGreaterElementIndex;
    }
}
