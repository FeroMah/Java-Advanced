package FunctionalProgramming.Lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.UnaryOperator;

public class AddVat_04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UnaryOperator<Double> addVat = value -> value * 1.2;
        List<Double> result = new ArrayList<>();
        Arrays.stream(sc.nextLine().split(",\\s+")).mapToDouble(Double::parseDouble).forEach(e -> {
            result.add(addVat.apply(e));
        });
        System.out.println("Prices with VAT:");
        result.forEach(e-> System.out.println(String.format("%.2f",e)));
    }
}
