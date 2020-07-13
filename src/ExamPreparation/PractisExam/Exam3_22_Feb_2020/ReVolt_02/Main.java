package ExamPreparation.PractisExam.Exam3_22_Feb_2020.ReVolt_02;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        int matrixSize = Integer.parseInt(br.readLine());
        int commandsCount = Integer.parseInt(br.readLine());

        int playerPosY = 0;
        int playerPosX = 0;

        String[][] matrix = new String[matrixSize][matrixSize];

        for (int y = 0; y < matrixSize; y++) {
            String lineInput = br.readLine();
            for (int x = 0; x < matrix.length; x++) {
                String symbol = String.valueOf(lineInput.charAt(x));
                matrix[y][x] = symbol;

                if (symbol.equals("f")) {
                    playerPosY = y;
                    playerPosX = x;
                }
            }
        }

        while (true) {

            if (commandsCount == 0) {
                System.out.println("Player lost!");
                break;
            }

            String command = br.readLine();

            int newPosY = playerPosY;
            int newPosX = playerPosX;

            matrix[playerPosY][playerPosX] = "-";

            switch (command) {
                case "down":
                    newPosY = playerPosY + 1;

                    break;

                case "up":
                    newPosY = playerPosY - 1;
                    break;

                case "left":
                    newPosX = playerPosX - 1;
                    break;

                case "right":
                    newPosX = playerPosX + 1;
                    break;
            }


            if (newPosX >= matrixSize) {
                newPosX -= matrixSize;
                playerPosX = newPosX;
            }
            if (newPosX < 0) {
                newPosX += matrixSize;
                playerPosX = newPosX;
            }

            if (newPosY >= matrixSize) {
                newPosY -= matrixSize;
                playerPosY = newPosY;
            }

            if (newPosY < 0) {
                newPosY += matrixSize;
                playerPosY = newPosY;
            }


            if ("B".equals(matrix[newPosY][newPosX])) {
                switch (command) {
                    case "down":
                        newPosY += 1;

                        break;

                    case "up":
                        newPosY -= 1;
                        break;

                    case "left":
                        newPosX -= 1;
                        break;

                    case "right":
                        newPosX += 1;
                        break;

                }
                if (newPosX >= matrixSize) {
                    newPosX -= matrixSize;
                    playerPosX = newPosX;
                }
                if (newPosX < 0) {
                    newPosX += matrixSize;
                    playerPosX = newPosX;
                }

                if (newPosY >= matrixSize) {
                    newPosY -= matrixSize;
                    playerPosY = newPosY;
                }

                if (newPosY < 0) {
                    newPosY += matrixSize;
                    playerPosY = newPosY;
                }
            } else if ("T".equals(matrix[newPosY][newPosX])) {
                newPosX = playerPosX;
                newPosY = playerPosY;
            }  if ("F".equals(matrix[newPosY][newPosX])) {
                matrix[playerPosY][playerPosX] = "-";
                matrix[newPosY][newPosX] = "f";
                System.out.println("Player won!");
                break ;
            }
            matrix[playerPosY][playerPosX] = "-";


            playerPosX = newPosX;
            playerPosY = newPosY;
            matrix[playerPosY][playerPosX] = "f";

            commandsCount--;
//            Only for testing:
//            printMatrix(matrix);
        }

        printMatrix(matrix);

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