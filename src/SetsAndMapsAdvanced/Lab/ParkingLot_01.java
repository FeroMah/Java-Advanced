package SetsAndMapsAdvanced.Lab;

import java.util.*;

public class ParkingLot_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputLine;
        HashSet<String> parkingArchive = new HashSet<>();
        while (!"End".equalsIgnoreCase(inputLine = sc.nextLine())) {
            String[] data = inputLine.split(", ");
            String command = data[0];
            String registrationPlate = data[1];
            if (command.equalsIgnoreCase("IN")){
                parkingArchive.add(registrationPlate);
            }else if (command.equalsIgnoreCase("OUT")){
                parkingArchive.remove(registrationPlate);
            }
        }
        if (!parkingArchive.isEmpty()){
            for (String carPlate : parkingArchive) {
                System.out.println(carPlate);
            }
        }else {
            System.out.println("Parking Lot is Empty");
        }
    }
}
