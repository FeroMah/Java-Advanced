package DefiningClasses.Exercises.RawData_04;

class Cargo {
    private int weight;
    private String type;


    Cargo(int weight, String type) {
        this.weight = weight;
        this.type = type;
    }

    int getWeight() {
        return weight;
    }

    String getType() {
        return type;
    }
}
