package ExamPreparation.PractisExam.Exam2.Task02_TronRacer;

import java.util.Scanner;

public class TronRacer {
    private static int sizeMatrix;
    private static char[][] matrix;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sizeMatrix = Integer.parseInt(sc.nextLine());
        matrix = new char[sizeMatrix][sizeMatrix];
        int[] lastPositionFirst = new int[2];
        int[] lastPositionSecond = new int[2];
        for (int row = 0; row < matrix.length; row++) {
            char[] inputRow = sc.nextLine().toCharArray();
            for (int i = 0; i < inputRow.length; i++) {
                matrix[row][i] = inputRow[i];
                if (matrix[row][i] == 'f') {
                    lastPositionFirst[0] = row;
                    lastPositionFirst[1] = i;
                }
                if (matrix[row][i] == 's') {
                    lastPositionSecond[0] = row;
                    lastPositionSecond[1] = i;
                }
            }
        }
        String[] commandInput;
        boolean isDeadFirst = false;
        boolean isDeadSecond = false;
        while (true) {
            commandInput = sc.nextLine().split("\\s+");
            String firstMove = commandInput[0];
            String secondMove = commandInput[1];
            int newPositionRowFirst;
            int newPositionRowSecond;
            int newPositionColumnFirst;
            int newPositionColumnSecond;
            switch (firstMove) {
                case "up":
                    newPositionRowFirst = moveUP(lastPositionFirst);
                    if (matrix[newPositionRowFirst][lastPositionFirst[1]] == 's') {
                        matrix[newPositionRowFirst][lastPositionFirst[1]] = 'x';
                        isDeadFirst = true;
                    } else {
                        lastPositionFirst[0] = newPositionRowFirst;
                        matrix[lastPositionFirst[0]][lastPositionFirst[1]] = 'f';
                    }
                    break;
                case "down":
                    newPositionRowFirst = moveDOWN(lastPositionFirst);
                    if (matrix[newPositionRowFirst][lastPositionFirst[1]] == 's') {
                        matrix[newPositionRowFirst][lastPositionFirst[1]] = 'x';
                        isDeadFirst = true;
                    } else {
                        lastPositionFirst[0] = newPositionRowFirst;
                        matrix[lastPositionFirst[0]][lastPositionFirst[1]] = 'f';
                    }
                    break;
                case "left":
                    newPositionColumnFirst = moveLEFT(lastPositionFirst);
                    if (matrix[lastPositionFirst[0]][newPositionColumnFirst] == 's') {
                        matrix[lastPositionFirst[0]][newPositionColumnFirst] = 'x';
                        isDeadFirst = true;
                    } else {
                        lastPositionFirst[1] = newPositionColumnFirst;
                        matrix[lastPositionFirst[0]][lastPositionFirst[1]] = 'f';
                    }

                    break;
                case "right":
                    newPositionColumnFirst = moveRIGHT(lastPositionFirst);
                    if (matrix[lastPositionFirst[0]][newPositionColumnFirst] == 's') {
                        matrix[lastPositionFirst[0]][newPositionColumnFirst] = 'x';
                        isDeadFirst = true;
                    } else {
                        lastPositionFirst[1] = newPositionColumnFirst;
                        matrix[lastPositionFirst[0]][lastPositionFirst[1]] = 'f';

                    }
                    break;
            }
            if (isDeadFirst) {
                printMatrix();
                return;
            }
            switch (secondMove) {
                case "up":
                    newPositionRowSecond = moveUP(lastPositionSecond);
                    if (matrix[newPositionRowSecond][lastPositionSecond[1]] == 'f') {
                        matrix[newPositionRowSecond][lastPositionSecond[1]] = 'x';
                        isDeadSecond = true;
                    } else {
                        lastPositionSecond[0] = newPositionRowSecond;
                        matrix[lastPositionSecond[0]][lastPositionSecond[1]] = 's';
                    }
                    break;
                case "down":
                    newPositionRowSecond = moveDOWN(lastPositionSecond);
                    if (matrix[newPositionRowSecond][lastPositionSecond[1]] == 'f') {
                        matrix[newPositionRowSecond][lastPositionSecond[1]] = 'x';
                        isDeadSecond = true;
                    } else {
                        lastPositionSecond[0] = newPositionRowSecond;
                        matrix[lastPositionSecond[0]][lastPositionSecond[1]] = 's';
                    }
                    break;
                case "left":
                    newPositionColumnSecond = moveLEFT(lastPositionSecond);
                    if (matrix[lastPositionSecond[0]][newPositionColumnSecond] == 'f') {
                        matrix[lastPositionSecond[0]][newPositionColumnSecond] = 'x';
                        isDeadSecond = true;
                    } else {
                        lastPositionSecond[1] = newPositionColumnSecond;
                        matrix[lastPositionSecond[0]][lastPositionSecond[1]] = 's';
                    }
                    break;
                case "right":
                    newPositionColumnSecond = moveRIGHT(lastPositionSecond);
                    if (matrix[lastPositionSecond[0]][newPositionColumnSecond] == 'f') {
                        matrix[lastPositionSecond[0]][newPositionColumnSecond] = 'x';
                        isDeadSecond = true;
                    } else {
                        lastPositionSecond[1] = newPositionColumnSecond;
                        matrix[lastPositionSecond[0]][lastPositionSecond[1]] = 's';
                    }
                    break;
            }
//            printMatrix();   FOR TESTING!!!
//            System.out.println();
//            System.out.println("-------------------------------------");
//            System.out.println();
            if (isDeadSecond) {
                printMatrix();
                return;
            }

        }
    }

    private static int moveRIGHT(int[] lastPosition) {
        int newPositionColumn;
        newPositionColumn = lastPosition[1] + 1;
        if (!isInRange(newPositionColumn)) {
            newPositionColumn = alwaysInRange(newPositionColumn);
        }
        return newPositionColumn;
    }

    private static int moveLEFT(int[] lastPosition) {
        int newPositionColumn;
        newPositionColumn = lastPosition[1] - 1;
        if (!isInRange(newPositionColumn)) {
            newPositionColumn = alwaysInRange(newPositionColumn);
        }
        return newPositionColumn;
    }

    private static int moveDOWN(int[] lastPosition) {
        int newPositionRow;
        newPositionRow = lastPosition[0] + 1;
        if (!isInRange(newPositionRow)) {
            newPositionRow = alwaysInRange(newPositionRow);
        }
        return newPositionRow;
    }

    private static int moveUP(int[] lastPosition) {
        int newPositionRow;
        newPositionRow = lastPosition[0] - 1;
        if (!isInRange(newPositionRow)) {
            newPositionRow = alwaysInRange(newPositionRow);
        }
        return newPositionRow;
    }

    private static int alwaysInRange(int newPosition) {
        if (newPosition >= sizeMatrix) {
            newPosition -= sizeMatrix;
        } else if (newPosition < 0) {
            newPosition += sizeMatrix;
        }
        return newPosition;
    }

    private static boolean isInRange(int newPosition) {
        return (newPosition >= 0 && newPosition < sizeMatrix);
    }

    private static void printMatrix() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
