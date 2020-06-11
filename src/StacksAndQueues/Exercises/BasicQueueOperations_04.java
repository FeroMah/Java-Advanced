package StacksAndQueues.Exercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class BasicQueueOperations_04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] inputQueueProperties = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int queueSizeNum = inputQueueProperties[0];
        int countOfPolls = inputQueueProperties[1];
        int searchedNumber = inputQueueProperties[2];
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int[] numbInput = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < queueSizeNum; i++) {
            queue.add(numbInput[i]);
        }
        for (int i = 0; i < countOfPolls; i++) {
            queue.poll();
        }
        if (queue.contains(searchedNumber)) {
            System.out.println("true");
        } else {
            int smallestNum = Integer.MAX_VALUE;
            if (queue.isEmpty()) {
                System.out.println('0');
            } else {
                while (!queue.isEmpty()) {
                    if (smallestNum > queue.peek()) {
                        smallestNum = queue.poll();
                    } else queue.poll();
                }
                System.out.println(smallestNum);
            }
        }
    }
}