package FunctionalProgramming.Exercises;

import java.util.*;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListOfPredicates_09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int endNumber = Integer.parseInt(sc.nextLine());
        List<Integer> numbers = new ArrayList<>();
        List<Integer> divisorsInput = Arrays.stream(sc.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        BiPredicate<Integer, Integer> isDividable = (num, divisor) -> num % divisor == 0;
        for (int i = 1; i <= endNumber; i++) {
            numbers.add(i);
            //  OR this  :    numbers = IntStream.rangeClosed(1, endNumber).boxed().collect(Collectors.toList());
        }
        while (!divisorsInput.isEmpty()) {
            int divisor = divisorsInput.get(0);
            List<Integer> newData = new ArrayList<>();
            for (Integer number : numbers) {
                if (isDividable.test(number, divisor)) {
                    newData.add(number);
                }
            }
            numbers = newData;
            divisorsInput.remove(divisorsInput.get(0));
        }
        String result = String.join(" ", numbers.toString()).replaceAll("[\\[\\],]", "");
        System.out.println(result);
    }
}