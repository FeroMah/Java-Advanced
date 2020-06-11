package DefiningClasses.Exercises.Google_07;

class Car {
    private static final String NO_INPUT_DATA = "";
    private String model;
    private String speed;

    Car() {
        this.model = NO_INPUT_DATA;
        this.speed = NO_INPUT_DATA;
    }

    String getModel() {
        return model;
    }

    void setModel(String model) {
        this.model = model;
    }

    String getSpeed() {
        return speed;
    }

     Car(String model, String speed) {
        this.model = model;
        this.speed = speed;
    }

}
