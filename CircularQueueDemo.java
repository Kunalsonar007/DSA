class CircularQueue {

  private int[] queue;
  private int front, rear, size, capacity;

  public CircularQueue(int capacity) {
    this.capacity = capacity;
    queue = new int[capacity];
    front = rear = -1;
    size = 0;
  }

  public void enqueue(int value) {
    if (size == capacity) {
      System.out.println("Circular Queue is full");
      return;
    }
    rear = (rear + 1) % capacity;
    queue[rear] = value;
    if (front == -1) {
      front = rear;
    }
    size++;
  }

  public int dequeue() {
    if (isEmpty()) {
      throw new RuntimeException("Circular Queue is empty");
    }
    int value = queue[front];
    front = (front + 1) % capacity;
    size--;
    if (size == 0) {
      front = rear = -1;
    }
    return value;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public void display() {
    if (isEmpty()) {
      System.out.println("Circular Queue is empty");
      return;
    }
    int i = front;
    for (int count = 0; count < size; count++) {
      System.out.print(queue[i] + " ");
      i = (i + 1) % capacity;
    }
    System.out.println();
  }
}

public class CircularQueueDemo {

  public static void main(String[] args) {
    CircularQueue cq = new CircularQueue(5);
    cq.enqueue(10);
    cq.enqueue(20);
    cq.enqueue(30);
    cq.display();
    System.out.println("Dequeued element: " + cq.dequeue());
    cq.display();
  }
}
