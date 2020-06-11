package DefiningClasses.Exercises.FromValdo222.RawData_04;

class Tire {

    private double Pressure;
    private int age;

    Tire(double pressure, int age) {
        Pressure = pressure;
        this.age = age;
    }

    double getPressure() {
        return Pressure;
    }
}
