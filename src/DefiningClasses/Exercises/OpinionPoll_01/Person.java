package DefiningClasses.Exercises.OpinionPoll_01;

public class Person {
    private String name;
    private int age;

    String getName() {
        return name;
    }

     Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    int getAge() {
        return age;
    }


}
