package FunctionalProgramming.Exercises;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReverseAndExclude_05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> inputNumbers = Arrays.stream(sc.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        Integer divisionNumb = Integer.parseInt(sc.nextLine());
        Collections.reverse(inputNumbers);
        Predicate<Integer> isNotDivisable = e -> e % divisionNumb != 0;
        inputNumbers.forEach(e -> {
         if (  isNotDivisable.test(e)){
             System.out.print(e+ " ");
         }
        });
    }
}
