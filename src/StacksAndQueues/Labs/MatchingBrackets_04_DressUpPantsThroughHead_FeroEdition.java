package StacksAndQueues.Labs;

import java.util.ArrayDeque;
import java.util.Scanner;
// Does Not work!! 60/100 judge
public class MatchingBrackets_04_DressUpPantsThroughHead_FeroEdition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        ArrayDeque<String> resultStack = new ArrayDeque<>();

        while (input.contains("(")) {
            int openBracket = 0;
            int closeBracket = 0;
            boolean closeBracketFound = false;
            for (int i = 0; i < input.length(); i++) {
                if (closeBracketFound) {
                    break;
                }
                if (input.charAt(i) == '(') {
                    openBracket = i;
                    for (int j = openBracket + 1; j < input.length(); j++) {
                        if (closeBracketFound) {
                            break;
                        }
                        if (input.charAt(j) == '(') {
                            for (int k = input.length() - 1; k > j; k--) {
                                if (input.charAt(k) == ')') {
                                    closeBracket = k;
                                    closeBracketFound = true;
                                    String extraction = input.substring(openBracket, closeBracket + 1);
                                    resultStack.push(extraction);
                                    input = input.substring(openBracket + 1,closeBracket);
                                    break;
                                }
                            }
                        } else if (input.charAt(j) == ')') {
                            closeBracket = j;
                            closeBracketFound = true;
                            String extraction = input.substring(openBracket, closeBracket + 1);
                            resultStack.push(extraction);
                            input = input.substring(closeBracket + 1);
                            break;
                        }
                    }
                }
            }
        }
        while (!resultStack.isEmpty()) {
            System.out.println(resultStack.pop());
        }
    }
}