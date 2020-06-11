package DefiningClasses.Exercises.FromValdo222.RawData_04;

class Cargo {
    private int weight;
    private String type;

    Cargo(int weight, String type) {
        this.weight = weight;
        this.type = type;
    }

    String getType() {
        return type;
    }
}
