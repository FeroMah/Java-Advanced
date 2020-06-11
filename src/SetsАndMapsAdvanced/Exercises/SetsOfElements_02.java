package SetsАndMapsAdvanced.Exercises;

import java.util.*;
// the catch for this task is to think about in which set you have to iterate through (answer: the first)
public class SetsOfElements_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] setSizes = Arrays.stream(sc.nextLine().split("\\s+")).limit(2).mapToInt(Integer::parseInt).toArray();
        Set<Integer> collectionSetZero = new LinkedHashSet<>();     // <---- first collection
        Set<Integer> collectionSetOne = new LinkedHashSet<>();
        for (int i = 0; i < setSizes[0]; i++) {
            int inputConsole = Integer.parseInt(sc.nextLine());
            collectionSetZero.add(inputConsole);
        }
        for (int i = 0; i < setSizes[1]; i++) {
            int inputConsole = Integer.parseInt(sc.nextLine());
            collectionSetOne.add(inputConsole);
        }
        for (Integer element : collectionSetZero) {
            if (collectionSetOne.contains(element)) {
                System.out.print(element + " ");
            }
        }
    }
}
