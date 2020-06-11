package ExamPreparation.PractisExam.Exam2.Task01_ClubParty;

import java.util.*;

public class ClubParty {
    private static Map<Character, List<Integer>> data;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int hallsMaximumCapacity = Integer.parseInt(sc.nextLine());
        ArrayDeque<Character> queueOfHalls = new ArrayDeque<>();
        ArrayDeque<Integer> queueOfPeople = new ArrayDeque<>();
        data = new HashMap<>();
        String[] inputLine = sc.nextLine().split("\\s+");
        boolean hasHallAvailable = false;
        for (int i = inputLine.length - 1; i >= 0; i--) {
            String symbol = inputLine[i];
            if (Character.isAlphabetic(symbol.charAt(0))) {
                queueOfHalls.offer(symbol.charAt(0));
                data.put(symbol.charAt(0), new ArrayList<>());
                hasHallAvailable = true;
            }
            if (hasHallAvailable) {
                if (Character.isDigit(symbol.charAt(0))) {
                    int people = Integer.parseInt(inputLine[i]);
                    queueOfPeople.offer(people);
                }
            }
        }
        while (true) {
            int peopleInside = getPeopleInside(queueOfHalls.peek());
            if (peopleInside + queueOfPeople.peek() <= hallsMaximumCapacity) {
                data.get(queueOfHalls.peek()).add(queueOfPeople.peek());
                queueOfPeople.poll();
            }
            if (peopleInside + queueOfPeople.peek() > hallsMaximumCapacity) {
                System.out.println(String.format("%s -> %s", queueOfHalls.peek(),
                        data.get(queueOfHalls.peek()).toString().replaceAll("[\\]\\[]", "")));
                queueOfHalls.poll();
                if (queueOfHalls.isEmpty()) break;
                if (queueOfPeople.peek() <= hallsMaximumCapacity) {
                    data.get(queueOfHalls.peek()).add(queueOfPeople.peek());
                    queueOfPeople.poll();
                } else queueOfPeople.poll();
            }
            if (queueOfHalls.isEmpty() || queueOfPeople.isEmpty()) {
                break;
            }
        }
    }

    private static int getPeopleInside(char hall) {
        int peopleInside = 0;
        for (int j = 0; j < data.get(hall).size(); j++) {
            peopleInside += data.get(hall).get(j);
        }
        return peopleInside;
    }
}


