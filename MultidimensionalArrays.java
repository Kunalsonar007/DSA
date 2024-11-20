import java.util.Scanner;

public class MultidimensionalArrays {

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      // Input dimensions
      System.out.print("Enter number of rows: ");
      int rows = sc.nextInt();
      System.out.print("Enter number of columns: ");
      int cols = sc.nextInt();

      int[][] matrix = new int[rows][cols];

      // Input matrix elements
      System.out.println("Enter matrix elements:");
      for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
          matrix[i][j] = sc.nextInt();
        }
      }

      // Display matrix
      System.out.println("Matrix is:");
      for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
          System.out.print(matrix[i][j] + " ");
        }
        System.out.println();
      }
    }
  }
}
