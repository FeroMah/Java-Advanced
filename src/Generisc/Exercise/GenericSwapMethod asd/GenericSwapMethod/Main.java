package Generisc.Exercise.GenericSwapMethod;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfElements = Integer.parseInt(sc.nextLine());
        GenericBox<String> genericBox = new GenericBox<>();
        for (int i = 0; i < numberOfElements; i++) {
            genericBox.add(sc.nextLine().trim());
        }
        String inputElement = sc.nextLine();
        int countBiggerElements = genericBox.hasBiggerElement(inputElement);
        System.out.println(countBiggerElements);
    }
}
