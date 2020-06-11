package DefiningClasses.Exercises.OpinionPoll_01;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = Integer.parseInt(sc.nextLine());
        List<Person> candidates = new ArrayList<>();
        while (count != 0) {
            String[] inputConsole = sc.nextLine().split("\\s+");
            String name = inputConsole[0];
            int age = Integer.parseInt(inputConsole[1]);
            Person person = new Person(name, age);
            candidates.add(person);
            count--;
        }
        candidates.stream().filter(person -> person.getAge() > 30).
                sorted(Comparator.comparing(Person::getName)).       //OR  sorted((p1, p2) -> p1.getName().compareTo(p2.getName())).
                forEach(person -> System.out.println(String.format("%s - %d", person.getName(), person.getAge())));
    }
}
