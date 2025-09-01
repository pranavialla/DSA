import java.util.Stack;

class PostToInfix {
    static String postToInfix(String exp) {
        Stack<String> stack = new Stack<>();

        for (char c : exp.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                // Operand → push directly
                stack.push(String.valueOf(c));
            } else {
                // Operator → pop two operands
                String b = stack.pop();
                String a = stack.pop();
                stack.push("(" + a + c + b + ")");
            }
        }

        return stack.pop();
    }
}
