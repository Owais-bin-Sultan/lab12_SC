import java.util.Stack;

/**
 * The RecursiveParser class evaluates arithmetic expressions represented as strings.
 * It supports basic arithmetic operations (addition, subtraction, multiplication, division)
 * as well as parentheses for grouping sub-expressions.
 * 
 * Specifications:
 * 
 * - The `evaluateExpression` method is the main entry point for evaluating an expression. 
 *   It validates the input expression and invokes the recursive `evaluate` method.
 * 
 * - The `evaluate` method recursively processes the expression character by character, 
 *   handling numbers, operators, and parentheses. It uses two stacks: one for values 
 *   (operands) and one for operators.
 * 
 * - The expression is parsed from left to right, and operators are applied based on their 
 *   precedence. Parentheses are handled by recursive evaluation of sub-expressions.
 * 
 * - The method ensures correct order of operations and handles invalid or unbalanced expressions 
 *   with appropriate exceptions.
 * 
 * Time Complexity:
 * - O(n), where n is the number of characters in the expression, as each character is processed once.
 * 
 * Space Complexity:
 * - O(n) for the stacks that store operands and operators, where n is the number of operands and operators in the expression.
 */
public class RecursiveParser {

    /**
     * Evaluates the given arithmetic expression and returns the result.
     * 
     * @param expression The arithmetic expression to be evaluated, represented as a string.
     * @return The result of the evaluation as a double.
     * @throws IllegalArgumentException If the expression is null, empty, or contains invalid characters.
     * @throws ArithmeticException If a division by zero occurs.
     */
    public static double evaluateExpression(String expression) {
        if (expression == null || expression.isEmpty()) {
            throw new IllegalArgumentException("Expression cannot be null or empty");
        }
        return evaluate(expression.replaceAll("\\s", ""), new int[]{0});
    }

    /**
     * Recursively evaluates the arithmetic expression, processing each character one by one.
     * 
     * @param expression The arithmetic expression to be evaluated.
     * @param index An array with a single element to track the current index in the expression.
     * @return The result of the evaluation as a double.
     * @throws IllegalArgumentException If the expression contains invalid characters or is unbalanced.
     * @throws ArithmeticException If a division by zero occurs.
     */
    private static double evaluate(String expression, int[] index) {
        Stack<Double> values = new Stack<>();
        Stack<Character> operators = new Stack<>();

        while (index[0] < expression.length()) {
            char c = expression.charAt(index[0]);

            if (Character.isDigit(c) || c == '.') {
                // Parse a number
                StringBuilder sb = new StringBuilder();
                while (index[0] < expression.length() &&
                        (Character.isDigit(expression.charAt(index[0])) || expression.charAt(index[0]) == '.')) {
                    sb.append(expression.charAt(index[0]++));
                }
                values.push(Double.parseDouble(sb.toString()));
            } else if (c == '(') {
                // Start evaluating sub-expression
                index[0]++;
                values.push(evaluate(expression, index));
            } else if (c == ')') {
                // End of sub-expression
                index[0]++;
                break;
            } else if (isOperator(c)) {
                // Process operator
                while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(c)) {
                    applyOperation(values, operators.pop());
                }
                operators.push(c);
                index[0]++;
            } else {
                throw new IllegalArgumentException("Invalid character in expression: " + c);
            }
        }

        // Apply remaining operators
        while (!operators.isEmpty()) {
            applyOperation(values, operators.pop());
        }

        // Ensure single result
        if (values.size() != 1) {
            throw new IllegalArgumentException("Invalid expression: Unbalanced operators and operands");
        }

        return values.pop();
    }

    /**
     * Checks if the given character is a valid operator.
     * 
     * @param c The character to be checked.
     * @return True if the character is a valid operator (+, -, *, /), otherwise false.
     */
    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    /**
     * Returns the precedence of the given operator.
     * 
     * @param operator The operator whose precedence is to be determined.
     * @return The precedence of the operator, where higher values indicate higher precedence.
     */
    private static int precedence(char operator) {
        if (operator == '+' || operator == '-') return 1;
        if (operator == '*' || operator == '/') return 2;
        return 0;
    }

    /**
     * Applies the given operator on the top two values in the values stack.
     * 
     * @param values The stack of values on which the operation will be applied.
     * @param operator The operator to be applied.
     * @throws IllegalArgumentException If there are not enough values in the stack for the operation.
     * @throws ArithmeticException If a division by zero occurs.
     */
    private static void applyOperation(Stack<Double> values, char operator) {
        if (values.size() < 2) {
            throw new IllegalArgumentException("Invalid expression: Insufficient values for operator " + operator);
        }
        double b = values.pop();
        double a = values.pop();
        switch (operator) {
            case '+':
                values.push(a + b);
                break;
            case '-':
                values.push(a - b);
                break;
            case '*':
                values.push(a * b);
                break;
            case '/':
                if (b == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                values.push(a / b);
                break;
            default:
                throw new IllegalArgumentException("Unknown operator: " + operator);
        }
    }
}
