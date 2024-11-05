// EvaluatePostfix.java
import java.util.Map;

public class EvaluatePostfix {

    // Method to evaluate postfix expression
    public static int evaluatePostfix(String postfix, Map<Character, Integer> variables) {
        LinkedStack<Integer> stack = new LinkedStack<>();

        // Split the postfix expression by space
        String[] tokens = postfix.split("\\s+");

        for(String token : tokens) {
            char ch = token.charAt(0);

            // If operand, push its value onto the stack
            if(Character.isDigit(ch)) {
                stack.push(Integer.parseInt(token));
            }
            else if(Character.isLetter(ch)) {
                if(variables.containsKey(ch)) {
                    stack.push(variables.get(ch));
                } else {
                    throw new IllegalArgumentException("Undefined variable: " + ch);
                }
            }
            // If operator, pop two operands and apply the operator
            else {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                int result = 0;

                switch(ch) {
                    case '+': result = operand1 + operand2; break;
                    case '-': result = operand1 - operand2; break;
                    case '*': result = operand1 * operand2; break;
                    case '/': 
                        if(operand2 == 0) throw new ArithmeticException("Division by zero");
                        result = operand1 / operand2; 
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid operator: " + ch);
                }
                stack.push(result);
            }
        }

        if(stack.isEmpty()) {
            throw new IllegalArgumentException("Invalid postfix expression");
        }

        return stack.pop();
    }
}
