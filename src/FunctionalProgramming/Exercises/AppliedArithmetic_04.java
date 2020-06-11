package FunctionalProgramming.Exercises;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AppliedArithmetic_04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(sc.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        String input;
        while (!"end".equalsIgnoreCase(input = sc.nextLine())) {

            switch (input.toUpperCase()) {
                case "ADD":
                    Function<Integer, Integer> increaseBy1 = e -> e = e + 1;
                    for (int i = 0; i < numbers.size(); i++) {
                        numbers.set(i, increaseBy1.apply(numbers.get(i)));
                    }
                    break;
                case "SUBTRACT":
                    Function<Integer, Integer> decreaseBy1 = e -> e = e - 1;
                    for (int i = 0; i < numbers.size(); i++) {
                        numbers.set(i, decreaseBy1.apply(numbers.get(i)));
                    }
                    break;
                case "MULTIPLY":
                    Function<Integer, Integer> multiplyBy2 = e -> e = e * 2;
                    for (int i = 0; i < numbers.size(); i++) {
                        numbers.set(i, multiplyBy2.apply(numbers.get(i)));
                    }
                    break;
                case "PRINT":
                    Consumer<List<Integer>> printTheNumbers = list -> {
                        StringBuilder result = new StringBuilder();
                        for (Integer num : list) {
                            result.append(num).append(" ");
                        }
                        result = new StringBuilder(result.toString().trim());
                        System.out.println(result);
                    };
                    printTheNumbers.accept(numbers);
                    break;
            }
        }
    }
}
