package Stack.MonotonicStack;

import java.util.Stack;

class RangeSum {
    public long subArrayRanges(int[] nums) {
        int[] PSE = new int[nums.length];
        int[] NSE = new int[nums.length];
        int[] PGE = new int[nums.length];
        int[] NGE = new int[nums.length];
        
        int i=0;
        Stack<Integer> stack = new Stack();
        while(i<nums.length){
            if(!stack.isEmpty()&&  nums[ stack.peek()]>=nums[i]){
                while(!stack.isEmpty()&&  nums[ stack.peek()]>=nums[i]){
                    stack.pop();
                }
                
            }
            PSE[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i++);
            
        }

        i=nums.length-1;
        stack = new Stack();
        while(i>=0){
            if(!stack.isEmpty()&& nums[ stack.peek()]>nums[i]){
                while(!stack.isEmpty()&&nums[ stack.peek()]>nums[i]){
                    stack.pop();
                }
                
            }
            NSE[i] = stack.isEmpty() ? nums.length : stack.peek();
            stack.push(i--);
            
        }

         i=0;
        stack = new Stack();
        while(i<nums.length){
            if(!stack.isEmpty()&&nums[ stack.peek()]<=nums[i]){
                while(!stack.isEmpty()&&nums[ stack.peek()]<=nums[i]){
                    stack.pop();
                }
                
            }
            PGE[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i++);    
        }

         i=nums.length-1;
        stack = new Stack();
        while(i>=0){
            if(!stack.isEmpty()&&nums[ stack.peek()]<nums[i]){
                while(!stack.isEmpty()&&nums[ stack.peek()]<nums[i]){
                    stack.pop();
                }  
            }
            NGE[i] = stack.isEmpty() ? nums.length : stack.peek();
            stack.push(i--);
            
        }

        long sum = 0;
        for (int j = 0; j < nums.length; j++) {
            long maxCount = (long)(j - PGE[j]) * (NGE[j] - j);
            long minCount = (long)(j - PSE[j]) * (NSE[j] - j);
            sum += (maxCount - minCount) * nums[j];
        }

        return sum;
    }
}