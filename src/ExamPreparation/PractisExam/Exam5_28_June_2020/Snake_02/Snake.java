package ExamPreparation.PractisExam.Exam5_28_June_2020.Snake_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Snake {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // matrix size;

        char[][] territory = new char[n][n];
        int[] snakePosition = new int[2];
        int foodEaten = 0;
        List<int[]> lairPosition = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            char[] inputCharRow = br.readLine().toCharArray();
//            System.arraycopy(inputCharRow, 0, playGround[i], 0, inputCharRow.length);
            for (int j = 0; j < inputCharRow.length; j++) {
                territory[i][j] = inputCharRow[j];

                if (inputCharRow[j] == 'S') {
                    snakePosition[0] = i;
                    snakePosition[1] = j;
                } else if (inputCharRow[j] == 'B') {
                    lairPosition.add(new int[]{i, j});
                }
            }
        }

        while (true) {
            if (foodEaten == 10) {
                System.out.println("You won! You fed the snake.");
                break;
            }

            String direction = br.readLine().trim();
            int[] newPosition = new int[2];
            if (direction.equals("up")) {
                newPosition = moveUp(snakePosition);
            }
            if (direction.equals("down")) {
                newPosition = moveDown(snakePosition);
            }
            if (direction.equals("left")) {
                newPosition = moveLeft(snakePosition);
            }
            if (direction.equals("right")) {
                newPosition = moveRight(snakePosition);
            }

            if (isSnakeInsideTheTerritory(newPosition, territory.length)) {

                if (isFood(newPosition, territory)) {

                    foodEaten++;
                }
                if (isLair(newPosition, territory)) {
                    jumpToOtherSideOfTheLair(territory, lairPosition, newPosition);
                }

                territory[snakePosition[0]][snakePosition[1]] = '.';
                snakePosition = new int[]{newPosition[0], newPosition[1]};
                territory[snakePosition[0]][snakePosition[1]] = 'S';
            } else {
                territory[snakePosition[0]][snakePosition[1]] = '.';
                System.out.println("Game over!");
                break;
            }
        }
        printResult(territory, foodEaten);
    }

    private static void jumpToOtherSideOfTheLair(char[][] territory, List<int[]> lairPosition, int[] newPosition) {
        if (lairPosition.get(0)[0] == newPosition[0] && lairPosition.get(0)[1] == newPosition[1]) {
            newPosition[0] = lairPosition.get(1)[0];
            newPosition[1] = lairPosition.get(1)[1];
            territory[lairPosition.get(0)[0]][lairPosition.get(0)[1]] = '.';
        } else {
            newPosition[0] = lairPosition.get(0)[0];
            newPosition[1] = lairPosition.get(0)[1];
            territory[lairPosition.get(1)[0]][lairPosition.get(1)[1]] = '.';
        }
    }

    private static void printResult(char[][] territory, int food) {
        StringBuilder sb = new StringBuilder();
        sb.append("Food eaten: ").append(food).append(System.lineSeparator());
        for (char[] row : territory) {
            for (char c : row) {
                sb.append(c);
            }
            sb.append(System.lineSeparator());
        }
        System.out.println(sb.toString());
    }

    private static boolean isLair(int[] newPosition, char[][] territory) {
        return territory[newPosition[0]][newPosition[1]] == 'B';
    }

    private static boolean isFood(int[] newPosition, char[][] territory) {
        return territory[newPosition[0]][newPosition[1]] == '*';
    }

    private static int[] moveRight(int[] snakePosition) {
        int row = snakePosition[0];
        int col = snakePosition[1] + 1;
        return new int[]{row, col};
    }

    private static int[] moveLeft(int[] snakePosition) {
        int row = snakePosition[0];
        int col = snakePosition[1] - 1;
        return new int[]{row, col};
    }

    private static int[] moveDown(int[] snakePosition) {
        int row = snakePosition[0] + 1;
        int col = snakePosition[1];
        return new int[]{row, col};
    }

    private static int[] moveUp(int[] snakePosition) {
        int row = snakePosition[0] - 1;
        int col = snakePosition[1];
        return new int[]{row, col};
    }

    private static boolean isSnakeInsideTheTerritory(int[] position, int territorySize) {
        return position[0] >= 0 && position[0] < territorySize
                && position[1] >= 0 && position[1] < territorySize;
    }
}