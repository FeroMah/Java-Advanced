package MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] inputDimensions1 = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows1 = inputDimensions1[0];
        int colons1 = inputDimensions1[1];
        String[][] multArray1 = new String[rows1][colons1];

        for (int i = 0; i < rows1; i++) {
            String[] inputConsole = sc.nextLine().split("\\s+");
            for (int j = 0; j < colons1; j++) {
                multArray1[i][j] = inputConsole[j];
            }
        }
        int[] inputDimensions2 = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows2 = inputDimensions2[0];
        int colons2 = inputDimensions2[1];
        String[][] multArray2 = new String[rows2][colons2];

        for (int i = 0; i < rows2; i++) {
            String[] inputConsole = sc.nextLine().split("\\s+");
            for (int j = 0; j < colons2; j++) {
                multArray2[i][j] = inputConsole[j];
            }
        }
        // Compare the matrix
        boolean areEqual = false;
        if (rows1 == rows2 && colons1 == colons2) {
            for (int i = 0; i < rows1; i++) {
                for (int j = 0; j < colons1; j++) {
                    if (multArray1[i][j].equals(multArray2[i][j])) {
                        areEqual = true;
                    } else {
                        System.out.println("not equal");
                        return;
                    }
                }
            }
        } else {
            System.out.println("not equal");
            return;
        }
        if (areEqual) {
            System.out.println("equal");
        }
    }
}
