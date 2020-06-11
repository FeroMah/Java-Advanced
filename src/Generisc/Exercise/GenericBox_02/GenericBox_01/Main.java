package Generisc.Exercise.GenericBox_01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfElements = Integer.parseInt(sc.nextLine());
        GenericBox<Integer> genericBox = new GenericBox<>();
        for (int i = 0; i < numberOfElements; i++) {
            genericBox.add(Integer.parseInt(sc.nextLine()));
        }
        for (int i = 0; i < genericBox.size(); i++) {
            String resultType = genericBox.get(i).getClass().getTypeName();
            System.out.println(resultType+": "+ genericBox.get(i));
        }

    }
}
