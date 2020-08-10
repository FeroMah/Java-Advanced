package DefiningClasses.Exercises.SpeedRacing_04;

public class Car {
    private String model;
    private double fuelAmount;
    private final double fuelCostFor1km;
    private double traveledDistance;

    public Car(String model, double fuelAmount, double fuelCostFor1km) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostFor1km = fuelCostFor1km;
        this.traveledDistance = 0;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public double getFuelCostFor1km() {
        return fuelCostFor1km;
    }


    public double getTraveledDistance() {
        return traveledDistance;
    }

    public void setTraveledDistance(double traveledDistance) {
        this.traveledDistance = traveledDistance;
    }

    public void drive(double distance) {
        double fuelNeeded = distance * this.getFuelCostFor1km();

        if (fuelNeeded <= this.getFuelAmount()) {
            this.setFuelAmount(this.getFuelAmount() - fuelNeeded);
            this.setTraveledDistance(this.getTraveledDistance() + distance);
        } else System.out.println("Insufficient fuel for the drive");
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %.0f", this.getModel(), this.getFuelAmount(), this.getTraveledDistance());
    }
}
