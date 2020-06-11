package FunctionalProgramming.Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindTheSmallestElement_07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> inputNumbers = Arrays.stream(sc.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        Function<List<Integer>, Integer> getSmallestNumberIndex = list -> {
            int smallestNumber = Integer.MAX_VALUE;
            int index = -1;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) <= smallestNumber) {
                    smallestNumber = list.get(i);
                    index = i;
                }
            }
            return  index;
        };
        System.out.println(getSmallestNumberIndex.apply(inputNumbers));
    }
}
