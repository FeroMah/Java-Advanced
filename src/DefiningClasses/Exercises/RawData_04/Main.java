package DefiningClasses.Exercises.RawData_04;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfCars = Integer.parseInt(sc.nextLine());
        Map<String, Car> garage = new LinkedHashMap<>();
        while (numberOfCars > 0) {
//            "<Model> <EngineSpeed> <EnginePower>
//            <CargoWeight> <CargoType>
//            <Tire1Pressure> <Tire1Age> <Tire2Pressure> <Tire2Age>
//            <Tire3Pressure> <Tire3Age> <Tire4Pressure> <Tire4Age>"
            int nextIndex = 0; // to avoid hardcoding mistakes!!
            String[] inputData = sc.nextLine().split("\\s+");
            String model = inputData[nextIndex++];
            int engineSpeed = Integer.parseInt(inputData[nextIndex++]);
            int enginePower = Integer.parseInt(inputData[nextIndex++]);
            int cargoWeight = Integer.parseInt(inputData[nextIndex++]);
            String cargoType = inputData[nextIndex++];
            double tire1Pressure = Double.parseDouble(inputData[nextIndex++]);
            int tire1Age = Integer.parseInt(inputData[nextIndex++]);
            double tire2Pressure = Double.parseDouble(inputData[nextIndex++]);
            int tire2Age = Integer.parseInt(inputData[nextIndex++]);
            double tire3Pressure = Double.parseDouble(inputData[nextIndex++]);
            int tire3Age = Integer.parseInt(inputData[nextIndex++]);
            double tire4Pressure = Double.parseDouble(inputData[nextIndex++]);
            int tire4Age = Integer.parseInt(inputData[nextIndex++]);
            Tire[] tires = new Tire[4];
            tires[0] = new Tire(tire1Pressure, tire1Age);
            tires[1] = new Tire(tire2Pressure, tire2Age);
            tires[2] = new Tire(tire3Pressure, tire3Age);
            tires[3] = new Tire(tire4Pressure, tire4Age);
            Car car = new Car(model, new Engine(engineSpeed, enginePower),
                    new Cargo(cargoWeight, cargoType), tires);
            garage.putIfAbsent(model, car);
            numberOfCars--;
        }
        String inputConsoleFilter = sc.nextLine();
        if ("fragile".equalsIgnoreCase(inputConsoleFilter)) {
            garage.values().forEach(car -> {
                if (car.getCargo().getType().equals("fragile")) {
                    for (int i = 0; i < car.getTires().length; i++) {
                        Tire checkedTire = car.getTires()[i];
                        if (isTireFlat(checkedTire.getPressure())) {
                            System.out.println(car.getModel());
                            break;
                        }
                    }

                }
            });
        } else if ("flamable".equalsIgnoreCase(inputConsoleFilter)) {
            garage.values().forEach(car -> {
                if (isEngineTooPowerful(car.getEngine().getPower())) {
                    System.out.println(car.getModel());
                }
            });
        }


    }

    static boolean isTireFlat(double pressure) {
        return pressure < 1;
    }
    static boolean isEngineTooPowerful(int enginePower){
        return enginePower>250;
    }
}