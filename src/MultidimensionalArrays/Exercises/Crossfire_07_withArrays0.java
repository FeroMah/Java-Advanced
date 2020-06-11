package MultidimensionalArrays.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class Crossfire_07_withArrays0 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] matrixDimensions = Arrays.stream(sc.nextLine().split("\\s+")).limit(2).mapToInt(Integer::parseInt).toArray();
        int rows = matrixDimensions[0];
        int columns = matrixDimensions[1];
        int valueFilled = 1;
        String matrix[][] = new String[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = String.valueOf(valueFilled++);
            }
        }
        String consoleInput;
        while (!"Nuke it from orbit".equalsIgnoreCase(consoleInput = sc.nextLine())) {
            int[] commandInput = Arrays.stream(consoleInput.split("\\s+")).limit(3).mapToInt(Integer::parseInt).toArray();
            int rowDestroy = commandInput[0];
            int columnDestroy = commandInput[1];
            int power = commandInput[2];
            if (rowDestroy < rows && columnDestroy < columns) {
                matrix[rowDestroy][columnDestroy] = " ";
                int removeHorizontalStart = columnDestroy - power;
                if (removeHorizontalStart < 0) {
                    removeHorizontalStart = 0;
                }
                int removeHorizontalEnd = columnDestroy + power;
                if (removeHorizontalEnd >= rows) {
                    removeHorizontalEnd = rows - 1;
                }
                int removeVerticalStart = rowDestroy - power;
                if (removeVerticalStart < 0) {
                    removeVerticalStart = 0;
                }
                int removeVerticalEnd = rowDestroy + power;
                if (removeVerticalEnd >= columns) {
                    removeVerticalEnd = columns - 1;
                }
                for (int i = 0; i < rows; i++) {
                    if (i == rowDestroy) {
                        for (int j = removeHorizontalStart; j < removeHorizontalEnd; j++) {
                            matrix[i][j] = " ";
                        }
                    }
                    for (int j = 0; j < columns; j++) {
                        if (j == columnDestroy) {
                            for (int k = removeVerticalStart; k < removeVerticalEnd; k++) {
                                matrix[k][j] =" ";
                            }
                        }
                    }
                }
            }
        }
        // final printing
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}

