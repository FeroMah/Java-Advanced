package DefiningClasses.Exercises.CarSalesman_05;

class Engine {
    private static final String NO_INPUT_DATA = "n/a";
    private String model;
    private String power;
    private String displacement = NO_INPUT_DATA;
    private String efficiency = NO_INPUT_DATA;

    String getEngineModel() {
        return model;
    }

    void setEngineModel(String model) {
        this.model = model;
    }

    String getEnginePower() {
        return power;
    }

    void setEnginePower(String power) {
        this.power = power;
    }

    String getEngineDisplacement() {
        return displacement;
    }

    void setEngineDisplacement(String displacement) {
        this.displacement = displacement;
    }

    String getEngineEfficiency() {
        return efficiency;
    }

    void setEngineEfficiency(String efficiency) {
        this.efficiency = efficiency;
    }
}
