import java.lang.reflect.Array;
import java.util.*;

public class Summer_Cocktails {
    private static Map<String, Integer> cocktailsReady;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] bucketOfIngredients = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> ingredientsQueue = new ArrayDeque<>();
        for (int ingredients : bucketOfIngredients) {
            ingredientsQueue.offer(ingredients);
        }

        ArrayDeque<Integer> freshnessLVL_Stack = new ArrayDeque<>();
        int[] freshnessValues = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        for (int freshnessValue : freshnessValues) {
            freshnessLVL_Stack.push(freshnessValue);
        }
        cocktailsReady = new TreeMap<>();

        while (true) {
            if (freshnessLVL_Stack.isEmpty() || ingredientsQueue.isEmpty()) {
                break;
            }
            int firstIngredient = ingredientsQueue.poll();
            if (firstIngredient == 0) {
                if (!ingredientsQueue.isEmpty()) {
                    firstIngredient = ingredientsQueue.poll();
                } else break;
            }
            int lastFreshnessLVL = freshnessLVL_Stack.pop();
            if (mixingBoth(firstIngredient, lastFreshnessLVL) != null) {
                String cocktailName = mixingBoth(firstIngredient, lastFreshnessLVL);  //successful Mixture
                if (cocktailsReady.containsKey(cocktailName)) {                       //
                    int newValueCount = cocktailsReady.get(cocktailName) + 1;         //
                    cocktailsReady.put(cocktailName, newValueCount);                  //
                } else {                                                              //
                    cocktailsReady.putIfAbsent(cocktailName, 1);                      //
                }
            } else {
                ingredientsQueue.offer(firstIngredient + 5);        //unsuccessful Mixture
            }

        }
        //Printing
        if (hasOneDrinkFromEveryType()) {
            System.out.println("It's party time! The cocktails are ready!");
            for (Map.Entry<String, Integer> cocktail : cocktailsReady.entrySet()) {
                System.out.println(String.format(" # %s --> %d", cocktail.getKey(), cocktail.getValue()));
            }
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
            int sumLeft = 0;
            for (Integer ingredient : ingredientsQueue) {
                sumLeft += ingredient;
            }
            System.out.println(String.format("Ingredients left: %d", sumLeft));
            for (Map.Entry<String, Integer> cocktail : cocktailsReady.entrySet()) {
                System.out.println(String.format(" # %s --> %d", cocktail.getKey(), cocktail.getValue()));
            }
        }
    }

    private static String mixingBoth(int ingredient, int freshnessLVL) {
        int mixture = ingredient * freshnessLVL;
        String cocktailName = null;
        switch (mixture) {
            case 150:
                cocktailName = "Mimosa";
                break;
            case 250:
                cocktailName = "Daiquiri";
                break;
            case 300:
                cocktailName = "Sunshine";
                break;
            case 400:
                cocktailName = "Mojito";
                break;
        }
        return cocktailName;
    }

    private static boolean hasOneDrinkFromEveryType() {
        return cocktailsReady.keySet().size() == 4;
    }
}
