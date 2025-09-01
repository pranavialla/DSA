import java.util.*;
class SmallestNumByRemovingKDigits {
    public String removeKdigits(String num, int k) {
        
        String[] nums = num.split("");
        Stack<Integer> stack = new Stack();
        
        int i=0;
        
        while(i<nums.length ){
            int cur=Integer.parseInt(nums[i]);
            if(!stack.isEmpty()&&  stack.peek()>cur){
                while(!stack.isEmpty()&&  stack.peek()>cur && k!=0){
                    int temp = stack.pop();
                    //System.out.println("-"+cur + " by "+ temp);
                    k--;
                }               
            }
            i++;
            stack.push(cur);
            //System.out.println(cur);
    }

    String res ="";

    //System.out.println("k : "+k + " empty : "+!stack.isEmpty());
    while(k!=0 && !stack.isEmpty()){
        stack.pop();
        k--;
    }

    while(!stack.isEmpty()){
        res = stack.pop() + res;
    }
    //System.out.println("--"+res);

    return res.replaceFirst("^0+", "").equals("") ? "0" : res.replaceFirst("^0+", "");
}
}