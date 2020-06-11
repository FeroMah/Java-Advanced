package StacksAndQueues.Labs;

import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinaryConverter_03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputDigit = Integer.valueOf(sc.nextLine());

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        if (inputDigit == 0) {
            System.out.println("0");
            return;
        }
        while (inputDigit != 0) {
            stack.push(inputDigit % 2);
            inputDigit /= 2;
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }
}
