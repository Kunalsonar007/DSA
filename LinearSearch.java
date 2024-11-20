import java.util.Scanner;

public class LinearSearch {

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      // Input array size and elements
      System.out.print("Enter the size of the array: ");
      int n = sc.nextInt();
      int[] arr = new int[n];

      System.out.println("Enter " + n + " elements:");
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }

      // Input the element to search
      System.out.print("Enter the element to search: ");
      int key = sc.nextInt();

      // Linear search
      boolean found = false;
      for (int i = 0; i < n; i++) {
        if (arr[i] == key) {
          System.out.println("Element found at index: " + i);
          found = true;
          break;
        }
      }

      if (!found) {
        System.out.println("Element not found in the array.");
      }
    }
  }
}
