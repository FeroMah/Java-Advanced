package MultidimensionalArrays.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling_05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] matrixDimensions = Arrays.stream(sc.nextLine().split("\\s+")).limit(2).mapToInt(Integer::parseInt).toArray();
        int rows = matrixDimensions[0];
        int columns = matrixDimensions[1];
        String[][] matrix = new String[rows][columns];
        for (int i = 0; i < rows; i++) {
            String[] consoleInput = sc.nextLine().split("\\s+");
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = consoleInput[j];
            }
        }
        String input=sc.nextLine();
        while (!input.equalsIgnoreCase("End")) {
            String[] userInput = input.split("\\s+");
            String command = userInput[0];
            if (command.equalsIgnoreCase("swap")&& userInput.length==5) {
                int rowFrom = Integer.parseInt(userInput[1]);
                int columnFrom = Integer.parseInt(userInput[2]);
                int rowTo = Integer.parseInt(userInput[3]);
                int columnTo = Integer.parseInt(userInput[4]);
                if (rowFrom>rows || rowTo>rows || columnFrom>columns || columnTo>columns){
                    System.out.println("Invalid input!");
                    input=sc.nextLine();
                    continue;
                }
                String buffer = matrix[rowTo][columnTo];
                matrix[rowTo][columnTo] = matrix[rowFrom][columnFrom];
                matrix[rowFrom][columnFrom] = buffer;

                for (int i = 0; i <rows ; i++) {
                    for (int j = 0; j <columns ; j++) {
                        System.out.print(matrix[i][j]+" ");
                    }
                    System.out.println();
                }
            } else {
                System.out.println("Invalid input!");
            }
            input=sc.nextLine();
        }
    }
}
