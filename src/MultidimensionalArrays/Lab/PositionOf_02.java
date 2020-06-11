package MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class PositionOf_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] inputDimensions = Arrays.stream(sc.nextLine().split("\\s+")).limit(2).mapToInt(Integer::parseInt).toArray();
        int rows = inputDimensions[0];
        int cols = inputDimensions[1];

        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            int[] inputLine = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = inputLine[j];
            }
        }
        boolean isFound = false;
        int searchedNumber = Integer.parseInt(sc.nextLine());
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (searchedNumber == matrix[row][col]) {
                    System.out.println(row + " " + col);
                    isFound = true;
                }
            }
        }
        if (!isFound) {
            System.out.println("not found");
        }
    }
}
