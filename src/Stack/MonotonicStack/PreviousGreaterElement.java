package Stack.MonotonicStack;

import java.util.Stack;

public class PreviousGreaterElement {
    int[] get(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] previousGreaterElementIndex = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    previousGreaterElementIndex[i] = -1;
                    
                } else {
                    previousGreaterElementIndex[i] = stack.peek();
                }
            }
            else {
                previousGreaterElementIndex[i] = stack.peek();    
            }
            stack.push(i);
        }
        return previousGreaterElementIndex;
    }
}
