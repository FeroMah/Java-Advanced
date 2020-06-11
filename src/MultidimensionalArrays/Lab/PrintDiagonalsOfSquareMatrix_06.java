package MultidimensionalArrays.Lab;

import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix_06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = Integer.parseInt(sc.nextLine());
        String[][] matrix = new String[size][size];
        for (int i = 0; i < size; i++) {
            String[] inputLine = sc.nextLine().split("\\s+");
            for (int j = 0; j < size; j++) {
                if (j < inputLine.length) {
                    matrix[i][j] = inputLine[j];
                }else {
                    matrix[i][j] = "0";
                }
            }
        }
        String diagonal1 = "";
        String diagonal2 = "";
        for (int row = 0; row < size; row++) {
            diagonal1 += matrix[row][row] + " ";
        }
        System.out.println(diagonal1);
        int colDiagonal2 = 0;
        for (int row = size - 1; row >= 0; row--) {
            diagonal2 += matrix[row][colDiagonal2++] + " ";
        }
        System.out.println(diagonal2);
    }
}
