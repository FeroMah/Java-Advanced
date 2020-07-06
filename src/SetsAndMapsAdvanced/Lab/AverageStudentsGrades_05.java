package SetsAndMapsAdvanced.Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class AverageStudentsGrades_05 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, List<Double>> students = new TreeMap<>();

        int inputLines = Integer.parseInt(br.readLine());

        while (inputLines > 0) {
            String[] input = br.readLine().split("\\s+");
            String name = input[0];
            double grade = Double.parseDouble(input[1]);

            students.putIfAbsent(name, new ArrayList<Double>());
            students.get(name).add(grade);

            inputLines--;
        }

        final String studentString = "%s -> %s (avg: %.2f)";
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, List<Double>> student : students.entrySet()) {

            double avgGrades = student.getValue().stream()
                    .mapToDouble(x -> Double.parseDouble(x.toString()))
                    .average()
                    .getAsDouble();

            StringBuilder sbGrades = new StringBuilder();
            for (Double grade : student.getValue()) {
                sbGrades.append(String.format("%.2f ", grade));
            }

            sb.append(String.format(studentString
                    , student.getKey()
                    , sbGrades.toString().trim()
                    , avgGrades))
                    .append(System.lineSeparator());
        }
        System.out.println(sb.toString().trim());
    }
}
