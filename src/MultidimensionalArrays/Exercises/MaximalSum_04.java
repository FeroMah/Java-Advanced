package MultidimensionalArrays.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum_04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] matrixDimensions = Arrays.stream(sc.nextLine().split("\\s+")).limit(2).mapToInt(Integer::parseInt).toArray();
        int matrixRows = matrixDimensions[0];
        int matrixColumns = matrixDimensions[1];
        int[][] matrix = new int[matrixRows][matrixColumns];
        for (int i = 0; i < matrixRows; i++) {
            int[] inputLine = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < matrixColumns; j++) {
                matrix[i][j] = inputLine[j];

            }
        }
        int[][] matrix3X3 = new int[3][3];
        int[][] matrix3X3Best = new int[3][3];

        int biggestSum = Integer.MIN_VALUE;

        for (int row = 0; row < matrixRows; row++) {
            for (int col = 0; col < matrixColumns; col++) {
                int sum = 0;
                if (row + 3 <= matrixRows && col + 3 <= matrixColumns) {
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            matrix3X3[i][j] = matrix[i + row][j + col];
                            sum += matrix3X3[i][j];
                        }
                    }
                    if (sum > biggestSum) {
                        for (int i = 0; i < 3; i++) {
                            for (int j = 0; j < 3; j++) {
                                matrix3X3Best[i][j] = matrix3X3[i][j];
                            }
                        }
                        biggestSum = sum;
                    }
                }
            }
        }
        System.out.println(String.format("Sum = %d", biggestSum));
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(matrix3X3Best[i][j] + " ");
            }
            System.out.println();
        }

    }
}