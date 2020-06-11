package MultidimensionalArrays.Lab;


import java.util.Scanner;

public class IntersectionTwoMatrices_03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberRows = Integer.parseInt(sc.nextLine());
        int numberColons = Integer.parseInt(sc.nextLine());

        char[][] matrixA = new char[numberRows][numberColons];
        for (int row = 0; row < numberRows; row++) {
            String[] inputLine = sc.nextLine().split("\\s+");
            for (int col = 0; col < numberColons; col++) {
                matrixA[row][col] = inputLine[col].charAt(0);
            }
        }
        char[][] matrixB = new char[numberRows][numberColons];
        for (int row = 0; row < numberRows; row++) {
            String[] inputLine = sc.nextLine().split("\\s+");
            for (int col = 0; col < numberColons; col++) {
                matrixB[row][col] = inputLine[col].charAt(0);
            }
        }
        char[][] matrixC = new char[numberRows][numberColons];
        for (int row = 0; row < numberRows; row++) {
            for (int col = 0; col < numberColons; col++) {
                if (matrixA[row][col] != matrixB[row][col]) {
                    matrixC[row][col] = '*';
                } else matrixC[row][col] = matrixA[row][col];
                System.out.print(matrixC[row][col] + " ");
            }
            System.out.println();
        }
    }
}