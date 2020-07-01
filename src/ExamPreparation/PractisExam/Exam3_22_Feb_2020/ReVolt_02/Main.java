package ExamPreparation.PractisExam.Exam3_22_Feb_2020.ReVolt_02;

import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int matrixSize =Integer.parseInt( sc.nextLine());
        int commandsCount = Integer.parseInt( sc.nextLine());

        int playerPosY=0;
        int playerPosX=0;

        String[][] matrix = new String [matrixSize] [matrixSize] ;

        for (int y = 0; y < matrixSize; y++) {
            String lineInput= sc.nextLine();
            for (int x = 0; x < matrix.length; x++) {
                String symbol= String.valueOf( lineInput.charAt(x));
                matrix[y][x] =  symbol;

                if (symbol.equals("f")){
                    playerPosY= y;
                    playerPosX= x;
                }
            }
        }

        while (true){

            if(commandsCount==0){
                System.out.println("Player lost!");
                break;
            }

            String command = sc.nextLine();

            int newPosY=playerPosY;
            int newPosX=playerPosX;

            matrix[playerPosY][playerPosX]="-";

            switch(command){
                case "down":
                    newPosY = playerPosY+1;

                    break;

                case "up":
                    newPosY = playerPosY-1;
                    break;

                case "left":
                    newPosX = playerPosX-1;
                    break;

                case "right":
                    newPosX = playerPosX+1;
                    break;
            }



            if( newPosX >= matrixSize ){
                newPosX -=matrixSize;
                playerPosX = newPosX;
            }if( newPosX < 0 ){
                newPosX +=matrixSize;
                playerPosX = newPosX;
            }

            if( newPosY >= matrixSize ){
                newPosY -=matrixSize;
                playerPosY = newPosY;
            }

            if( newPosY < 0 ){
                newPosY +=matrixSize;
                playerPosY = newPosY;
            }



            if (matrix[newPosY] [newPosX].equals("B")){

                switch(command){
                    case "down":
                        newPosY += 1;

                        break;

                    case "up":
                        newPosY -= 1;
                        break;

                    case "left":
                        newPosX -=1;
                        break;

                    case "right":
                        newPosX += 1;
                        break;

                }
                if( newPosX >= matrixSize ){
                    newPosX -=matrixSize;
                    playerPosX = newPosX;
                }if( newPosX < 0 ){
                    newPosX +=matrixSize;
                    playerPosX = newPosX;
                }

                if( newPosY >= matrixSize ){
                    newPosY -=matrixSize;
                    playerPosY = newPosY;
                }

                if( newPosY < 0 ){
                    newPosY +=matrixSize;
                    playerPosY = newPosY;
                }

            }else if (matrix[newPosY] [newPosX].equals("T")){
                newPosX = playerPosX;
                newPosY = playerPosY;
            }else if (matrix[newPosY] [newPosX].equals("F")){
                matrix[playerPosY][playerPosX] ="-";
                matrix[newPosY][newPosX]="f";
                System.out.println("Player won!");
                break;
            }
            matrix[playerPosY][playerPosX]="-";


            playerPosX = newPosX;
            playerPosY = newPosY;
            matrix[playerPosY][playerPosX]="f";

            commandsCount--;
        }

        printMatrix(matrix);

    }


    private static void printMatrix(String[][] matrix){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix.length; j++) {
                sb.append(matrix[i][j]);
            }
            sb.append(System.lineSeparator());

        }
        System.out.println(sb.toString().trim());

    }
}

