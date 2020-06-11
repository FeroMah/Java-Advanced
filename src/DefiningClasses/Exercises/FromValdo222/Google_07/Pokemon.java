package DefiningClasses.Exercises.FromValdo222.Google_07;

class Pokemon {
    private String pokemonName;
    private String pokemonType;

    Pokemon(String pokemonName, String pokemonType) {
        this.pokemonName = pokemonName;
        this.pokemonType = pokemonType;
    }

    String getPokemonName() {
        return pokemonName;
    }

    String getPokemonType() {
        return pokemonType;
    }
}

