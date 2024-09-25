package Stack;

import java.util.Stack;

public class previousSmalestElement {
    int[] get(int[] nums){

        //all elements in the stack should be decreasing order
        Stack<Integer> stack = new Stack<Integer>();
        int[] previousSmallestElementsIndex =  new int[nums.length];
        stack.push(-1);
        for(int i=0; i<nums.length; i++){
            if(nums[stack.peek()]<=nums[i]){
                previousSmallestElementsIndex[i] = stack.peek();
                while(!(stack.peek()==-1) && nums[stack.peek()]<nums[i]){
                    stack.pop();
                }
                if(stack.peek()==-1){
                    previousSmallestElementsIndex[i] = -1;
                }
                else{
                    previousSmallestElementsIndex[i] = stack.peek();
                }
                stack.push(i);
            }
            else{
                stack.push(i);
            }
        }
        return previousSmallestElementsIndex;
    }
}
