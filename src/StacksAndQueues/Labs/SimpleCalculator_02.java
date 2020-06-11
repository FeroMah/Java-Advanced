package StacksAndQueues.Labs;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.Scanner;


public class SimpleCalculator_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] inputData = sc.nextLine().split("\\s+");
        Deque<String> stack = new ArrayDeque<>();

        Collections.addAll(stack, inputData);

        while (stack.size() > 1) {
            int first = Integer.parseInt(stack.pop());
            String sign = stack.pop();
            int second = Integer.parseInt(stack.pop());
            switch (sign) {
                case "-":
                    stack.push(String.valueOf(first - second));
                    break;
                case "+":
                    stack.push(String.valueOf(second + first));
                    break;
            }
        }
        System.out.println(stack.pop());
    }
}
