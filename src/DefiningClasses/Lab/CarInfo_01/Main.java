package DefiningClasses.Lab.CarInfo_01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberCars = Integer.parseInt(sc.nextLine());

        List<Car> showroom = new ArrayList<>();
        while (numberCars > 0) {
            String[] inputCar = sc.nextLine().split("\\s+");
            Car car = new Car();
            car.setMake(inputCar[0]);
            car.setModel(inputCar[1]);
            car.setHorsePower(Integer.parseInt(inputCar[2]));
            showroom.add(car);
            numberCars--;
        }
        showroom.forEach(car -> System.out.println(car.getInfo()));
    }
}

