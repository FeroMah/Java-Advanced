package MultidimensionalArrays.Exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringMatrixRotation_06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputCommand = sc.nextLine();

        String regex = "^(?<command>[A-Za-z]+)\\((?<degrees>[\\d]+)\\)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(inputCommand);
        int rotateAtDegrees = 0;
        if (matcher.find()) {
            if (matcher.group("command").equalsIgnoreCase("Rotate")) {
                rotateAtDegrees = Integer.parseInt(matcher.group("degrees"));
            }
        }
        String inputMatrixContent;
        List<String> inputContent = new ArrayList<>();
        int longestElement = 0;
        int linesOfInput = 0;
        while (!("End").equalsIgnoreCase(inputMatrixContent = sc.nextLine())) {
            inputContent.add(inputMatrixContent);
            if (inputMatrixContent.length() > longestElement) {
                longestElement = inputMatrixContent.length();
            }
            linesOfInput++;
        }
        String[][] matrix = new String[linesOfInput][longestElement];
        int rows = linesOfInput;
        int columns = longestElement;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = "";      // remove null value of every element in the matrix;
                if (j < inputContent.get(i).length()) {
                    matrix[i][j] += inputContent.get(i).charAt(j);
                } else {
                    matrix[i][j] += " ";
                }
            }
        }
        // rotation degrees calculations
        if (rotateAtDegrees > 360) {
            int times = rotateAtDegrees / 360;
            rotateAtDegrees -= 360 * times;
        }
        if (rotateAtDegrees == 180) {
            String[][] rotatedMatrix = new String[rows][columns];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    rotatedMatrix[i][j] = matrix[rows - 1 - i][columns - 1 - j];
                    System.out.print(rotatedMatrix[i][j]);
                }
                System.out.println();
            }
        }
        if (rotateAtDegrees == 270) {
            int rowsRotated = columns;
            int columnsRotated = rows;
            String[][] rotatedMatrix = new String[rowsRotated][columnsRotated];
            for (int i = 0; i < rowsRotated; i++) {
                for (int j = columnsRotated - 1; j >= 0; j--) {
                    rotatedMatrix[i][j] = matrix[rows - 1 - j][columns - 1 - i];
                    System.out.print(rotatedMatrix[i][j]);
                }
                System.out.println();
            }
        }
        if (rotateAtDegrees == 90) {
            int rowsRotated = columns;
            int columnsRotated = rows;
            String[][] rotatedMatrix = new String[rowsRotated][columnsRotated];
            for (int i = rowsRotated - 1; i >= 0; i--) {
                for (int j = 0; j < columnsRotated; j++) {
                    rotatedMatrix[i][j] = matrix[rows - 1 - j][columns - 1 - i];
                    System.out.print(rotatedMatrix[i][j]);
                }
                System.out.println();
            }
        }
        if (rotateAtDegrees == 0 || rotateAtDegrees == 360) {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    System.out.print(matrix[i][j]);
                }
                System.out.println();
            }
        }
    }
}

