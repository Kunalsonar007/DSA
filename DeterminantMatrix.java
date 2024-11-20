import java.util.Scanner;

public class DeterminantMatrix {

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int[][] matrix = new int[2][2];

      System.out.println("Enter elements of the 2x2 matrix:");
      for (int i = 0; i < 2; i++) {
        for (int j = 0; j < 2; j++) {
          matrix[i][j] = sc.nextInt();
        }
      }

      // Calculate determinant
      int determinant =
        (matrix[0][0] * matrix[1][1]) - (matrix[0][1] * matrix[1][0]);

      System.out.println("Determinant of the matrix is: " + determinant);
    }
  }
}
