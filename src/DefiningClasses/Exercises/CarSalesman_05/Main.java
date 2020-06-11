package DefiningClasses.Exercises.CarSalesman_05;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfEngines = Integer.parseInt(sc.nextLine());
        Map<String,Engine> allEngines = new LinkedHashMap<>();
        for (int i = 0; i < numberOfEngines; i++) {
            Engine engine = new Engine();
            String[] inputEngineData = sc.nextLine().split("\\s+");
            String engineModel = inputEngineData[0];
            engine.setEngineModel(engineModel);
            String enginePower = inputEngineData[1];
            engine.setEnginePower(enginePower);
            if (inputEngineData.length == 3) {
                if (Character.isDigit(inputEngineData[2].charAt(0))) {
                    engine.setEngineDisplacement(inputEngineData[2]);
                } else engine.setEngineEfficiency(inputEngineData[2]);
                // could be efficiency and displacement swap!?
            }else if (inputEngineData.length==4){
                engine.setEngineDisplacement(inputEngineData[2]);
                engine.setEngineEfficiency(inputEngineData[3]);
            }
            allEngines.put(engineModel,engine);
        }
        List<Car> carsInTheStore = new ArrayList<>();
        int numberOfCars = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < numberOfCars; i++) {
            Car car = new Car();
            String [] inputCarData = sc.nextLine().split("\\s+");
            String carModel = inputCarData[0];
            car.setCarModel(carModel);
            String carEngine = inputCarData[1];
            if (allEngines.containsKey(carEngine)){
                car.setCarEngine(allEngines.get(carEngine));
            }
            if (inputCarData.length==3){
                if (Character.isDigit(inputCarData[2].charAt(0))){
                    car.setCarWeight(inputCarData[2]);
                }else car.setCarColor(inputCarData[2]);
            }else if (inputCarData.length==4){
                car.setCarWeight(inputCarData[2]);
                car.setCarColor(inputCarData[3]);
            }
            carsInTheStore.add(car);
        }
        carsInTheStore.forEach(Car::printCarInfo);
    }
}
