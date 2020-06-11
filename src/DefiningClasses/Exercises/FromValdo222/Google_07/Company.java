package DefiningClasses.Exercises.FromValdo222.Google_07;

 class Company {
    private String companyName;
    private String department;
    private double salary;


     Company(String companyName,String department, double salary) {
        this.companyName = companyName;
        this.department = department;
        this.salary = salary;
    }

     String getDepartment() {
        return department;
    }

     String getCompanyName() {
        return companyName;
    }

     double getSalary() {
        return salary;
    }
}

