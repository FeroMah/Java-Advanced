package Exam.Exam_23_6_2019_JavaAdvance.Task02_SpaceStationEstablishment;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int matrixSize = Integer.parseInt(sc.nextLine());
        char[][] galaxy = new char[matrixSize][matrixSize];
        int[] shipPosition = new int[2];
        int[] blackHole1 = new int[2];
        int[] blackHole2 = new int[2];
        int collectedStarsCount = 0;
        boolean foundBlackHole = false;
        for (int i = 0; i < matrixSize; i++) {
            String inputLine = sc.nextLine();
            for (int j = 0; j < inputLine.length(); j++) {
                galaxy[i][j] = inputLine.charAt(j);
                if (inputLine.charAt(j) == 'S') {
                    shipPosition[0] = i;
                    shipPosition[1] = j;
                }
                if (inputLine.charAt(j) == 'O' && !foundBlackHole) {
                    blackHole1[0] = i;
                    blackHole1[1] = j;
                    foundBlackHole = true;
                }
                if (inputLine.charAt(j) == 'O' && foundBlackHole) {
                    blackHole2[0] = i;
                    blackHole2[1] = j;
                }
//                System.out.print(galaxy[i][j]);       FOR TESTING!
            }
//            System.out.println();                     FOR TESTING!
        }

        String commandDirection;
        boolean wentToVoid = false;
        while (true) {
            commandDirection = sc.nextLine().toLowerCase();

            switch (commandDirection) {
                case "up":
                    if (isInGalaxy(shipPosition[0] - 1, shipPosition[1], matrixSize)) {
                        galaxy[shipPosition[0]][shipPosition[1]] = '-';
                        if (isItAStar(shipPosition[0] - 1, shipPosition[1], galaxy)) {
                            collectedStarsCount += Integer.parseInt(String.valueOf(galaxy[shipPosition[0] - 1][shipPosition[1]]));
                            shipPosition[0] -= 1;
                            galaxy[shipPosition[0]][shipPosition[1]] = '-';
                        } else if (galaxy[shipPosition[0] - 1][shipPosition[1]] == 'O') {
                            if (blackHole1[0] == shipPosition[0] - 1 && blackHole1[1] == shipPosition[1]) {
                                galaxy[blackHole1[0]][blackHole1[1]] = '-';
                                shipPosition[0] = blackHole2[0];
                                shipPosition[1] = blackHole2[1];
                            } else {
                                galaxy[blackHole2[0]][blackHole2[1]] = '-';
                                shipPosition[0] = blackHole1[0];
                                shipPosition[1] = blackHole1[1];
                            }
                        }
                        galaxy[shipPosition[0]][shipPosition[1]] = 'S';
                    } else {
                        galaxy[shipPosition[0]][shipPosition[1]] = '-';
                        shipPosition[0] = shipPosition[0] - 1;
                    }
                    galaxy[shipPosition[0]][shipPosition[1]] = '-';
                    break;
                case "down":
                    if (isInGalaxy(shipPosition[0] + 1, shipPosition[1], matrixSize)) {
                        galaxy[shipPosition[0]][shipPosition[1]] = '-';
                        if (isItAStar(shipPosition[0] + 1, shipPosition[1], galaxy)) {
                            collectedStarsCount += Integer.parseInt(String.valueOf(galaxy[shipPosition[0] + 1][shipPosition[1]]));
                            shipPosition[0] += 1;
                            galaxy[shipPosition[0]][shipPosition[1]] = '-';
                        } else if (galaxy[shipPosition[0] + 1][shipPosition[1]] == 'O') {
                            if (blackHole1[0] == shipPosition[0] + 1 && blackHole1[1] == shipPosition[1]) {
                                galaxy[blackHole1[0]][blackHole1[1]] = '-';
                                shipPosition[0] = blackHole2[0];
                                shipPosition[1] = blackHole2[1];
                            } else {
                                galaxy[blackHole2[0]][blackHole2[1]] = '-';
                                shipPosition[0] = blackHole1[0];
                                shipPosition[1] = blackHole1[1];
                            }
                        }
                        galaxy[shipPosition[0]][shipPosition[1]] = 'S';
                    } else {
                        galaxy[shipPosition[0]][shipPosition[1]] = '-';
                        shipPosition[0] = shipPosition[0] - 1;
                    }
                    galaxy[shipPosition[0]][shipPosition[1]] = '-';
                    break;
                case "left":
                    if (isInGalaxy(shipPosition[0], shipPosition[1] - 1, matrixSize)) {
                        galaxy[shipPosition[0]][shipPosition[1]] = '-';
                        if (isItAStar(shipPosition[0], shipPosition[1] - 1, galaxy)) {
                            collectedStarsCount += Integer.parseInt(String.valueOf(galaxy[shipPosition[0]][shipPosition[1] - 1]));
                            shipPosition[1] -= 1;
                            galaxy[shipPosition[0]][shipPosition[1]] = '-';
                        } else if (galaxy[shipPosition[0]][shipPosition[1] - 1] == 'O') {
                            if (blackHole1[0] == shipPosition[0] && blackHole1[1] == shipPosition[1] - 1) {
                                galaxy[blackHole1[0]][blackHole1[1]] = '-';
                                shipPosition[0] = blackHole2[0];
                                shipPosition[1] = blackHole2[1];
                            } else {
                                galaxy[blackHole2[0]][blackHole2[1]] = '-';
                                shipPosition[0] = blackHole1[0];
                                shipPosition[1] = blackHole1[1];
                            }
                        }
                        galaxy[shipPosition[0]][shipPosition[1]] = 'S';
                    } else {
                        galaxy[shipPosition[0]][shipPosition[1]] = '-';
                        shipPosition[0] = shipPosition[0] - 1;
                    }
                    galaxy[shipPosition[0]][shipPosition[1]] = '-';
                    break;
                case "right":
                    if (isInGalaxy(shipPosition[0], shipPosition[1] + 1, matrixSize)) {
                        galaxy[shipPosition[0]][shipPosition[1]] = '-';
                        if (isItAStar(shipPosition[0], shipPosition[1] + 1, galaxy)) {
                            collectedStarsCount += Integer.parseInt(String.valueOf(galaxy[shipPosition[0]][shipPosition[1] + 1]));
                            shipPosition[1] += 1;
                            galaxy[shipPosition[0]][shipPosition[1]] = '-';
                        } else if (galaxy[shipPosition[0]][shipPosition[1] + 1] == 'O') {
                            if (blackHole1[0] == shipPosition[0] && blackHole1[1] == shipPosition[1] + 1) {
                                galaxy[blackHole1[0]][blackHole1[1]] = '-';
                                shipPosition[0] = blackHole2[0];
                                shipPosition[1] = blackHole2[1];
                            } else {
                                galaxy[blackHole2[0]][blackHole2[1]] = '-';
                                shipPosition[0] = blackHole1[0];
                                shipPosition[1] = blackHole1[1];
                            }
                        }
                        galaxy[shipPosition[0]][shipPosition[1]] = 'S';
                    } else {
                        galaxy[shipPosition[0]][shipPosition[1]] = '-';
                        shipPosition[0] = shipPosition[0] - 1;
                    }
                    galaxy[shipPosition[0]][shipPosition[1]] = '-';
                    break;
            }
            printGalaxy(galaxy);  // FOR tESTING!
            if (hasEoughtStars(collectedStarsCount)) {
                System.out.println("Good news! Stephen succeeded in collecting enough star power!");
                System.out.println(String.format("Star power collected: %d", collectedStarsCount));
                printGalaxy(galaxy);
                break;
            }
            if (!isInGalaxy(shipPosition[0], shipPosition[1], matrixSize)) {
                System.out.println("Bad news, the spaceship went to the void.");
                printGalaxy(galaxy);
                break;
            }
        }
    }

    private static boolean isItAStar(int row, int col, char[][] galaxy) {
        return Character.isDigit(galaxy[row][col]);
    }

    private static void printGalaxy(char[][] galaxy) {
        for (int i = 0; i < galaxy.length; i++) {
            for (int j = 0; j < galaxy[i].length; j++) {
                System.out.print(galaxy[i][j]);
            }
            System.out.println();
        }
    }

    public static boolean isInGalaxy(int row, int col, int matrixSize) {
        return (row >= 0 && row < matrixSize - 1 && col >= 0 && col < matrixSize - 1);
    }

    public static boolean hasEoughtStars(int collectedStarsCount) {
        return collectedStarsCount >= 50;
    }
}

