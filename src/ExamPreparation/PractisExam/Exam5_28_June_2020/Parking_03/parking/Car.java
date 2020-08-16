package ExamPreparation.PractisExam.Exam5_28_June_2020.Parking_03.parking;

public class Car {
    private String manufacturer;
    private String model;
    private int year;

    public Car(String manufacturer, String model, int year) {
        this.setManufacturer(manufacturer);
        this.setModel(model);
        this.setYear(year);
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return String.format("%s %s (%d)",this.getManufacturer(),this.getModel(),this.getYear());
    }
}
