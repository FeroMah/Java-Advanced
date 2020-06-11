package FunctionalProgramming.Exercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class CustomMinFunction_03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] input = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        Function<int[], Integer> getMinNumber = number -> {
            int minNum = Integer.MAX_VALUE;
            for (int i = 0; i < number.length; i++) {
                if (number[i] < minNum) {
                    minNum = number[i];
                }
            }
            return minNum;
        };
        System.out.println(getMinNumber.apply(input));
    }
}
