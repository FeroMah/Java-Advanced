package DefiningClasses.Lab.CarInfo_01;

class Car {
    private String make;
    private String model;
    private int horsePower;


    String getMake() {
        return make;
    }

    void setMake(String make) {
        this.make = make;
    }

    String getModel() {
        return model;
    }

    void setModel(String model) {
        this.model = model;
    }

    int getHorsePower() {
        return horsePower;
    }

    void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    String getInfo() {
        return String.format("The car is: %s %s - %d HP.",
                this.make, this.model, this.horsePower);
    }
}
