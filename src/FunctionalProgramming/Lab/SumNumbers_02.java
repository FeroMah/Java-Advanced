package FunctionalProgramming.Lab;

import java.util.Scanner;
import java.util.function.Function;

public class SumNumbers_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] consoleInput = sc.nextLine().split(", ");

        System.out.println("Count = " + consoleInput.length);
        if (consoleInput.length < 2) {
            System.out.println("Sum = " + consoleInput[0]);
        } else {
            Function<String, Integer> parser = x -> Integer.parseInt(x);
            int sum = 0;
            for (String number : consoleInput) sum += parser.apply(number);
            System.out.println("Sum = "+ sum);
        }
    }
}
