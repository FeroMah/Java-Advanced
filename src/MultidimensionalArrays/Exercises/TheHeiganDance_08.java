package MultidimensionalArrays.Exercises;

import java.util.Scanner;

public class TheHeiganDance_08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double playerDamage = Double.parseDouble(sc.nextLine());
        String[][] batteleField = new String[15][15];
        double playerHealth = 18500.0;
        double bossHealth = 3000000;
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                if (i == 7 && j == 7) {
                    batteleField[i][j] = "Player";
                } else batteleField[i][j] = "______";
                System.out.print(batteleField[i][j] + " ");
            }
            System.out.println();
        }

        while (playerHealth >= 0 && bossHealth >= 0) {
            bossHealth -= playerDamage;

            String[] inputData = sc.nextLine().split("\\s+");
            String spell = inputData[0];
            int rowDamage = Integer.parseInt(inputData[1]);
            int colDamage = Integer.parseInt(inputData[2]);

            switch (spell.toUpperCase()) {
                case "CLOUD":
                    if (rowDamage - 1 >= 0 && rowDamage - 1 < 15) {
                        if (colDamage - 1 >= 0 && colDamage - 1 < 15) {
                            batteleField[rowDamage - 1][colDamage - 1] = "Cloud 2";
                        }
                        if (colDamage >= 0 && colDamage - 1 < 15) {
                            batteleField[rowDamage - 1][colDamage] = "Cloud 2";
                        }
                        if (colDamage + 1 >= 0 && colDamage - 1 < 15) {
                            batteleField[rowDamage - 1][colDamage + 1] = "Cloud 2";
                        }
                    }

                    if (rowDamage + 1 >= 0 && rowDamage + 1 < 15){
                        if (colDamage + 1 >= 0 && colDamage - 1 < 15) {
                            batteleField[rowDamage - 1][colDamage - 1] = "Cloud 2";
                        }
                        if (colDamage >= 0 && colDamage - 1 < 15) {
                            batteleField[rowDamage + 1][colDamage] = "Cloud 2";
                        }
                        if (colDamage + 1 >= 0 && colDamage - 1 < 15) {
                            batteleField[rowDamage + 1][colDamage + 1] = "Cloud 2";
                        }
                    }
                    break;
                case "ERUPTION":
                    break;
            }
            for (int i = 0; i < 15; i++) {
                for (int j = 0; j < 15; j++) {
                    System.out.print(batteleField[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

}
