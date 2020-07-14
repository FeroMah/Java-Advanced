package ExamPreparation.PractisExam.Exam3_22_Feb_2020.ReVolt_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReVolt {
    private static final int PLAYER_STEP = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int matrixSize = Integer.parseInt(br.readLine());
        int commandsCount = Integer.parseInt(br.readLine());

        int[] oldPlayerPosition = new int[2];

        String[][] matrix = new String[matrixSize][matrixSize];

        for (int row = 0; row < matrixSize; row++) {
            String lineInput = br.readLine();
            for (int col = 0; col < matrix.length; col++) {
                String symbol = String.valueOf(lineInput.charAt(col));
                matrix[row][col] = symbol;

                if (symbol.equals("f")) {
                    oldPlayerPosition[0] = row;
                    oldPlayerPosition[1] = col;
                }
            }
        }
        while (true) {

            if (commandsCount == 0) {
                System.out.println("Player lost!");
                break;
            }

            String command = br.readLine();
            int[] newPlayerPosition = new int[2];
            newPlayerPosition[0] = oldPlayerPosition[0];
            newPlayerPosition[1] = oldPlayerPosition[1];

            matrix[oldPlayerPosition[0]][oldPlayerPosition[1]] = "-";

            movePlayerToNewPosition(command, oldPlayerPosition, newPlayerPosition);


            alwaysStayInsideMatrix(matrixSize, oldPlayerPosition, newPlayerPosition);


            if ("B".equals(matrix[newPlayerPosition[0]][newPlayerPosition[1]])) {
                switch (command) {
                    case "down":
                        newPlayerPosition[0] += PLAYER_STEP;
                        break;

                    case "up":
                        newPlayerPosition[0] -= PLAYER_STEP;
                        break;

                    case "left":
                        newPlayerPosition[1] -= PLAYER_STEP;
                        break;

                    case "right":
                        newPlayerPosition[1] += PLAYER_STEP;
                        break;
                }
                alwaysStayInsideMatrix(matrixSize, oldPlayerPosition, newPlayerPosition);

            } else if ("T".equals(matrix[newPlayerPosition[0]][newPlayerPosition[1]])) {
                newPlayerPosition[1] = oldPlayerPosition[1];
                newPlayerPosition[0] = oldPlayerPosition[0];
            }
            if ("F".equals(matrix[newPlayerPosition[0]][newPlayerPosition[1]])) {
                matrix[oldPlayerPosition[0]][oldPlayerPosition[1]] = "-";
                matrix[newPlayerPosition[0]][newPlayerPosition[1]] = "f";
                System.out.println("Player won!");
                break;
            }
            matrix[oldPlayerPosition[0]][oldPlayerPosition[1]] = "-";


            oldPlayerPosition[1] = newPlayerPosition[1];
            oldPlayerPosition[0] = newPlayerPosition[0];
            matrix[oldPlayerPosition[0]][oldPlayerPosition[1]] = "f";

            commandsCount--;
//            Only for testing:
//            printMatrix(matrix);
        }

        printMatrix(matrix);

    }

    private static void alwaysStayInsideMatrix(int matrixSize, int[] oldPlayerPosition, int[] newPlayerPosition) {
        if (newPlayerPosition[1] >= matrixSize) {
            newPlayerPosition[1] -= matrixSize;
            oldPlayerPosition[1] = newPlayerPosition[1];
        }
        if (newPlayerPosition[1] < 0) {
            newPlayerPosition[1] += matrixSize;
            oldPlayerPosition[1] = newPlayerPosition[1];
        }

        if (newPlayerPosition[0] >= matrixSize) {
            newPlayerPosition[0] -= matrixSize;
            oldPlayerPosition[0] = newPlayerPosition[0];
        }

        if (newPlayerPosition[0] < 0) {
            newPlayerPosition[0] += matrixSize;
            oldPlayerPosition[0] = newPlayerPosition[0];
        }
    }

    private static void movePlayerToNewPosition(String command, int[] oldPlayerPosition, int[] newPlayerPosition) {
        switch (command) {
            case "down":
                newPlayerPosition[0] = oldPlayerPosition[0] + PLAYER_STEP;
                break;

            case "up":
                newPlayerPosition[0] = oldPlayerPosition[0] - PLAYER_STEP;
                break;

            case "left":
                newPlayerPosition[1] = oldPlayerPosition[1] - PLAYER_STEP;
                break;

            case "right":
                newPlayerPosition[1] = oldPlayerPosition[1] + PLAYER_STEP;
                break;
        }
    }

    private static void printMatrix(String[][] matrix) {
        StringBuilder sb = new StringBuilder();
        for (String[] strings : matrix) {

            for (int j = 0; j < matrix.length; j++) {
                sb.append(strings[j]);
            }
            sb.append(System.lineSeparator());

        }
        System.out.println(sb.toString().trim());

    }
}

