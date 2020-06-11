package StacksAndQueues.Exercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MaximumElement_03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfLines = Integer.parseInt(sc.nextLine());
        ArrayDeque<String> stackOfNumbers = new ArrayDeque<>();
        for (int i = 0; i < numberOfLines; i++) {
            long maxNumberToPrint = Long.MIN_VALUE; // Това къде трябва да е бе Феро! тук или на 11 ред преди fori Тъп си ей да знаеш!
            String[] consoleInput = (sc.nextLine().split("\\s+"));
            String operationCode = consoleInput[0];
            if (Integer.parseInt(operationCode) >= 1 && Integer.parseInt(operationCode) <= 3) {
                switch (operationCode) {
                    case "1":
                        String addElement = consoleInput[1];
                        stackOfNumbers.push(addElement);
                        break;
                    case "2":
                        if (!stackOfNumbers.isEmpty()) {
                            stackOfNumbers.pop();
                        }
                        break;
                    case "3":
                        if (!stackOfNumbers.isEmpty()) {
                            for (String numberStr : stackOfNumbers) {
                                long number = Long.parseLong(numberStr);
                                if (maxNumberToPrint < number) {
                                    maxNumberToPrint = number;
                                }
                            }
                            System.out.println(maxNumberToPrint);
                        } else {
                            System.out.println(0);
                        }
                        break;
                }
            }
        }
    }
}
