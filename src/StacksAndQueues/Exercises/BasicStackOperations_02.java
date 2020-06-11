package StacksAndQueues.Exercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class BasicStackOperations_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] inputStackProperties = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int stackSizeNum = inputStackProperties[0];
        int countOfPops = inputStackProperties[1];
        int searchedNumber = inputStackProperties[2];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int[] numbInput = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < stackSizeNum; i++) {
            stack.push(numbInput[i]);
        }
        for (int i = 0; i < countOfPops; i++) {
            stack.pop();
        }
        if (stack.contains(searchedNumber)) {
            System.out.println("true");
        } else {
            int smallestNum = Integer.MAX_VALUE;
            if (stack.isEmpty()) {
                System.out.println('0');
            } else {
                while (!stack.isEmpty()) {
                    if (smallestNum > stack.peek()) {
                        smallestNum = stack.pop();
                    } else stack.pop();
                }
                System.out.println(smallestNum);
            }
        }
    }
}
