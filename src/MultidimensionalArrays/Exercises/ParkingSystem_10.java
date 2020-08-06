package MultidimensionalArrays.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ParkingSystem_10 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //parking lot dimensions
        int[] dimensions = Arrays.stream(br.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .limit(2).toArray();

        String[][] parkingLot = new String[dimensions[0]][dimensions[1]];

        fillCellsWithStrings(parkingLot);

        String input = br.readLine().trim();
        while (true) {

            if ("stop".equals(input)) {
                return;
            }

            int[] params = Arrays.stream(input.split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
            int enteringRow = params[0];
            int spotRow = params[1];
            int spotCol = params[2];

            if (parkingLot[spotRow][spotCol].equals("Free")) {
                parkingLot[spotRow][spotCol] = "Busy"; // car is parked at this spot
                int count = Math.abs(enteringRow - spotRow) + spotRow + 1;
                System.out.println(count);


            } else {

                for (int i = 1; i < parkingLot.length; i++) {
                    int spotColToLeft = spotCol - i;
                    int spotColToRight = spotCol + i;

                    if(spotColToLeft<=0 && spotColToRight>=parkingLot[0].length){
                        System.out.println(String.format("Row %s full%n", spotRow));
                        break;
                    }

                    if (isValidIndex(dimensions, spotColToLeft) &&
                            "Free".equals(parkingLot[spotRow][spotColToLeft])) {
                        parkingLot[spotRow][spotColToLeft] = "Busy";
                        int count = Math.abs(enteringRow - spotRow) + spotColToLeft + 1;
                        System.out.println(count);
                        break;
                    } else if (isValidIndex(dimensions, spotColToRight) &&
                            "Free".equals(parkingLot[spotRow][spotColToRight])) {
                        parkingLot[spotRow][spotColToRight] = "Busy";
                        int count = Math.abs(enteringRow - spotRow) + spotColToRight + 1;
                        System.out.println(count);
                        break;
                    }
                }
            }

            input = br.readLine().trim();
        }
    }

    private static boolean isValidIndex(int[] dimensions, int index) {
        return 0 < index && index < dimensions[1];
    }


    private static void fillCellsWithStrings(String[][] parkingLot) {
        for (int row = 0; row < parkingLot.length; row++) {
            for (int col = 0; col < parkingLot[row].length; col++) {
                // fill first column with String 'Road' ; no car can park there
                if (col == 0) {
                    parkingLot[row][0] = "Road";
                } else
                    // fill all other cells with 'Free';
                    parkingLot[row][col] = "Free";
            }
        }
    }

    private static String print(String[][] parkingLot) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < parkingLot.length; i++) {
            for (int j = 0; j < parkingLot[i].length; j++) {
                sb.append(parkingLot[i][j]).append(" ");
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
