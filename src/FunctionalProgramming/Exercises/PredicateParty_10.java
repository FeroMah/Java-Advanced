package FunctionalProgramming.Exercises;

import java.util.*;

import java.util.stream.Collectors;

public class PredicateParty_10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> guestInput = Arrays.stream(sc.nextLine().split("\\s+")).collect(Collectors.toList());

        String isItParty;

        while (!"Party!".equalsIgnoreCase(isItParty = sc.nextLine())) {
            String[] commandInput = isItParty.split("\\s+");
            String command = commandInput[0];
            String boundary = commandInput[1];
            String criteria = commandInput[2];
            if ("Remove".equalsIgnoreCase(command)) {
                switch (boundary.toUpperCase()) {
                    case "STARTSWITH":
                        for (int i = 0; i < guestInput.size(); i++) {
                            if (guestInput.get(i).startsWith(criteria)) {
                                guestInput.remove(i);
                                i--;
                            }
                        }
                        break;
                    case "ENDSWITH":
                        for (int i = 0; i < guestInput.size(); i++) {
                            if (guestInput.get(i).endsWith(criteria)) {
                                guestInput.remove(i);
                                i--;
                            }
                        }
                        break;
                    case "LENGTH":
                        for (int i = 0; i < guestInput.size(); i++) {
                            if (guestInput.get(i).length() == Integer.parseInt(criteria)) {
                                guestInput.remove(i);
                                i--;
                            }
                        }
                        break;
                }
            } else if ("Double".equalsIgnoreCase(command)) {
                switch (boundary.toUpperCase()) {
                    case "STARTSWITH":
                        for (int i = 0; i < guestInput.size(); i++) {
                            if (guestInput.get(i).startsWith(criteria)) {
                                guestInput.add(i + 1, guestInput.get(i));
                                i++;
                            }
                        }
                        break;
                    case "ENDSWITH":
                        for (int i = 0; i < guestInput.size(); i++) {
                            if (guestInput.get(i).endsWith(criteria)) {
                                guestInput.add(i + 1, guestInput.get(i));
                                i++;
                            }
                        }
                        break;
                    case "LENGTH":
                        for (int i = 0; i < guestInput.size(); i++) {
                            if (guestInput.get(i).length() == Integer.parseInt(criteria)) {
                                guestInput.add(i + 1, guestInput.get(i));
                                i++;
                            }
                        }
                        break;
                }
            }
        }
        if (!guestInput.isEmpty()) {
            Collections.sort(guestInput);
            String areGoing = String.join(", ", guestInput);
            System.out.println(areGoing + " are going to the party!");
        } else System.out.println("Nobody is going to the party!");
    }
}