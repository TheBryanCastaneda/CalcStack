// ConvertToPostfix.java

public class ConvertToPostfix {

    // Method to determine the precedence of operators
    private static int precedence(char operator) {
        switch(operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }

    // Method to convert infix expression to postfix
    public static String convertToPostfix(String infix) {
        LinkedStack<Character> stack = new LinkedStack<>();
        StringBuilder postfix = new StringBuilder();

        // Remove spaces from the infix expression
        infix = infix.replaceAll("\\s+", "");

        for(int i = 0; i < infix.length(); i++) {
            char token = infix.charAt(i);

            // If operand, add to postfix
            if(Character.isLetterOrDigit(token)) {
                postfix.append(token).append(' ');
            }
            // If '(', push to stack
            else if(token == '(') {
                stack.push(token);
            }
            // If ')', pop and append until '(' is found
            else if(token == ')') {
                while(!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop()).append(' ');
                }
                if(!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    throw new IllegalArgumentException("Mismatched parentheses");
                }
            }
            // If operator, handle precedence
            else {
                while(!stack.isEmpty() && precedence(stack.peek()) >= precedence(token)) {
                    postfix.append(stack.pop()).append(' ');
                }
                stack.push(token);
            }
        }

        // Pop any remaining operators from the stack
        while(!stack.isEmpty()) {
            char op = stack.pop();
            if(op == '(' || op == ')') {
                throw new IllegalArgumentException("Mismatched parentheses");
            }
            postfix.append(op).append(' ');
        }

        return postfix.toString().trim();
    }
}
