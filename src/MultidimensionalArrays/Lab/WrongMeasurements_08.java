package MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class WrongMeasurements_08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int matrixRows = Integer.parseInt(sc.nextLine());
        String[] inputLine = sc.nextLine().split("\\s+");
        int matrixColons = inputLine.length;
        int[][] matrixInputed = new int[matrixRows][matrixColons];
        for (int row = 0; row < matrixRows; row++) {
            if (row == 0) {
                int[] inputConsole = Arrays.stream(inputLine).mapToInt(Integer::parseInt).toArray();
                for (int col = 0; col < matrixColons; col++) {
                    matrixInputed[row][col] = inputConsole[col];
                }
            } else {
                int[] inputConsole = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
                for (int col = 0; col < matrixColons; col++) {
                    matrixInputed[row][col] = inputConsole[col];
                }
            }
        }
        int[] wrongInput = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rowIndex = wrongInput[0];
        int colIndex = wrongInput[1];
        int wrongValue = matrixInputed[rowIndex][colIndex];

        String[][] resultMatrix = new String[matrixRows][matrixColons];
        for (int i = 0; i < matrixRows; i++) {
            for (int j = 0; j < matrixColons; j++) {
                if (matrixInputed[i][j] == wrongValue) {
                    int sumOfNeibours = 0;
                    if (j - 1 >= 0 && matrixInputed[i][j - 1] != wrongValue) {
                        sumOfNeibours += matrixInputed[i][j - 1];
                    }
                    if (j + 1 < matrixColons && matrixInputed[i][j + 1] != wrongValue) {
                        sumOfNeibours += matrixInputed[i][j + 1];
                    }
                    if (i - 1 >= 0 && matrixInputed[i - 1][j] != wrongValue) {
                        sumOfNeibours += matrixInputed[i - 1][j];
                    }
                    if (i + 1 < matrixRows && matrixInputed[i + 1][j] != wrongValue) {
                        sumOfNeibours += matrixInputed[i + 1][j];
                    }
                    resultMatrix[i][j] = sumOfNeibours + " ";

                } else {
                    resultMatrix[i][j] = matrixInputed[i][j]+" ";
                }
            }
        }

        for (int i = 0; i < matrixRows; i++) {
            for (int j = 0; j < matrixColons; j++) {
                System.out.print(resultMatrix[i][j] + "");
            }
            System.out.println();
        }
    }
}