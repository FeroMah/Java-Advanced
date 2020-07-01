package ExamPreparation.PractisExam.Exam3_22_Feb_2020.Lootbox_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> box1 = Arrays.stream(bufferedReader.readLine()
                .split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> box2 = Arrays.stream(bufferedReader.readLine()
                .split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        int sumCollection = 0;

        while (true) {

            if (box1.isEmpty()) {
                System.out.println("First lootbox is empty");
                break;
            }
            if (box2.isEmpty()) {
                System.out.println("Second lootbox is empty");
                break;
            }


            int loot1 = box1.get(0);
            int loot2 = box2.get(box2.size() - 1);

            int loots = loot1 + loot2;
            if (loots % 2 == 0) {
                sumCollection += loots;
                box1.remove(0);
                box2.remove(box2.size() - 1);
            } else {
                box1.add(loot2);
                box2.remove(box2.size() - 1);
            }

        }
        if (sumCollection < 100) {
            System.out.println(String.format("Your loot was poor... Value: %d", sumCollection));
        } else {
            System.out.println(String.format("Your loot was epic! Value: %d", sumCollection));
        }
    }
}

