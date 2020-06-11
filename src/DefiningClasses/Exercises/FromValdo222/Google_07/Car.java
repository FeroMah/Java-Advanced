package DefiningClasses.Exercises.FromValdo222.Google_07;

class Car {
    private String carModel;
    private int carSpeed;

    Car(String carModel, int carSpeed) {
        this.carModel = carModel;
        this.carSpeed = carSpeed;
    }

    String getCarModel() {
        return carModel;
    }

    int getCarSpeed() {
        return carSpeed;
    }
}
