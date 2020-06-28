package SetsAndMapsAdvanced.Exercises;

import java.util.*;

public class PeriodicTable_03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberLineInput = Integer.parseInt(sc.nextLine());
        Set<String> uniqueElements = new HashSet<>();
        for (int i = 0; i < numberLineInput; i++) {
            String[] input = sc.nextLine().split("\\s+");
            {
                for (int j = 0; j < input.length; j++) {
                    uniqueElements.add(input[j]);
                }
//                can be replaced with code below !!!!!
//                uniqueElements.addAll(Arrays.asList(input));

            }
        }
        uniqueElements.stream().sorted().forEach(e -> System.out.print(e + " "));
    }
}
