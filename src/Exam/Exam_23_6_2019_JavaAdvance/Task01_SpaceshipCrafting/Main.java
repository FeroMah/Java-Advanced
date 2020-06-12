package Exam.Exam_23_6_2019_JavaAdvance.Task01_SpaceshipCrafting;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] inputLiquids = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] inputItem = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        Map<String, Integer> advancedMaterial = new HashMap<>();
        Map<String, Integer> buildMaterials = new TreeMap<>();
        advancedMaterial.put("Glass", 25);
        advancedMaterial.put("Aluminium", 50);
        advancedMaterial.put("Lithium", 75);
        advancedMaterial.put("Carbon fiber", 100);
        buildMaterials.put("Glass", 0);
        buildMaterials.put("Aluminium", 0);
        buildMaterials.put("Lithium", 0);
        buildMaterials.put("Carbon fiber", 0);
        ArrayDeque<Integer> queueLiquids = new ArrayDeque<>();
        for (int i = 0; i < inputLiquids.length; i++) {
            queueLiquids.offer(inputLiquids[i]);
        }
        ArrayDeque<Integer> stackItem = new ArrayDeque<>();
        for (int i = 0; i < inputItem.length; i++) {
            stackItem.push(inputItem[i]);
        }
        while (true) {
            if (queueLiquids.isEmpty() || stackItem.isEmpty()) {
                break;
            }
            if (advancedMaterial.containsValue(queueLiquids.peek() + stackItem.peek())) {
                String builded = "";
                for (Map.Entry<String, Integer> material : advancedMaterial.entrySet()) {
                    if (material.getValue() == queueLiquids.peek() + stackItem.peek()) {
                        builded = material.getKey();
                        break;
                    }
                }
                int addOne = buildMaterials.get(builded) + 1;
                buildMaterials.put(builded, addOne);
                queueLiquids.poll();
                stackItem.pop();
            } else {
                queueLiquids.poll();
                int oldValue = stackItem.pop() + 3;
                stackItem.push(oldValue);
            }
        }
        boolean spaceShipIsBuild = true;
        for (Map.Entry<String, Integer> material : buildMaterials.entrySet()) {
            if (material.getValue() == 0) {
                spaceShipIsBuild = false;
                break;
            }
        }
        if (spaceShipIsBuild) {
            System.out.println("Wohoo! You succeeded in building the spaceship!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to build the spaceship.");
        }
        if (queueLiquids.isEmpty()) {
            System.out.println("Liquids left: none");
        } else {
            System.out.print("Liquids left: ");
            while (queueLiquids.size() > 1) {       // it was stackItem.size() > 1 dumb mistake!!!
                System.out.print(String.format("%s, ", queueLiquids.poll()));
            }
            System.out.print(String.format("%s", queueLiquids.poll()));
            System.out.println();
        }
        if (stackItem.isEmpty()) {
            System.out.println("Physical items left: none");
        } else {
            System.out.print("Physical items left: ");
            while (stackItem.size() > 1) {
                System.out.print(String.format("%s, ", stackItem.pop()));
            }
            System.out.print(String.format("%s", stackItem.pop()));
            System.out.println();

        }
        for (Map.Entry<String, Integer> material : buildMaterials.entrySet()) {
            System.out.println(String.format("%s: %d", material.getKey(), material.getValue()));
        }
    }
}

