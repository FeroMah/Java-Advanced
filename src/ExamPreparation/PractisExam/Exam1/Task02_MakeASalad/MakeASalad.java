package ExamPreparation.PractisExam.Exam1.Task02_MakeASalad;

import java.util.*;

public class MakeASalad {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] inputVegi = sc.nextLine().split("\\s+");
        ArrayDeque<String> queueOfVegi = new ArrayDeque<>();
        for (int i = 0; i < inputVegi.length; i++) {
            queueOfVegi.offer(inputVegi[i]);
        }
        ArrayDeque<Integer> stackOfSalads = new ArrayDeque<>();
        int[] saladCalorie = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < saladCalorie.length; i++) {
            stackOfSalads.push(saladCalorie[i]);
        }
        int lastSalad = 0;
        List<Integer> madeSalads = new ArrayList<>();
        while (true) {
            if (stackOfSalads.isEmpty()) {
                System.out.println(String.join(" ", madeSalads.toString().replaceAll("[\\,\\]\\[]", "")));
                String vegiLeft = String.join(" ", queueOfVegi);
                System.out.println(vegiLeft);
                break;
            }
            if (queueOfVegi.isEmpty()) {
                System.out.println(String.join(" ", madeSalads.toString().replaceAll("[\\,\\]\\[]", "")));
                String saladLeft = String.join(" ", stackOfSalads.toString().replaceAll("[\\,\\]\\[]", ""));
                System.out.println(saladLeft);
                break;
            }
            if (lastSalad <= 0) {
                lastSalad = stackOfSalads.peek();
                madeSalads.add(stackOfSalads.peek());
            }
            switch (queueOfVegi.peek()) {
                case "potato":
                    lastSalad -= 215;
                    queueOfVegi.poll();
                    break;
                case "tomato":
                    lastSalad -= 80;
                    queueOfVegi.poll();
                    break;
                case "carrot":
                    lastSalad -= 136;
                    queueOfVegi.poll();
                    break;
                case "lettuce":

                    lastSalad -= 109;
                    queueOfVegi.poll();
                    break;

            }
            if (lastSalad <= 0) {
                stackOfSalads.pop();
            }
        }
    }
}