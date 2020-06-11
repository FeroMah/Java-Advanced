package FunctionalProgramming.Exercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class PredicateForNames_06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int maxLength = Integer.parseInt(sc.nextLine());
        Predicate<String> isTooLong = e -> e.length() > maxLength;
        Arrays.stream(sc.nextLine().split("\\s+")).forEach(e -> {
            if (!isTooLong.test(e)) {
                System.out.println(e);
            }
        });
    }
}
