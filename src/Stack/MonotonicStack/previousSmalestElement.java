package Stack.MonotonicStack;

import java.util.Stack;

public class previousSmalestElement {
    int[] get(int[] nums){

        //all elements in the stack should be decreasing order
        Stack<Integer> stack = new Stack<Integer>();
        int[] previousSmallestElementsIndex =  new int[nums.length];
    
        for(int i=0; i<nums.length; i++){
            if(!stack.isEmpty() && nums[stack.peek()]>=nums[i]){
                while(!(stack.isEmpty()) && nums[stack.peek()]>=nums[i]){
                    stack.pop();
                }
                if(stack.peek()==-1){
                    previousSmallestElementsIndex[i] = -1;
                }
                else{
                    previousSmallestElementsIndex[i] = stack.peek();
                }   
            }
            else{
                previousSmallestElementsIndex[i] = stack.peek();
            }
            stack.push(i);
        }
        return previousSmallestElementsIndex;
    }
}
