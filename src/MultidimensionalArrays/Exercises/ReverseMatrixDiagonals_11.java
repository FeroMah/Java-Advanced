package MultidimensionalArrays.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseMatrixDiagonals_11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] matrixRowsAndColumns = Arrays.stream(sc.nextLine().split("\\s+")).limit(2).mapToInt(Integer::parseInt).toArray();
        int rows = matrixRowsAndColumns[0];
        int columns = matrixRowsAndColumns[1];
        String[][] matrix = new String[rows][columns];
        for (int r = 0; r < rows; r++) {
            matrix[r] = sc.nextLine().split("\\s+");
        }
        int row = rows - 1;
        int col = columns - 1;
        while (row >= 0) {
            int r = row;
            int c = col;
            while (c < columns && r >= 0) {
                System.out.print(matrix[r--][c++] + " ");
            }
            System.out.println();
            col--;
            if (col<0){
                col=0;
                row--;
            }
        }
    }
}
