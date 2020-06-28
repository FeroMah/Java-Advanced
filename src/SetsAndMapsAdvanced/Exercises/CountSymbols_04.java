package SetsAndMapsAdvanced.Exercises;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols_04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputConsole = sc.nextLine();
        Map<String, Integer> symbolMap = new TreeMap<>();
        for (int i = 0; i < inputConsole.length(); i++) {
            char symbol = inputConsole.charAt(i);
            symbolMap.putIfAbsent(String.valueOf(symbol), 0);
            int oldValue = symbolMap.get(String.valueOf(symbol));
            symbolMap.put(String.valueOf(symbol), oldValue + 1);
        }
        for (Map.Entry<String, Integer> symbol : symbolMap.entrySet()) {
            System.out.println(String.format("%s: %d time/s", symbol.getKey(), symbol.getValue()));
        }
    }
}
