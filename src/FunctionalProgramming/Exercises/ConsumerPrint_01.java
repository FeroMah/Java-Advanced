package FunctionalProgramming.Exercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class ConsumerPrint_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split("\\s+");
        Consumer<String> consumerPrint = x-> System.out.println(x);
        Arrays.stream(input).forEach(consumerPrint);
    }
}
