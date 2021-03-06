package StacksAndQueues.Labs;

import java.util.ArrayDeque;
import java.util.Scanner;

public class HotPatato_06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] players = sc.nextLine().split("\\s+");
        int boomTime = Integer.valueOf(sc.nextLine());
        ArrayDeque<String> playersQueue = new ArrayDeque<>();
        for (int i = 0; i < players.length; i++) {
            playersQueue.offer(players[i]);
        }
        while (playersQueue.size() != 1) {
            String playerWithPatato = "";
            for (int i = 0; i < boomTime - 1; i++) {
                playerWithPatato = playersQueue.poll();
                playersQueue.offer(playerWithPatato);
            }
            String playerOut = playersQueue.poll();
            System.out.println(String.format("Removed %s", playerOut));
        }
        System.out.println("Last is " + playersQueue.poll());
    }
}
