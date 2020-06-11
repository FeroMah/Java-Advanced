package DefiningClasses.Exercises.CompanyRoster_02;

class Employee {
    private static final String DEFAULT_EMAIL = "n/a";
    private static final int DEFAULT_AGE = -1;
    private String name;
    private double salary;
    private String position;
    private String department;
    private String email = DEFAULT_EMAIL;
    private int age = DEFAULT_AGE;

    Employee(String name, double salary, String position, String department) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
    }


    void setEmail(String email) {
        this.email = email;
    }

    void setAge(int age) {
        this.age = age;
    }

    String getName() {
        return name;
    }

    double getSalary() {
        return salary;
    }


    String getDepartment() {
        return department;
    }

    String getEmail() {
        return email;
    }

    int getAge() {
        return age;
    }
}
