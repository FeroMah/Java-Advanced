package DefiningClasses.Exercises.Google_07;

import java.util.ArrayList;
import java.util.List;

class Person {
    private static final String NO_INPUT_DATA = "";
    private String name;
    private String company;
    private String department;
    private double salary = 0.0;
    private List<Pokemon> pokemons;
    private List<Parent> parents;
    private List<Child> children;
    private Car car;


    Person() {
        this.company = NO_INPUT_DATA;
        this.department = NO_INPUT_DATA;
        this.pokemons = new ArrayList<>();
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
        this.car = new Car();
    }

    Person(String name) {
        this.name = name;
        this.company = NO_INPUT_DATA;
        this.department = NO_INPUT_DATA;
        this.pokemons = new ArrayList<>();
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
        this.car = new Car();
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    String getCompany() {
        return company;
    }

    void setCompany(String company) {
        this.company = company;
    }

    String getDepartment() {
        return department;
    }

    void setDepartment(String department) {
        this.department = department;
    }

    double getSalary() {
        return salary;
    }

    void setSalary(double salary) {
        this.salary = salary;
    }

    List<Pokemon> getPokemons() {
        return pokemons;
    }

    void addPokemon(Pokemon pokemon) {
        this.pokemons.add(pokemon);
    }

    List<Parent> getParents() {
        return parents;
    }

    void addParent(Parent parent) {
        this.parents.add(parent);
    }

    List<Child> getChildren() {
        return children;
    }

    void addChild(Child child) {
        this.children.add(child);
    }

    Car getCar() {
        return car;
    }

    void setCar(Car car) {
        this.car = car;
    }

    String getCompanyInfo() {

        return String.format("%s %s %.2f", this.company, this.department, this.salary);

    }

    void toPrintInfo() {
        System.out.println(this.name);
        System.out.println("Company:");
        if (this.company.length()!=0) {
            System.out.println(getCompanyInfo());
        }
        System.out.println("Car:");
        if (this.car.getModel().length()!=0) {
            System.out.println(car.getModel() + " " + car.getSpeed());
        }
        System.out.println("Pokemon:");
        if (!this.pokemons.isEmpty()) {
            for (Pokemon pokemon : this.pokemons) {
                System.out.println(pokemon.getName() + " " + pokemon.getType());
            }
        }
        System.out.println("Parents:");
        if (!this.parents.isEmpty()) {
            for (Parent parent : this.parents) {
                System.out.println(parent.getName() + " " + parent.getBirthday());
            }
        }
        System.out.println("Children:");
        if (!this.children.isEmpty()) {
            for (Child child : this.children) {
                System.out.println(child.getName() + " " + child.getBirthday());
            }
        }
    }
}
