package MultidimensionalArrays.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference_03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int matrixSize = Integer.parseInt(sc.nextLine());
        int[][] matrix = new int[matrixSize][matrixSize];
        for (int i = 0; i < matrixSize; i++) {
            int[] inputLine = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < matrixSize; j++) {
                matrix[i][j] = inputLine[j];
            }
        }
        int sumFromTop = 0;
        int sumFromBot = 0;
        for (int i = 0; i < matrixSize; i++) {
            sumFromTop += matrix[i][i];
            sumFromBot += matrix[matrixSize - 1 - i][i];
        }
        System.out.println(Math.abs(sumFromBot-sumFromTop));
    }
}
