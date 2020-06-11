package FunctionalProgramming.Lab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FilterByAge_05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfLines = Integer.parseInt(sc.nextLine());
        Map<String, Integer> dataMap = new LinkedHashMap<>();
        for (int i = 0; i < numberOfLines; i++) {
            String[] consoleInput = sc.nextLine().split(",\\s+");
            dataMap.put(consoleInput[0], Integer.parseInt(consoleInput[1]));
        }
        String range = sc.nextLine();
        int numberAge = Integer.parseInt(sc.nextLine());
        String[] toPrint = sc.nextLine().split("\\s+");
        Map<String, Integer> resultMap = new LinkedHashMap<>();
        dataMap.entrySet().forEach(every -> {
            if (range.equalsIgnoreCase("older")) {
                if (every.getValue() >= numberAge) {
                    resultMap.put(every.getKey(), every.getValue());
                }
            } else if (range.equalsIgnoreCase("younger")) {
                if (every.getValue() <= numberAge) {
                    resultMap.put(every.getKey(), every.getValue());
                }
            }
        });
        if (toPrint.length==2){
            resultMap.entrySet().forEach(x-> System.out.println(String.format("%s - %d", x.getKey(),x.getValue())));
            return;
        }
        if (toPrint[0].equalsIgnoreCase("name")){
            resultMap.keySet().forEach(System.out::println);
        }else if (toPrint[0].equalsIgnoreCase("age")){
            resultMap.values().forEach(System.out::println);
        }
    }
}
