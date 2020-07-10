package ExamPreparation.PractisExam.Exam3_22_Feb_2020.Guild_V2_Map.guild;


import java.util.LinkedHashMap;
import java.util.Map;

public class Guild {
    private String name;
    private int capacity;
    private Map<String, Player> roster;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new LinkedHashMap<>();
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

    private Map<String, Player> getRoster() {
        return roster;
    }

    private void setRoster(Map<String, Player> roster) {
        this.roster = roster;
    }

    public void addPlayer(Player player) {
        if (this.getRoster().size() < this.getCapacity()) {
                this.getRoster().put(player.getName(),player);
        }
    }

    public boolean removePlayer(String name) {
        return this.getRoster().remove(name,this.getRoster().get(name));
    }

    public void promotePlayer(String name) {
        this.getRoster().get(name).setRank("Member");
    }


    public void demotePlayer(String name) {
        this.getRoster().get(name).setRank("Trial");
    }

    public Player[] kickPlayersByClass(String clazz) {
        Player[] kickedPlayers = this.getRoster().values().stream()
                .filter(p -> p.getClazz().equals(clazz)).toArray(Player[]::new);

        for (Player kickedPlayer : kickedPlayers) {
//            list.remove() can work with objects; The method compare the object to all elements inside the list!
            this.getRoster().remove(kickedPlayer.getName());
        }
        return kickedPlayers;
    }

    public int count() {
        return this.getRoster().size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Players in the guild: %s:", this.getName())).append(System.lineSeparator());
        this.getRoster().values().forEach(p -> sb.append(p.toString()));
        return sb.toString().trim();
    }
}
