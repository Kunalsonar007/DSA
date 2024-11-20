import java.util.Scanner;

public class TransposeofMatrix {

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      System.out.print("Enter the number of rows: ");
      int rows = sc.nextInt();
      System.out.print("Enter the number of columns: ");
      int cols = sc.nextInt();

      int[][] matrix = new int[rows][cols];
      int[][] transpose = new int[cols][rows];

      System.out.println("Enter elements of the matrix:");
      for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
          matrix[i][j] = sc.nextInt();
        }
      }

      // Calculate transpose
      for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
          transpose[j][i] = matrix[i][j];
        }
      }

      System.out.println("Transpose of the matrix:");
      for (int i = 0; i < cols; i++) {
        for (int j = 0; j < rows; j++) {
          System.out.print(transpose[i][j] + " ");
        }
        System.out.println();
      }
    }
  }
}
