package DefiningClasses.Exercises.Google_07;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Person> people = new HashMap<>();
        String inputLine;
        while (!"End".equalsIgnoreCase(inputLine = sc.nextLine())) {
            String[] personData = inputLine.split("\\s+");
            String personName = personData[0];
            Person person = new Person();
            if (!people.containsKey(personName)) {
                person.setName(personName);
                people.putIfAbsent(personName, person);
            } else {
                person = people.get(personName);
            }
            String subClassInput = personData[1];
            switch (subClassInput) {
                case "company":
                    String company = personData[2];
                    person.setCompany(company);
                    String department = personData[3];
                    person.setDepartment(department);
                    double salary = Double.parseDouble(personData[4]);
                    person.setSalary(salary);
                    break;
                case "pokemon":
                    String namePokemon = personData[2];
                    String type = personData[3];
                    Pokemon pokemon = new Pokemon(namePokemon, type);
                    person.addPokemon(pokemon);
                    break;
                case "parents":
                    String nameParent = personData[2];
                    String birthdayParent = personData[3];
                    Parent parent = new Parent(nameParent, birthdayParent);
                    person.addParent(parent);
                    break;
                case "children":
                    String nameChild = personData[2];
                    String birthdayChild = personData[3];
                    Child child = new Child(nameChild, birthdayChild);
                    person.addChild(child);
                    break;
                case "car":
                    String model = personData[2];
                    String speed = personData[3];
                    Car car = new Car(model, speed);
                    person.setCar(car);
                    break;
            }
            people.put(personName, person);
        }
        String displayName = sc.nextLine();
        if (!people.containsKey(displayName)) {
            Person pesrosn = new Person(displayName);
            people.put(displayName,pesrosn);
        }
        people.get(displayName).toPrintInfo();
    }
}
