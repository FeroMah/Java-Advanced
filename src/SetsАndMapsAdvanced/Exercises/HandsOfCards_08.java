package SetsАndMapsAdvanced.Exercises;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HandsOfCards_08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Set<String>> gameMap = new LinkedHashMap<>();
        String inputLine;
        while (!"JOKER".equalsIgnoreCase(inputLine = sc.nextLine())) {
            String name = getPlayerName(inputLine);
            String[] playerCards = getPlayerCards(inputLine);
            gameMap.putIfAbsent(name, new LinkedHashSet<>());
            for (int i = 0; i < playerCards.length; i++) {      // add all cards in player deck
                gameMap.get(name).add(playerCards[i]);
            }

        }
        Map<String, Integer> scoreBoardMap = new LinkedHashMap<>();
        for (Map.Entry<String, Set<String>> playerDeck : gameMap.entrySet()) {
            playerDeck.getValue().forEach(card -> {
                scoreBoardMap.putIfAbsent(playerDeck.getKey(), 0);
                int oldValue = scoreBoardMap.get(playerDeck.getKey());
                scoreBoardMap.put(playerDeck.getKey(), oldValue + getCardValue(card));
            });
        }
        scoreBoardMap.entrySet().stream().forEach(player -> {
            System.out.println(String.format("%s: %d", player.getKey(), player.getValue()));
        });

    }

    private static int getCardValue(String playerCard) {
        char cardType = ' ';
        String cardNumber = "";
        char symbol = playerCard.charAt(0);
        if (Character.isDigit(symbol)) {
            cardNumber = String.valueOf(symbol);
            if (Character.isDigit(playerCard.charAt(1))) {
                cardNumber += playerCard.charAt(1);
                cardType = playerCard.charAt(2);
            } else {
                cardType = playerCard.charAt(1);
            }
        } else if ('J' == symbol) {
            cardNumber = "11";
            cardType = playerCard.charAt(1);
        } else if ('Q' == symbol) {
            cardNumber = "12";
            cardType = playerCard.charAt(1);
        } else if ('K' == symbol) {
            cardNumber = "13";
            cardType = playerCard.charAt(1);
        } else if ('A' == symbol) {
            cardNumber = "14";
            cardType = playerCard.charAt(1);
        }
        int multtiplayer = 0;
        switch (cardType) {
            case 'S':
                multtiplayer = 4;
                break;
            case 'H':
                multtiplayer = 3;
                break;
            case 'D':
                multtiplayer = 2;
                break;
            case 'C':
                multtiplayer = 1;
                break;
        }
//        card value calculation:
        return multtiplayer * Integer.parseInt(cardNumber);
    }


    private static String[] getPlayerCards(String inputConsoleLine) {
        String regex = "^(?<player>[^:]*):\\s+(?<cards>.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(inputConsoleLine);
        String[] deck = null;
        if (matcher.find()) {
            deck = matcher.group("cards").split(",\\s+");
        }
        return deck;
    }

    private static String getPlayerName(String inputConsoleLine) {
        String regex = "^(?<player>[^:]*):\\s+(?<cards>.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(inputConsoleLine);
        String name = null;
        if (matcher.find()) {
            name = matcher.group("player");
        }
        return name;
    }
}
