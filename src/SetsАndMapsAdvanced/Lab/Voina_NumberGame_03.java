package SetsАndMapsAdvanced.Lab;

import java.util.*;

public class Voina_NumberGame_03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Set<Integer> player1Deck = new LinkedHashSet<>();
        int[] inputCardsPlayer1 = Arrays.stream(sc.nextLine().split("\\s+")).limit(20).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < inputCardsPlayer1.length; i++) {
            player1Deck.add(inputCardsPlayer1[i]);
        }
        Set<Integer> player2Deck = new LinkedHashSet<>();
        int[] inputCardsPlayer2 = Arrays.stream(sc.nextLine().split("\\s+")).limit(20).mapToInt(Integer::parseInt).toArray();
        for (int j = 0; j < inputCardsPlayer2.length; j++) {
            player2Deck.add(inputCardsPlayer2[j]);
        }
        int roundsPlayed = 0;
        while (roundsPlayed < 50 && !player1Deck.isEmpty() && !player2Deck.isEmpty()) {
            int player1Card = player1Deck.iterator().next();
            player1Deck.remove(player1Card);
            int player2Card = player2Deck.iterator().next();
            player2Deck.remove(player2Card);
            if (player1Card > player2Card) {
                player1Deck.add(player1Card);
                player1Deck.add(player2Card);
            } else if (player2Card > player1Card) {
                player2Deck.add(player1Card);
                player2Deck.add(player2Card);
            }
            roundsPlayed++;
        }
        if (player1Deck.size() > player2Deck.size()) {
            System.out.println("First player win!");
        } else System.out.println("Second player win!");
    }
}
