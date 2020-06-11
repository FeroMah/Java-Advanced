package MultidimensionalArrays.Exercises;


import java.util.Scanner;

public class FillTheMatrix_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] inputLine = (sc.nextLine().split(",\\s+"));
        int size = Integer.valueOf(inputLine[0]);
        char fillPattern = inputLine[1].charAt(0);
        int[][] matrix = new int[size][size];
        int value = 1;
        if (fillPattern == 'A') {
            for (int col = 0; col < size; col++) {
                for (int row = 0; row < size; row++) {
                    matrix[row][col] = value++;
                }
            }
        } else if (fillPattern == 'B') {
            for (int col = 0; col < size; col++) {
                if (col % 2 == 0) {
                    for (int row = 0; row < size; row++) {
                        matrix[row][col] = value++;
                    }
                } else {
                    for (int row = size - 1; row >= 0; row--) {
                        matrix[row][col] = value++;
                    }
                }
            }
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
