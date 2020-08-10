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

        Boolean[][] parkingLot = new Boolean[dimensions[0]][dimensions[1]];

        for (int i = 0; i < parkingLot.length; i++) {
            parkingLot[i][0] = true;
        }

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

            if (parkingLot[spotRow][spotCol] == null) {
                parkingLot[spotRow][spotCol] = true; // car is parked at this spot
                int count = Math.abs(enteringRow - spotRow) + spotRow + 1;
                System.out.println(count);


            } else {
                int i = 1;
                while (true) {
                    int spotColToLeft = spotCol - i;
                    int spotColToRight = spotCol + i;

                    if (spotColToLeft <= 1 && spotColToRight >= parkingLot[0].length) {
                        System.out.println(String.format("Row %s full", spotRow));
                        break;
                    }

                    if (isValidIndex(dimensions, spotColToLeft) &&
                            parkingLot[spotRow][spotColToLeft] == null) {
                        parkingLot[spotRow][spotColToLeft] = true;
                        int count = Math.abs(enteringRow - spotRow) + spotColToLeft + 1;
                        System.out.println(count);
                        break;
                    } else if (isValidIndex(dimensions, spotColToRight) &&
                            parkingLot[spotRow][spotColToRight] == null) {
                        parkingLot[spotRow][spotColToRight] = true;
                        int count = Math.abs(enteringRow - spotRow) + spotColToRight + 1;
                        System.out.println(count);
                        break;
                    }
                    i++;
                }
            }
//            System.out.println(parkingLotToString(parkingLot));
            input = br.readLine().trim();
        }
    }

    private static boolean isValidIndex(int[] dimensions, int index) {
        return 0 < index && index < dimensions[1];
    }


    private static String parkingLotToString(Boolean[][] parkingLot) {
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
