package DefiningClasses.Exercises.RawData_04;


public class Car {
//    model, engine, cargo,
    private String model;
    private Engine engine;
    private Cargo cargo;
    private Tire[] tires;

    public Car(String model, Engine engine, Cargo cargo, Tire[] tires) {
        this.model = model;
        setEngine(engine);
        setCargo(cargo);
        this.tires=tires;
    }


    void setEngine(Engine engine){
        this.engine=new Engine(engine.getSpeed(),engine.getPower());
    }
    void setCargo (Cargo cargo){
        this.cargo=new Cargo(cargo.getWeight(),cargo.getType());
    }

     String getModel() {
        return model;
    }

     Engine getEngine() {
        return engine;
    }

     Cargo getCargo() {
        return cargo;
    }

     Tire[] getTires() {
        return tires;
    }
}
