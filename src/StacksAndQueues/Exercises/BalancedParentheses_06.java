package StacksAndQueues.Exercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses_06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputConsole = sc.nextLine();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        boolean areBalanced = false;

        for (int i = 0; i < inputConsole.length(); i++) {
            char currentBracket = inputConsole.charAt(i);
            if (isOpen(currentBracket)) {
                stack.push(currentBracket);
            } else {
                if (!stack.isEmpty()) {
                    switch (currentBracket) {
                        case '}':
                            if (stack.pop() == '{') {
                                areBalanced = true;
                            }
                            break;
                        case ')':
                            if (stack.pop() == '(') {
                                areBalanced = true;
                            }
                            break;
                        case ']':
                            if (stack.pop() == '[') {
                                areBalanced = true;
                            }
                            break;
                        default:
                            continue;
                    }
                }else {
                    System.out.println("NO");
                    return;
                }
                if (!areBalanced) {
                    System.out.println("NO");
                    return;
                }
            }
        }
        if (areBalanced) {
            System.out.println("YES");
        }
    }

    private static boolean isOpen(char bracket) {
        boolean open = false;
        switch (bracket) {
            case '{':
            case '(':
            case '[':
                open = true;
                break;
            default:
                break;
        }
        return open;
    }
}