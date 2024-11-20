import java.util.Stack;

public class PostfixEvaluation {

  public static int evaluatePostfix(String expression) {
    Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < expression.length(); i++) {
      char c = expression.charAt(i);

      if (Character.isDigit(c)) {
        stack.push(c - '0');
      } else {
        int val2 = stack.pop();
        int val1 = stack.pop();

        switch (c) {
          case '+':
            stack.push(val1 + val2);
            break;
          case '-':
            stack.push(val1 - val2);
            break;
          case '*':
            stack.push(val1 * val2);
            break;
          case '/':
            stack.push(val1 / val2);
            break;
        }
      }
    }
    return stack.pop();
  }

  public static void main(String[] args) {
    String postfix = "231*+9-";
    System.out.println(
      "Postfix Evaluation Result: " + evaluatePostfix(postfix)
    );
  }
}
