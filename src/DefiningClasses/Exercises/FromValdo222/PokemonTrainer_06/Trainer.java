package DefiningClasses.Exercises.FromValdo222.PokemonTrainer_06;

import java.util.ArrayList;
import java.util.List;

class Trainer {
    private String name;
    private int badges; // = 0
    private List<Pokemon> collection;

    Trainer(String name) {
        this.name = name;
        this.collection = new ArrayList<>();
        this.badges = 0;

    }

    void setName(String name) {
        this.name = name;
    }

    int getBadges() {
        return badges;
    }

    void setBadges() {
        this.badges++;
    }

    List<Pokemon> getCollection() {
        return collection;
    }


    void setCollection(Pokemon pokemon) {
        this.collection.add(pokemon);
    }

    String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " " + badges + " " + collection.size();
    }
}
