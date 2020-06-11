package DefiningClasses.Exercises.CompanyRoster_02;


import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = Integer.parseInt(sc.nextLine());

        Map<String, List<Employee>> departmentsMap = new HashMap<>();
        while (count > 0) {
            String[] inputConsole = sc.nextLine().split("\\s+");


            String name = inputConsole[0];
            double salary = Double.parseDouble(inputConsole[1]);
            String position = inputConsole[2];
            String department = inputConsole[3];
            Employee employee = new Employee(name, salary, position, department);
            if (inputConsole.length >= 5) {
                if (inputConsole[4].contains("@")) {
                    String email = inputConsole[4];
                    employee.setEmail(email);
                } else {
                    int age = Integer.parseInt(inputConsole[4]);
                    employee.setAge(age);
                }
                if (inputConsole.length == 6) {
                    int age = Integer.parseInt(inputConsole[5]);
                    employee.setAge(age);
                }
            }
            departmentsMap.putIfAbsent(employee.getDepartment(), new ArrayList<>());
            departmentsMap.get(employee.getDepartment()).add(employee);
            count--;
        }


        String highestDepartmentSalary = "";
        double highestSalary = Double.MIN_VALUE;
        for (
                Map.Entry<String, List<Employee>> department : departmentsMap.entrySet()) {
            double sum = 0.0;
            for (int i = 0; i < department.getValue().size(); i++) {
                sum += department.getValue().get(i).getSalary();
            }
            sum /= department.getValue().size();
            if (highestSalary < sum) {
                highestSalary = sum;
                highestDepartmentSalary = department.getKey();

            }
        }
        System.out.println(String.format("Highest Average Salary: %s", highestDepartmentSalary));
        departmentsMap.get(highestDepartmentSalary).

                sort((employee1, employee2) ->
                        Double.compare(employee2.getSalary(), employee1.getSalary()));
        departmentsMap.get(highestDepartmentSalary).

                forEach(employee ->
                        System.out.println(String.format("%s %.2f %s %d",
                                employee.getName(), employee.getSalary(), employee.getEmail(), employee.getAge())));
    }
}