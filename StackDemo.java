import java.util.EmptyStackException;

class Stack {

  private int[] stack;
  private int top;
  private int capacity;

  public Stack(int capacity) {
    this.capacity = capacity;
    stack = new int[capacity];
    top = -1;
  }

  public void push(int value) {
    if (top == capacity - 1) {
      System.out.println("Stack overflow");
      return;
    }
    stack[++top] = value;
  }

  public int pop() {
    if (isEmpty()) {
      throw new EmptyStackException();
    }
    return stack[top--];
  }

  public int peek() {
    if (isEmpty()) {
      throw new EmptyStackException();
    }
    return stack[top];
  }

  public boolean isEmpty() {
    return top == -1;
  }

  public void display() {
    if (isEmpty()) {
      System.out.println("Stack is empty");
      return;
    }
    for (int i = 0; i <= top; i++) {
      System.out.print(stack[i] + " ");
    }
    System.out.println();
  }
}

public class StackDemo {

  public static void main(String[] args) {
    Stack stack = new Stack(5);
    stack.push(10);
    stack.push(20);
    stack.push(30);
    stack.display();
    System.out.println("Popped element: " + stack.pop());
    stack.display();
  }
}
