package Exam.Exam_23_6_2019_JavaAdvance.Task02_SpaceStationEstablishment;

import java.util.Scanner;

public class MainV2 {
    private static char[][] galaxy;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = Integer.parseInt(sc.nextLine());
        galaxy = new char[size][size];
        int rowStef = -1, colStef = -1;
        int rowBlackHole1 = -1, colBlackHole1 = -1;
        int rowBlackHole2 = -1, colBlackHole2 = -1;
        char[] inputLine = new char[size];      // char [] initialize to limit size of the input to size of the galaxy;
        boolean hasBlackHoles = false;
        for (int i = 0; i < galaxy.length; i++) {
            inputLine = sc.nextLine().toCharArray();
            for (int j = 0; j < inputLine.length; j++) {
                galaxy[i][j] = inputLine[j];
                if (inputLine[j] == 'S') {
                    rowStef = i;
                    colStef = j;
                }
                if (inputLine[j] == 'O' && !hasBlackHoles) {
                    rowBlackHole1 = i;
                    colBlackHole1 = j;
                    hasBlackHoles = true;
                }
                if (inputLine[j] == 'O' && hasBlackHoles) {
                    rowBlackHole2 = i;
                    colBlackHole2 = j;
                }
            }
        }
        int collectedStars = 0;
        while (true) {
            String direction = sc.nextLine().toLowerCase();
            galaxy[rowStef][colStef] = '-';
            switch (direction) {
                case "up":
                    rowStef -= 1;
                    break;
                case "down":
                    rowStef += 1;
                    break;
                case "left":
                    colStef -= 1;
                    break;
                case "right":
                    colStef += 1;
                    break;
            }
            if (!isInGalaxy(rowStef, colStef)) {
                System.out.println("Bad news, the spaceship went to the void.");
                System.out.println(String.format("Star power collected: %d", collectedStars));
                break;
            }
            if (Character.isDigit(galaxy[rowStef][colStef])) {  //is it a star
                collectedStars += Integer.parseInt(String.valueOf(galaxy[rowStef][colStef]));
                if (collectedStars >= 50) {
                    System.out.println("Good news! Stephen succeeded in collecting enough star power!");
                    System.out.println(String.format("Star power collected: %d", collectedStars));
                    galaxy[rowStef][colStef] = 'S';        // last position of Stef when stars are collected;
                    break;
                }
            }
            if (galaxy[rowStef][colStef] == 'O') {
                galaxy[rowStef][colStef] = '-';
                if (rowStef == rowBlackHole1 && colStef == colBlackHole1) {
                    rowStef = rowBlackHole2;
                    colStef = colBlackHole2;
                } else {
                    rowStef = rowBlackHole1;
                    colStef = colBlackHole1;
                }
            }
            galaxy[rowStef][colStef] = 'S'; //Stef moved to this location;
//            System.out.println("||||||||||||||||||||||||"+collectedStars);        //For Testing!
        }
        printGalaxy();
    }

    private static boolean isInGalaxy(int row, int col) {
        return (row >= 0 && row < galaxy.length && col >= 0 && col < galaxy[row].length);
    }

    private static void printGalaxy() {
        for (int i = 0; i < galaxy.length; i++) {
            for (int j = 0; j < galaxy[i].length; j++) {
                System.out.print(galaxy[i][j]);
            }
            System.out.println();
        }
    }
}
