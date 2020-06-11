package DefiningClasses.Exercises.Google_07;

class Pokemon  {
    private static final String NO_INPUT_DATA = "";
    private String name = NO_INPUT_DATA;
    private String type = NO_INPUT_DATA;

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    String getType() {
        return type;
    }

     Pokemon(String name, String type) {
        this.name = name;
        this.type = type;
    }

}
