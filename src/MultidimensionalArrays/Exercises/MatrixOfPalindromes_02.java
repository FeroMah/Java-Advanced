package MultidimensionalArrays.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixOfPalindromes_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] inputDimensions = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = inputDimensions[0];
        int columns = inputDimensions[1];
        char beginCharRow = 'a';
        char middleChar = 'a';

        String[][] matrix = new String[rows][columns];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                matrix[row][col]=""; // remove null value of the matrix [] [];
                for (int symbolPosition = 0; symbolPosition < 3; symbolPosition++) {
                    if (symbolPosition == 1 && col!=0) {
                        matrix[row][col] += (char) middleChar;
                    } else
                        matrix[row][col] += beginCharRow;
                }
                middleChar++;
                System.out.print(matrix[row][col] + " ");
            }
            beginCharRow++;
            middleChar=beginCharRow;
            System.out.println();
        }
    }
}
