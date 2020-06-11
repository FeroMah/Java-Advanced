package DefiningClasses.Exercises.Google_07;

class Child {
    private static final String NO_INPUT_DATA = "";
    private String name = NO_INPUT_DATA;
    private String birthday = NO_INPUT_DATA;

    Child() {
    }

    String getName() {
        return name;
    }

    Child(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    void setName(String name) {
        this.name = name;
    }

    String getBirthday() {
        return birthday;
    }

}
