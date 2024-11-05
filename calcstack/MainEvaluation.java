// MainEvaluation.java
import java.util.HashMap;
import java.util.Map;

public class MainEvaluation {
    public static void main(String[] args) {
        // Postfix Expression from Task 1
        String postfixExpression = "a b * c a - / d e * +";
        System.out.println("Postfix Expression: " + postfixExpression);

        // Variable assignments
        Map<Character, Integer> variables = new HashMap<>();
        variables.put('a', 2);
        variables.put('b', 3);
        variables.put('c', 4);
        variables.put('d', 5);
        variables.put('e', 6);

        // Evaluate the postfix expression
        int result = EvaluatePostfix.evaluatePostfix(postfixExpression, variables);
        System.out.println("Evaluation Result: " + result);
    }
}
