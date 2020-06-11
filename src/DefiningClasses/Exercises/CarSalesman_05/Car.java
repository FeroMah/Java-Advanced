package DefiningClasses.Exercises.CarSalesman_05;

class Car {
    private static final String NO_INPUT_DATA = "n/a";
    private String model;
    private Engine engine;
    private String weight = NO_INPUT_DATA;
    private String color = NO_INPUT_DATA;


    void setCarModel(String model) {
        this.model = model;
    }


    void setCarEngine(Engine engine) {
        this.engine = engine;
    }


    void setCarWeight(String weight) {
        this.weight = weight;
    }


    void setCarColor(String color) {
        this.color = color;
    }

    void printCarInfo() {
        System.out.println(this.model + ":");
        System.out.println(this.engine.getEngineModel() + ":");
        System.out.println("Power: " + this.engine.getEnginePower());
        System.out.println("Displacement: " + this.engine.getEngineDisplacement());
        System.out.println("Efficiency: " + this.engine.getEngineEfficiency());
        System.out.println("Weight: " + this.weight);
        System.out.println("Color: " + this.color);
    }
}
