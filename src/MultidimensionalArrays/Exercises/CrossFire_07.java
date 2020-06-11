package MultidimensionalArrays.Exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CrossFire_07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] matrixDimensions = Arrays.stream(sc.nextLine().split("\\s+")).limit(2).mapToInt(Integer::parseInt).toArray();
        int rows = matrixDimensions[0];
        int columns = matrixDimensions[1];
        ArrayList<ArrayList<String>> matrix = generateMatrix(rows, columns);
        String input = sc.nextLine();
        while (!input.equals("Nuke it from orbit")) {
            int[] data = Arrays.stream(input.split("\\s+")).mapToInt(Integer::parseInt).toArray();
            // input position of element to be destroy
            int rowD = data[0];
            int colD = data[1];
            int power = data[2];    // power of explosion (in vertical and horizontal only)

            // replace destroyed numbers with " " by rows (vertical)
            for (int col = colD - power; col <= colD + power; col++) {
                if (isInBounds(matrix, rowD, col))
                    matrix.get(rowD).set(col, " ");
            }
//           replace destroyed numbers with " " by columns (horizontal)
            for (int row = rowD - power; row <= rowD + power; row++) {
                if (isInBounds(matrix, row, colD)) {
                    matrix.get(row).set(colD, " ");
                }
            }

            for (int r = 0; r < matrix.size(); r++) {
                while (matrix.get(r).contains(" ")) {
                    matrix.get(r).remove(" ");
                }
                if (matrix.get(r).size() == 0) {    // if some row has size = 0, it should be deleted
                    matrix.remove(r);
                    r--;
                }
            }
            input = sc.nextLine();
        }
        printMatrix(matrix);
    }

    private static boolean isInBounds(ArrayList<ArrayList<String>> matrix, int row, int col) {
        return row >= 0 && row < matrix.size() && col >= 0 && col < matrix.get(row).size();
    }

    private static void printMatrix(ArrayList<ArrayList<String>> matrix) {
        for (int r = 0; r < matrix.size(); r++) {
            for (int c = 0; c < matrix.get(r).size(); c++) {
                System.out.print(matrix.get(r).get(c) + " ");
            }
            System.out.println();
        }
    }

    private static ArrayList<ArrayList<String>> generateMatrix(int rows, int columns) {
        ArrayList<ArrayList<String>> matrix = new ArrayList<>();
        int fillerValue = 1;
        for (int r = 0; r < rows; r++) {
            ArrayList<String> row = new ArrayList<>();
            for (int c = 0; c < columns; c++) {
                row.add(String.valueOf(fillerValue));
                fillerValue++;
            }
            matrix.add(row);
        }
        return matrix;
    }
}

