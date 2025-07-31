import java.util.*;

public class mathExpression {

    // Determine if a character is a supported operator
    private static boolean isMathOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    // Assign precedence level to operators
    private static int getPrecedence(char op) {
        return switch (op) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            default -> -1;
        };
    }

    // Convert an infix expression to a postfix (RPN) expression
    private static String toPostfix(String infixExpr) {
        Stack<Character> operators = new Stack<>();
        StringBuilder result = new StringBuilder();

        for (char c : infixExpr.toCharArray()) {
            if (Character.isDigit(c)) {
                result.append(c).append(' ');
            } else if (isMathOperator(c)) {
                while (!operators.isEmpty() && getPrecedence(operators.peek()) >= getPrecedence(c)) {
                    result.append(operators.pop()).append(' ');
                }
                operators.push(c);
            }
        }

        while (!operators.isEmpty()) {
            result.append(operators.pop()).append(' ');
        }

        return result.toString();
    }

    // Evaluate a postfix expression and return the result
    private static int evaluatePostfix(String postfixExpr) {
        Stack<Integer> calcStack = new Stack<>();
        String[] elements = postfixExpr.trim().split("\\s+");

        for (String token : elements) {
            if (Character.isDigit(token.charAt(0))) {
                calcStack.push(Integer.parseInt(token));
            } else {
                int second = calcStack.pop();
                int first = calcStack.pop();
                switch (token) {
                    case "+" -> calcStack.push(first + second);
                    case "-" -> calcStack.push(first - second);
                    case "*" -> calcStack.push(first * second);
                    case "/" -> calcStack.push(first / second);
                }
            }
        }

        return calcStack.pop();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("=== Arithmetic Expression Evaluator ===");
        System.out.print("Input infix expression (e.g., 5+6*2): ");
        String expr = input.nextLine();

        String postfix = toPostfix(expr);
        System.out.println("Converted to Postfix: " + postfix);

        int finalResult = evaluatePostfix(postfix);
        System.out.println("Final Result: " + finalResult);

        input.close();
    }
}
