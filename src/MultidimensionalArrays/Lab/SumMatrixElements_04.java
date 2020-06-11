package MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements_04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] inputDimensions = Arrays.stream(sc.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).limit(2).toArray(); // limit(2) is optional for this task
        int rows = inputDimensions[0];
        int colons = inputDimensions[1];

        int finalResult = 0;
        for (int row = 0; row < rows; row++) {
            int[] inputLine = Arrays.stream(sc.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).limit(colons).toArray();
            for (int col = 0; col < colons; col++) {
                finalResult += inputLine[col];
            }
        }
        System.out.println(rows);
        System.out.println(colons);
        System.out.println(finalResult);

    }
}
