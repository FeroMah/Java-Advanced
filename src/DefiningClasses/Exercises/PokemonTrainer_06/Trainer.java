package DefiningClasses.Exercises.PokemonTrainer_06;

import java.util.ArrayList;
import java.util.List;

class Trainer {
    //    Trainer have a name, number of badges and a collection of pokemon.
    private String name;
    private int numberOfBadges = 0;
    private List<Pokemon> collection;


    Trainer(String name) {
        this.name = name;
        this.collection = new ArrayList<>();
    }

    String getName() {
        return name;
    }

    int getNumberOfBadges() {
        return numberOfBadges;
    }

    void setNumberOfBadges(int numberOfBadges) {
        this.numberOfBadges = numberOfBadges;
    }

    void setName(String name) {
        this.name = name;
    }

    List<Pokemon> getPokemonCollection() {
        return collection;
    }

    void addToCollection(Pokemon pokemon) {
        this.collection.add(pokemon);
    }

    void setPokemonHealth(int pokemonIndex, int newPokemonHealth) {
        this.getPokemon(pokemonIndex).setHealth(newPokemonHealth);
    }

    int getPokemonHealth(int pokemonIndex) {
        return this.collection.get(pokemonIndex).getHealth();
    }

    private Pokemon getPokemon(int pokemonIndex) {
        return getPokemonCollection().get(pokemonIndex);
    }

    String getPokemonElement(int pokemonIndex) {
        return getPokemonCollection().get(pokemonIndex).getElement();
    }

}

