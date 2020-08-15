package ExamPreparation.PractisExam.Exam5_28_June_2020.Bombs_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class Bombs {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<Integer> effectsQueue = new ArrayDeque<>();
        Arrays.stream(br.readLine().split(", "))
                .map(Integer::parseInt)
                .forEach(effectsQueue::offer);
        ArrayDeque<Integer> casingStack = new ArrayDeque<>();
        Arrays.stream(br.readLine().split(", "))
                .map(Integer::parseInt)
                .forEach(casingStack::push);


        Map<String, Integer> bombPouch = new LinkedHashMap<>();
        bombPouch.put("Cherry Bombs", 0);
        bombPouch.put("Datura Bombs", 0);
        bombPouch.put("Smoke Decoy Bombs", 0);


        while (true) {
            if (isCreatedAtLeastOneOfEachTypeBombs(bombPouch)) {
                System.out.println("Bene! You have successfully filled the bomb pouch!");
                break;
            }
            if (effectsQueue.isEmpty() || casingStack.isEmpty()) {
                System.out.println("You don't have enough materials to fill the bomb pouch.");
                break;
            }

            int effect = effectsQueue.poll();
            int casing = casingStack.pop();
            int mixed = effect + casing;

            if (mixed == 40) {
                bombPouch.put("Datura Bombs", bombPouch.get("Datura Bombs") + 1);
            } else if (mixed == 60) {
                bombPouch.put("Cherry Bombs", bombPouch.get("Cherry Bombs") + 1);
            } else if (mixed == 120) {
                bombPouch.put("Smoke Decoy Bombs", bombPouch.get("Smoke Decoy Bombs") + 1);
            } else {
                effectsQueue.offerFirst(effect);
                if (casing - 5 >= 0) {
                    casingStack.push(casing - 5);
                }
            }
        }


        if (effectsQueue.isEmpty()) {
            System.out.println("Bomb Effects: empty");
        } else System.out.println("Bomb Effects: " + String.join(", ", effectsQueue.toString()
                .replace("[", "").replace("]", "")));
        if (casingStack.isEmpty()) {
            System.out.println("Bomb Casings: empty");
        } else System.out.println("Bomb Casings: " + casingStack.toString()
                .replace("[", "").replace("]", ""));

        for (Map.Entry<String, Integer> entry : bombPouch.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    private static boolean isCreatedAtLeastOneOfEachTypeBombs(Map<String, Integer> pouch) {
        return (pouch.values().stream().filter(b -> b >= 3).toArray().length) == 3;
    }
}
