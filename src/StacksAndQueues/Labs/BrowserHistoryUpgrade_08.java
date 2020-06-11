package StacksAndQueues.Labs;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade_08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String isItHome = sc.nextLine();
        ArrayDeque<String> backURLs = new ArrayDeque<>();           // stack
        ArrayDeque<String> forwardURLs = new ArrayDeque<>();        // stack


        while (!isItHome.equalsIgnoreCase("Home")) {
            String currentURL = isItHome;
            switch (isItHome.toUpperCase()) {
                case "BACK":
                    if (backURLs.size() > 1) {
                        forwardURLs.push(backURLs.pop());
                        System.out.println(backURLs.peek());
                    } else {
                        System.out.println("no previous URLs");
                    }

                    break;
                case "FORWARD":
                    if (!forwardURLs.isEmpty()) {
                        backURLs.push(forwardURLs.peek());
                        System.out.println(forwardURLs.pop());
                    } else System.out.println("no next URLs");
                    break;
                default:
                    System.out.println(currentURL);
                    backURLs.push(currentURL);
                    forwardURLs.clear();
                    break;
            }
            isItHome = sc.nextLine();
        }
    }
}
