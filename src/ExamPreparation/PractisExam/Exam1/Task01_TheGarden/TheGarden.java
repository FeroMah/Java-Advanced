package ExamPreparation.PractisExam.Exam1.Task01_TheGarden;

import java.util.*;

public class TheGarden {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfRows = Integer.parseInt(sc.nextLine());
        List<List<Character>> garden = new ArrayList<>();
        for (int i = 0; i < numberOfRows; i++) {
            garden.add(new ArrayList<>());
            String[] inputVegetables = sc.nextLine().split("\\s+");
            for (int j = 0; j < inputVegetables.length; j++) {          // it is possible to use iter
                garden.get(i).add(inputVegetables[j].charAt(0));
//                System.out.print(garden.get(i).get(j)+" ");       FOR TEST ONLY
            }
//            System.out.println();      FOR TEST ONLY
        }
        Map<String, Integer> harvestedVegi = new LinkedHashMap<>();
        harvestedVegi.put("Carrots", 0);
        harvestedVegi.put("Potatoes", 0);
        harvestedVegi.put("Lettuce", 0);
        harvestedVegi.put("Harmed vegetables", 0);
        String commandInput;
        while (!"End of Harvest".equalsIgnoreCase(commandInput = sc.nextLine())) {
            String[] data = commandInput.split("\\s+");
            String command = data[0].toUpperCase();
            int row = Integer.parseInt(data[1]);
            int column = Integer.parseInt(data[2]);
            switch (command) {
                case "HARVEST":
                    if (row >= 0 && row < garden.size() && column >= 0 && column < garden.get(row).size()) {
                        if (garden.get(row).get(column) != ' ') {
                            int newCount = 0;
                            if (garden.get(row).get(column) == 'C') {
                                newCount = harvestedVegi.get("Carrots") + 1;
                                harvestedVegi.put("Carrots", newCount);
                                garden.get(row).set(column, ' ');
                            } else if (garden.get(row).get(column) == 'P') {
                                newCount = harvestedVegi.get("Potatoes") + 1;
                                harvestedVegi.put("Potatoes", newCount);
                                garden.get(row).set(column, ' ');
                            } else if (garden.get(row).get(column) == 'L') {
                                newCount = harvestedVegi.get("Lettuce") + 1;
                                harvestedVegi.put("Lettuce", newCount);
                                garden.get(row).set(column, ' ');
                            }
                        }
                    }
                    break;
                case "MOLE":
                    String direction = data[3].toUpperCase();
                    int harmedVegiCount = 0;
                    if (row >= 0 && row < garden.size() && column >= 0 && column < garden.get(row).size()) {
                        switch (direction) {
                            case "UP":
                                for (int i = row; i >= 0; i--) {
                                    if (garden.get(i).get(column) == 'C' || garden.get(i).get(column) == 'P' || garden.get(i).get(column) == 'L') {
                                        garden.get(i).set(column, ' ');
                                        i--;
                                        harmedVegiCount++;
                                    }
                                }
                                break;
                            case "DOWN":
                                for (int i = 0; i < garden.size(); i ++) {
                                    if (garden.get(i).get(column) == 'C' || garden.get(i).get(column) == 'P' || garden.get(i).get(column) == 'L') {
                                        garden.get(i).set(column, ' ');
                                        i++;
                                        harmedVegiCount++;
                                    }
                                }
                                break;
                            case "LEFT":
                                for (int i = column; i >= 0; i --) {
                                    if (garden.get(row).get(i) == 'C' || garden.get(row).get(i) == 'P' || garden.get(row).get(i) == 'L') {
                                        garden.get(row).set(i, ' ');
                                        i--;
                                        harmedVegiCount++;
                                    }
                                }
                                break;
                            case "RIGHT":
                                for (int i = column; i < garden.get(row).size(); i++) {
                                    if (garden.get(row).get(i) == 'C' || garden.get(row).get(i) == 'P' || garden.get(row).get(i) == 'L') {
                                        garden.get(row).set(i, ' ');
                                        i++;
                                        harmedVegiCount++;
                                    }
                                }
                                break;
                        }
                        harvestedVegi.put("Harmed vegetables", harvestedVegi.get("Harmed vegetables") + harmedVegiCount);
                    }
            }
        }
        for (int i = 0; i < garden.size(); i++) {
            String resultRow = "";
            for (int j = 0; j < garden.get(i).size(); j++) {
                if (j == garden.get(i).size() - 1) {
                    resultRow += garden.get(i).get(j);
                    break;
                }
                resultRow += garden.get(i).get(j) + " ";
            }
            System.out.println(resultRow);
        }
        harvestedVegi.entrySet().forEach(vegi -> System.out.println(String.format("%s: %d", vegi.getKey(), vegi.getValue())));
    }
}