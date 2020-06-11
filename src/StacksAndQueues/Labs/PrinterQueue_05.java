package StacksAndQueues.Labs;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue_05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputLine = sc.nextLine();
        ArrayDeque<String> taskForPrintingQueue = new ArrayDeque<>();
        while (!inputLine.equalsIgnoreCase("print")) {
            String canceledTask = "";
            if (inputLine.equalsIgnoreCase("cancel")) {
                if (!taskForPrintingQueue.isEmpty()) {
                    canceledTask = taskForPrintingQueue.pollFirst();
                    System.out.println(String.format("Canceled %s", canceledTask));
                } else {
                    System.out.println("Printer is on standby");
                }
            } else {
                taskForPrintingQueue.offer(inputLine); // or taskForPrintingQueue.add(inputLine) can be used in this case!
            }
            inputLine = sc.nextLine();
        }
        while (!taskForPrintingQueue.isEmpty()) {
            System.out.println(taskForPrintingQueue.pollFirst());
        }
    }
}
