package DefiningClasses.Exercises.RawData_04;

 class Tire {
    private double pressure;
    private int age;

      Tire(double pressure, int age) {
         this.pressure = pressure;
         this.age = age;
     }

      double getPressure() {
         return pressure;
     }

     public int getAge() {
         return age;
     }

 }
