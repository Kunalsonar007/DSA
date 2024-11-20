import java.util.PriorityQueue;

class MinHeap {

  public static void main(String[] args) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    // Insert elements into the heap
    minHeap.add(10);
    minHeap.add(30);
    minHeap.add(20);
    minHeap.add(5);
    minHeap.add(1);

    System.out.println("Min-Heap: " + minHeap);

    // Remove the smallest element (root)
    System.out.println("Removed element: " + minHeap.poll());
    System.out.println("Min-Heap after removal: " + minHeap);
  }
}
