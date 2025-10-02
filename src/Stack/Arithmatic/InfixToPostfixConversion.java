import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {
    public static String infixToPostfix(String s) {
        // code here
        Stack<Character> stack = new Stack();
        String result ="";
        Map<Character, Integer> getPrecedence = new HashMap<>();
        getPrecedence.put('*', 2);
        getPrecedence.put('/', 2);
        getPrecedence.put('^', 3);
        getPrecedence.put('+', 1);
        getPrecedence.put('-', 1);
        getPrecedence.put('(', 0);
        
        for(Character c : s.toCharArray()){
            if((c >= 'A' && c <= 'Z') ||
                (c >= 'a' && c <= 'z') ||
                (c >= '0' && c <= '9')) {
                result += c;
            }
            else if(c==')'){
                while(!stack.isEmpty() && stack.peek()!=(Character) '('){
                    result+=stack.pop();
                }
                if(!stack.isEmpty() && stack.peek()==(Character) '('){
                    stack.pop();
                }
            }else if (c==(Character) '(' || stack.isEmpty() || stack.peek()=='('){
                 stack.push(c);
            }
            else if(!stack.isEmpty() &&getPrecedence.get(c)>getPrecedence.get(stack.peek())){
                stack.push(c);
            }
            else if( !stack.isEmpty() && getPrecedence.get(c)<=getPrecedence.get(stack.peek())){
                while(!stack.isEmpty() && getPrecedence.get(c)<=getPrecedence.get(stack.peek())){
                    result+=stack.pop() ;
                }
                stack.push(c);
            }
            
            //System.out.println(result+ " "+stack.size());
        }
        
        while(!stack.isEmpty() ){
                    result+=stack.pop();
        }
                
        return result ;
    }


    //elegent version
    public static String infixToPostfix2(String expression) {
        Deque<Character> stack = new ArrayDeque<>();
        StringBuilder result = new StringBuilder();

        Map<Character, Integer> precedence = Map.of(
            '^', 3,
            '*', 2, '/', 2,
            '+', 1, '-', 1,
            '(', 0
        );

        for (char c : expression.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                // Operand → append directly
                result.append(c);
            } 
            else if (c == '(') {
                stack.push(c);
            } 
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                stack.pop(); // Remove '('
            } 
            else { // Operator
                while (!stack.isEmpty() && precedence.get(c) <= precedence.get(stack.peek())) {
                    result.append(stack.pop());
                }
                stack.push(c);
            }
        }

        // Pop remaining operators
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }

}

// if we want to convert to prefix then reverse the string in the begging
//check bracket placement ( to ) ) to (
// convert the infix to postfix
//reverse the postfix output