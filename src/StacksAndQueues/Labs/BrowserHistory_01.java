package StacksAndQueues.Labs;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String isItHome = sc.nextLine();
        ArrayDeque<String> stackURLs = new ArrayDeque<>();
        while (!isItHome.equalsIgnoreCase("Home")) {
            String currentURL = isItHome;
            if (!currentURL.equalsIgnoreCase("Back")) {
                System.out.println(currentURL);
                stackURLs.push(currentURL);
            } else {
                if (stackURLs.size() <= 1) {
                    System.out.println("no previous URLs");
                } else {
                    stackURLs.pop();
                    System.out.println(stackURLs.peek());
                }
            }
            isItHome = sc.nextLine();
        }
    }
}
