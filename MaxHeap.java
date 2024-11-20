import java.util.Collections;
import java.util.PriorityQueue;

class MaxHeap {

  public static void main(String[] args) {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
      Collections.reverseOrder()
    );

    // Insert elements into the heap
    maxHeap.add(10);
    maxHeap.add(30);
    maxHeap.add(20);
    maxHeap.add(5);
    maxHeap.add(1);

    System.out.println("Max-Heap: " + maxHeap);

    // Remove the largest element (root)
    System.out.println("Removed element: " + maxHeap.poll());
    System.out.println("Max-Heap after removal: " + maxHeap);
  }
}
