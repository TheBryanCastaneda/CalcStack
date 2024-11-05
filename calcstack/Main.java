// Main.java
public class Main {
    public static void main(String[] args) {
        String infixExpression = "a*b/(c-a)+d*e";
        System.out.println("Infix Expression: " + infixExpression);

        String postfixExpression = ConvertToPostfix.convertToPostfix(infixExpression);
        System.out.println("Postfix Expression: " + postfixExpression);
    }
}
