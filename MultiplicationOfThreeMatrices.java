import java.util.Scanner;

public class MultiplicationOfThreeMatrices {

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      // Define the size of the matrix (3x3)
      int rows = 3, cols = 3;

      int[][] matrix1 = new int[rows][cols];
      int[][] matrix2 = new int[rows][cols];
      int[][] matrix3 = new int[rows][cols];
      int[][] tempResult = new int[rows][cols];
      int[][] finalResult = new int[rows][cols];

      System.out.println("Enter elements of the first matrix (3x3):");
      for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
          matrix1[i][j] = sc.nextInt();
        }
      }

      System.out.println("Enter elements of the second matrix (3x3):");
      for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
          matrix2[i][j] = sc.nextInt();
        }
      }

      System.out.println("Enter elements of the third matrix (3x3):");
      for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
          matrix3[i][j] = sc.nextInt();
        }
      }

      // Multiplying first two matrices: matrix1 and matrix2
      for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
          tempResult[i][j] = 0; // Initialize the result cell
          for (int k = 0; k < cols; k++) {
            tempResult[i][j] += matrix1[i][k] * matrix2[k][j];
          }
        }
      }

      // Multiplying the result with the third matrix: tempResult and matrix3
      for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
          finalResult[i][j] = 0; // Initialize the result cell
          for (int k = 0; k < cols; k++) {
            finalResult[i][j] += tempResult[i][k] * matrix3[k][j];
          }
        }
      }

      System.out.println(
        "Resultant matrix after multiplication of three matrices:"
      );
      for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
          System.out.print(finalResult[i][j] + " ");
        }
        System.out.println();
      }
    }
  }
}
