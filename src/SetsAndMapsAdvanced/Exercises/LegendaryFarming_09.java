package SetsAndMapsAdvanced.Exercises;

import java.util.*;

public class LegendaryFarming_09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] inputString = sc.nextLine().split("\\s+");

        Map<String, Integer> inventory = new TreeMap<>();
        inventory.put("shards", 0);
        inventory.put("fragments", 0);
        inventory.put("motes", 0);

        Map<String, Integer> junk = new TreeMap<>();

        while (true) {
            for (int i = 0; i < inputString.length; i += 2) {

                int quantity = Integer.parseInt(inputString[i]);
                String material = inputString[i + 1].toLowerCase();

                if (material.equalsIgnoreCase("shards") || material.equalsIgnoreCase("fragments") || material.equalsIgnoreCase("motes")) {
                    inventory.put(material, inventory.get(material) + quantity);
                    if (inventory.get(material) >= 250) {

                        switch (material) {
                            case "shards":
                                System.out.println("Shadowmourne obtained!");
                                break;
                            case "fragments":
                                System.out.println("Valanyr obtained!");
                                break;
                            case "motes":
                                System.out.println("Dragonwrath obtained!");
                                break;
                        }
                        inventory.put(material, inventory.get(material) - 250);
                        inventory.entrySet().stream().sorted((e1, e2) -> e2.getValue()
                                .compareTo(e1.getValue()))
                                .forEach(e -> System.out.println(String.format("%s: %d", e.getKey(), e.getValue())));

                        junk.entrySet().stream().forEach(e -> System.out.println(String.format("%s: %d", e.getKey(), e.getValue())));
                        return;
                    }
                } else {
                    junk.putIfAbsent(material, 0);
                    junk.put(material, junk.get(material) + quantity);
                }
            }
            inputString = sc.nextLine().split("\\s+");
        }
    }
}
