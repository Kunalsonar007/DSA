import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {

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

      // Sort the array
      Arrays.sort(arr);

      // Input the element to search
      System.out.print("Enter the element to search: ");
      int key = sc.nextInt();

      // Binary search
      int result = binarySearch(arr, key);
      if (result == -1) {
        System.out.println("Element not found.");
      } else {
        System.out.println("Element found at index: " + result);
      }
    }
  }

  public static int binarySearch(int[] arr, int key) {
    int low = 0, high = arr.length - 1;

    while (low <= high) {
      int mid = low + (high - low) / 2;

      if (arr[mid] == key) {
        return mid; // Element found
      } else if (arr[mid] < key) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }

    return -1; // Element not found
  }
}
