package Stack;

import java.util.Stack;

public class nextSmallestElement {
    int[] get(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] nextSmallestElementIndex = new int[nums.length];
        stack.push(nums.length);

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[stack.peek()] > nums[i]) {
                while (!(stack.peek() == nums.length) && nums[stack.peek()] > nums[i]) {
                    stack.pop();
                }
                if (stack.peek() == nums.length) {
                    nextSmallestElementIndex[i] = nums.length;
                    stack.push(i);
                } else {
                    nextSmallestElementIndex[i] = stack.peek();
                }
            }
            else {
                nextSmallestElementIndex[i] = stack.peek();
                stack.push(i);
            }
        }

        return nextSmallestElementIndex;
    }
}
