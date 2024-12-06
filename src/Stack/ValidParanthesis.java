package Stack;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParanthesis{

    public boolean isValid(String s) {
        Map<Character, Character> paranthesisMap =  new HashMap<>();
        paranthesisMap.put('(', ')');
        paranthesisMap.put('[', ']');
        paranthesisMap.put('{', '}');

        Stack<Character> stack = new Stack<>();
        for(char character : s.toCharArray()){
            if(paranthesisMap.containsKey(character)){
                stack.push(paranthesisMap.get(character));
            }
            else if(!stack.isEmpty() && stack.peek()==character){
                stack.pop();
            }
            else{
                return false;
            }
        }

        return stack.size()==0;

    }
}