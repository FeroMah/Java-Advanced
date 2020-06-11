package StacksAndQueues.Exercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class ReverseNumbersWithStack_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split("\\s+");
        ArrayDeque<String> stackOfInput = new ArrayDeque<>();
        for (int i = 0; i < input.length; i++) {
            stackOfInput.push(input[i]);
        }

        while (!stackOfInput.isEmpty()) {
            if (stackOfInput.size() == 1) {
                System.out.print(stackOfInput.pop());
                break;
            }
            System.out.print(stackOfInput.pop() + " ");
        }
    }
}
