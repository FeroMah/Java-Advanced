package MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class Maximum_Sum_of_2x2_Submatrix_05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] inputDimensions = Arrays.stream(sc.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).limit(2).toArray(); // limit(2) is optional for this task
        int rows = inputDimensions[0];
        int colons = inputDimensions[1];
        int[][] matrix = new int[rows][colons];

        for (int row = 0; row < rows; row++) {
            int[] inputLine = Arrays.stream(sc.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).limit(colons).toArray();
            for (int col = 0; col < colons; col++) {
                matrix[row][col] = inputLine[col];
            }
        }
        int biggestSum = Integer.MIN_VALUE;
        int[][] matrix2x2 = new int[2][2];
        int[][] bestMatrix2x2 = new int[2][2];
        for (int row = 0; row < rows; row++) {
            if (row == rows - 1) break;
            for (int col = 0; col < colons; col++) {
                if (col == colons - 1) break;
                int sum2x2 =0;
                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < 2; j++) {
                        matrix2x2[i][j] = matrix[row+i][col+j];
                        sum2x2+= matrix2x2[i][j];
                    }
                }
                if (biggestSum < sum2x2) {
                    biggestSum = sum2x2;
                    for (int i = 0; i < 2; i++) {
                        for (int j = 0; j < 2; j++) {
                            bestMatrix2x2[i][j] = matrix2x2[i][j];
                        }
                    }
                }
            }
        }
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(bestMatrix2x2[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(biggestSum);
    }
}
