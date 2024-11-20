import java.util.Scanner;

public class ArraysExample {

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      // Input array size
      System.out.print("Enter the size of the array: ");
      int n = sc.nextInt();
      int[] arr = new int[n];

      // Input array elements
      System.out.println("Enter " + n + " elements:");
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }

      // Display array elements
      System.out.println("Array elements are:");
      for (int num : arr) {
        System.out.print(num + " ");
      }
    }
  }
}
