import java.util.Stack;

public class PolishNotation {

  public static String infixToPostfix(String expression) {
    StringBuilder result = new StringBuilder();
    Stack<Character> stack = new Stack<>();

    for (int i = 0; i < expression.length(); i++) {
      char c = expression.charAt(i);

      if (Character.isLetterOrDigit(c)) {
        result.append(c);
      } else if (c == '(') {
        stack.push(c);
      } else if (c == ')') {
        while (!stack.isEmpty() && stack.peek() != '(') {
          result.append(stack.pop());
        }
        stack.pop();
      } else {
        while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
          result.append(stack.pop());
        }
        stack.push(c);
      }
    }

    while (!stack.isEmpty()) {
      result.append(stack.pop());
    }

    return result.toString();
  }

  private static int precedence(char operator) {
    switch (operator) {
      case '+':
      case '-':
        return 1;
      case '*':
      case '/':
        return 2;
      case '^':
        return 3;
    }
    return -1;
  }

  public static void main(String[] args) {
    String infix = "a+b*(c^d-e)^(f+g*h)-i";
    System.out.println("Postfix Notation: " + infixToPostfix(infix));
  }
}
