package FunctionalProgramming.Lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class FindEvenOrOdd_06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] inputRange = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        List<Integer> numbersList = new ArrayList<>();
        int countOfNumbers = inputRange[1] - inputRange[0];
        for (int i = 0; i <= countOfNumbers; i++) {
            numbersList.add(inputRange[0] + i);
        }
        String findType = sc.nextLine();
        Predicate<Integer> isEven = x -> x % 2 == 0;
        if (findType.equalsIgnoreCase("even")) {
            numbersList.forEach(e -> {
                if (isEven.test(e)) {
                    System.out.print(e + " ");
                }
            });
        } else {
            numbersList.forEach(e -> {
                if (!isEven.test(e)) {
                    System.out.print(e + " ");
                }
            });
        }
    }
}
