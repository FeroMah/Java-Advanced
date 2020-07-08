package ExamPreparation.PractisExam.Exam3_22_Feb_2020.Guild_03.guild;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Guild {
    private String name;
    private int capacity;
    private List<Player> roster;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    private String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    private int getCapacity() {
        return capacity;
    }

    private void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Player> getRoster() {
        return roster;
    }

    private void setRoster(List<Player> roster) {
        this.roster = roster;
    }

    private boolean isPlayerUnique(Player player) {
       return this.getRoster().stream()
               .noneMatch(p -> p.getName().equals(player.getName()));
    }

    public void addPlayer(Player player) {
        if (this.getRoster().size() < this.getCapacity()) {
            if (isPlayerUnique(player))
                this.getRoster().add(player);
        }
    }

    public boolean removePlayer(String name) {
        return this.getRoster().removeIf(x -> x.getName().equals(name));
    }

    public void promotePlayer(String name) {
        this.getRoster().stream()
                .filter(p -> p.getName().equals(name))
                .collect(Collectors.toList()).get(0)
                .setRank("Member");
    }
//    public void promotePlayer(String name) {
//        ListIterator<Player> playerListIterator = this.getRoster().listIterator();
//
//        while (playerListIterator.hasNext()) {
//            Player player = playerListIterator.next();
//            if (player.getName().equals(name)) {
//               player.setRank("Member");
//                break;
//            }
//        }
//
//    }

    public void demotePlayer(String name) {
        this.getRoster().stream()
                .filter(p -> p.getName().equals(name))
                .collect(Collectors.toList()).get(0)
                .setRank("Trial");
    }

    public Player[] kickPlayersByClass(String clazz) {
        Player[] kickedPlayers = this.getRoster().stream()
                .filter(p -> p.getClazz().equals(clazz))
                .toArray(Player[]::new);
        for (Player kickedPlayer : kickedPlayers) {
//            list.remove() can work with objects; The method compare the object to all elements inside the list!
            this.getRoster().remove(kickedPlayer);
        }
        return kickedPlayers;
    }

    public int count() {
        return this.getRoster().size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Players in the guild: %s:", this.getName())).append(System.lineSeparator());
        this.getRoster().forEach(p -> sb.append(p.toString()));
        return sb.toString().trim();
    }
}
