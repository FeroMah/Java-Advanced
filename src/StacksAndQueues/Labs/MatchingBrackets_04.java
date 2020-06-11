package StacksAndQueues.Labs;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets_04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        ArrayDeque<Integer> indexStack = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') {
//                Open bracket index
                indexStack.push(i);
            } else if (input.charAt(i) == ')') {
                int openBracket = indexStack.pop();
//                Close bracket index
                int closeBracket = i;
                String section = input.substring(openBracket, closeBracket + 1);
                System.out.println(section);
            }
        }
    }
}
