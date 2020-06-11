package Generisc.Exercise.GenericSwapMethod;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfElements = Integer.parseInt(sc.nextLine());
        GenericBox<Integer> genericBox = new GenericBox<>();
        for (int i = 0; i < numberOfElements; i++) {
            genericBox.add(Integer.parseInt(sc.nextLine()));
        }
        int [] swapCommand = Arrays.stream(sc.nextLine().split("\\s+")).limit(2).mapToInt(Integer::parseInt).toArray();
        genericBox.swap(swapCommand[0],swapCommand[1]);
        for (int i = 0; i < genericBox.size(); i++) {
            String resultType = genericBox.get(i).getClass().getTypeName();
            System.out.println(resultType+": "+ genericBox.get(i));
        }
    }
}
