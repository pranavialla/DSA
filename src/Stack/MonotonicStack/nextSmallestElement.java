package Stack.MonotonicStack;

import java.util.Stack;

public class nextSmallestElement {
    int[] get(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] nextSmallestElementIndex = new int[nums.length];
        stack.push(nums.length);

        for (int i = nums.length - 1; i >= 0; i--) {
            if (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    nextSmallestElementIndex[i] = -1;
                    
                } else {
                    nextSmallestElementIndex[i] = stack.peek();
                }
            }
            else {
                nextSmallestElementIndex[i] = stack.peek();
            }
            stack.push(i);
        }

        return nextSmallestElementIndex;
    }
}
