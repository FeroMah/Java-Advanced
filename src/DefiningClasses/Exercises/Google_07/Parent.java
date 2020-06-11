package DefiningClasses.Exercises.Google_07;

 class Parent {
    private static final String NO_INPUT_DATA = "";
    private String name = NO_INPUT_DATA;
    private String birthday = NO_INPUT_DATA;

     Parent() {
    }

      Parent(String name, String birthday) {
         this.name = name;
         this.birthday = birthday;
     }

     String getName() {
        return name;
    }

     void setName(String name) {
        this.name = name;
    }

     String getBirthday() {
        return birthday;
    }
}
