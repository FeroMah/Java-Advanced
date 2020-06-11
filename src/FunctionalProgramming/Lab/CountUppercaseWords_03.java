package FunctionalProgramming.Lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUppercaseWords_03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> inputConsole = Arrays.stream(sc.nextLine().split("\\s+")).collect(Collectors.toList());
        Predicate<String> startWithUpperCase = x -> x.charAt(0) >= 'A' && x.charAt(0) <= 'Z';
        List<String> listOfWords= new ArrayList<>();
        for (String word : inputConsole) {
            if (startWithUpperCase.test(word)){
                listOfWords.add(word);
            }
        }
        System.out.println(listOfWords.size());
        listOfWords.forEach(System.out::println);
    }
}
