package DefiningClasses.Exercises.FromValdo222.CarSalesman_05;


class Car {
    private String model;
    private Engine engine;
    private int weight;
    private String color;


    Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
        this.weight = -1;
        this.color = "n/a";
    }


    Car(String model, Engine engine, int weight, String color) {
        this(model, engine);
        this.weight = weight;
        this.color = color;
    }


    Car(String model, Engine engine, int weight) {
        this(model, engine);
        this.weight = weight;
    }


    Car(String model, Engine engine, String color) {
        this(model, engine);
        this.color = color;
    }


    void ToString() {


        System.out.println(this.model + ":");
        System.out.println(this.engine.getModel() + ":");
        System.out.println("Power: " + this.engine.getPower());
        System.out.println(this.engine.getDisplacement() == -1
                ? "Displacement: n/a"
                : "Displacement: " + this.engine.getDisplacement());
        System.out.println("Efficiency: " + this.engine.getEfficiency());
        System.out.println(this.weight == -1 ? "Weight: n/a" : "Weight: " + this.weight);
        System.out.println("Color: " + this.color);


    }
}
