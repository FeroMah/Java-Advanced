package Generisc.Exercise.CustomList_07;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CustomList customList = new CustomList();
        String input;
        while (!"End".equalsIgnoreCase(input = sc.nextLine())) {
            String[] inputLine = sc.nextLine().split("\\s+");
            switch (inputLine[0]) {
                case "Add":
                    break;
                case "Remove":
                    break;
                case "Contains":
                    break;
                case "Swap":
                    break;
                case "Greater":
                    int counter=0;
                    for (int i = 0; i <customList.size() ; i++) {
//                        if (customList.get(i).compareTo(inputLine[1]))
                    }
                    break;
                case "Max":
                    System.out.println(customList.getMax());
                    break;
                case "Min":
                    System.out.println(customList.getMin());
                    break;
                case "Print":
                    break;
            }
        }
    }
}
