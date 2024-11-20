class Queue {

  private int[] queue;
  private int front, rear, capacity;

  public Queue(int capacity) {
    this.capacity = capacity;
    queue = new int[capacity];
    front = rear = -1;
  }

  public void enqueue(int value) {
    if (rear == capacity - 1) {
      System.out.println("Queue is full");
      return;
    }
    if (front == -1) {
      front = 0;
    }
    queue[++rear] = value;
  }

  public int dequeue() {
    if (isEmpty()) {
      throw new RuntimeException("Queue is empty");
    }
    int value = queue[front];
    if (front == rear) {
      front = rear = -1;
    } else {
      front++;
    }
    return value;
  }

  public boolean isEmpty() {
    return front == -1;
  }

  public void display() {
    if (isEmpty()) {
      System.out.println("Queue is empty");
      return;
    }
    for (int i = front; i <= rear; i++) {
      System.out.print(queue[i] + " ");
    }
    System.out.println();
  }
}

public class QueueDemo {

  public static void main(String[] args) {
    Queue queue = new Queue(5);
    queue.enqueue(10);
    queue.enqueue(20);
    queue.enqueue(30);
    queue.display();
    System.out.println("Dequeued element: " + queue.dequeue());
    queue.display();
  }
}
