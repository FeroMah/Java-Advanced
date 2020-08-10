package DefiningClasses.Exercises.SpeedRacing_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numCars = Integer.parseInt(br.readLine());
        List<Car> carsList = new ArrayList<>(numCars);

        for (int i = 0; i < numCars; i++) {
            String[] info = br.readLine().split("\\s+");
            String model = info[0];
            double fuel = Double.parseDouble(info[1]);
            double fuelConsumption = Double.parseDouble(info[2]);
            Car car = new Car(model, fuel, fuelConsumption);
            carsList.add(car);
        }
        String input;
        while (!( input = br.readLine()).equals("End")) {
            String[] split = input.split("\\s+");

            if (split[0].equals("Drive")){
                Car carFound = carsList.stream()
                        .filter(c -> c.getModel().equals(split[1]))
                        .collect(Collectors.toList()).get(0);
                carFound.drive(Double.parseDouble(split[2]));
            }
        }
        carsList.forEach(car-> System.out.println(car.toString()));
    }
}
