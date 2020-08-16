package ExamPreparation.PractisExam.Exam5_28_June_2020.Parking_03.parking;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;


public class Parking {
    private Collection<Car> data;
    private String type;
    private int capacity;

    public Parking(String type, int capacity) {
        this.data = new ArrayList<>();
        this.type = type;
        this.capacity = capacity;
    }

    private Collection<Car> getData() {
        return this.data;
    }

    private String getType() {
        return this.type;
    }

    private int getCapacity() {
        return this.capacity;
    }

    public void add(Car car) {
        if (this.getData().size() < this.getCapacity()) {
            this.data.add(car);
        }
    }

    public boolean remove(String manufacturer, String model) {
        return this.getData()
                .removeIf(c -> c.getManufacturer().equals(manufacturer)
                        && c.getModel().equals(model));
    }

    public Car getLatestCar(){
        return  this.data.stream()
                .max(Comparator.comparingInt(Car::getYear))
                .orElse(null);
    }

    public Car getCar(String manufacturer, String model){
        return this.data.stream()
                .filter(c -> c.getManufacturer().equals(manufacturer)
                && c.getModel().equals(model)).findFirst().orElse(null);
    }

    public int getCount(){
        return this.data.size();
    }


    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format( "The cars are parked in %s:",this.getType())).append(System.lineSeparator());
        this.getData().forEach(e->sb.append(e).append(System.lineSeparator()));
        return sb.toString().trim();
    }
}
