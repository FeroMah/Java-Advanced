package FunctionalProgramming.Exercises;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CustomComparator_08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(sc.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        Function<List<Integer>, String> getEvenNumbers = inputList -> {
            List<Integer> listOfEven = new ArrayList<>();
            for (Integer numb : inputList) {
                if (numb % 2 == 0) {
                    listOfEven.add(numb);
                }
            }
            Collections.sort(listOfEven);
            return String.join(" ", listOfEven.toString().replaceAll("[,\\[\\]]", ""));
        };
        Function<List<Integer>, String> getOddNumbers = inputList -> {
            List<Integer> listOfOdd = new ArrayList<>();
            for (Integer numb : inputList) {
                if (numb % 2 != 0) {
                    listOfOdd.add(numb);
                }
            }
            Collections.sort(listOfOdd);
            return String.join(" ", listOfOdd.toString().replaceAll("[,\\[\\]]", ""));
        };
        System.out.print(getEvenNumbers.apply(numbers) + " " + getOddNumbers.apply(numbers));
    }
}