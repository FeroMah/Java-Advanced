package DefiningClasses.Exercises.FromValdo222.CarSalesman_05;

class Engine {
    private String model;
    private int power;
    private int displacement;
    private String efficiency;

    Engine(String model, int power) {
        this.model = model;
        this.power = power;
        this.displacement = -1;
        this.efficiency = "n/a";
    }

    Engine(String model, int power, int displacement) {
        this(model, power);
        this.displacement = displacement;
    }

    Engine(String model, int power, String efficiency) {
        this(model, power);
        this.efficiency = efficiency;
    }

    Engine(String model, int power, int displacement, String efficiency) {
        this(model, power, displacement);
        this.efficiency = efficiency;
    }

    String getModel() {
        return model;
    }

    int getPower() {
        return power;
    }

    int getDisplacement() {
        return displacement;
    }

    String getEfficiency() {
        return efficiency;
    }
}
