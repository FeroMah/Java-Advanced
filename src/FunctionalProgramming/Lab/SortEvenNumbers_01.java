package FunctionalProgramming.Lab;

import java.util.Arrays;

import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SortEvenNumbers_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] consoleInput = sc.nextLine().split(", ");
        Predicate<Integer> isEven = number -> number % 2 == 0;
        List<String> evenNumbers = Arrays.stream(consoleInput).map(Integer::parseInt).filter(isEven).map(String::valueOf).collect(Collectors.toList());
        String result= String.join(", ",evenNumbers);
        System.out.println(result);
        List<String> evenNumbersSorted = Arrays.stream(consoleInput).map(Integer::parseInt).filter(isEven).sorted(Integer::compareTo).map(String::valueOf).collect(Collectors.toList());
        String sortedResult = String.join(", ", evenNumbersSorted);
        System.out.println(sortedResult);
    }
}
