// EvaluatePostfixUsingArrayStack.java
import java.util.Map;

public class EvaluatePostfixUsingArrayStack {

    // Method to evaluate postfix expression using ResizeableArrayStack
    public static int evaluatePostfix(String postfix, Map<Character, Integer> variables) {
        ResizeableArrayStack<Integer> stack = new ResizeableArrayStack<>();

        // Split the postfix expression by space
        String[] tokens = postfix.split("\\s+");

        for(String token : tokens) {
            char ch = token.charAt(0);

            // If token is a number (multi-digit numbers are handled)
            if(Character.isDigit(ch)) {
                stack.push(Integer.parseInt(token));
            }
            // If token is a variable (letter)
            else if(Character.isLetter(ch)) {
                if(variables.containsKey(ch)) {
                    stack.push(variables.get(ch));
                } else {
                    throw new IllegalArgumentException("Undefined variable: " + ch);
                }
            }
            // If token is an operator
            else {
                // Ensure there are at least two operands on the stack
                if(stack.size() < 2) {
                    throw new IllegalArgumentException("Invalid postfix expression");
                }
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                int result;

                switch(ch) {
                    case '+':
                        result = operand1 + operand2;
                        break;
                    case '-':
                        result = operand1 - operand2;
                        break;
                    case '*':
                        result = operand1 * operand2;
                        break;
                    case '/':
                        if(operand2 == 0) {
                            throw new ArithmeticException("Division by zero");
                        }
                        result = operand1 / operand2;
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid operator: " + ch);
                }

                stack.push(result);
            }
        }

        if(stack.size() != 1) {
            throw new IllegalArgumentException("Invalid postfix expression");
        }

        return stack.pop();
    }
}
