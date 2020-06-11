package DefiningClasses.Exercises.PokemonTrainer_06;

class Pokemon {
    //    Pokemon have a name, an element and health, all values are mandatory.
    private String name;
    private String element;
    private int health = 0;

    String getElement() {
        return element;
    }

    Pokemon(String name, String element, int health) {
        this.name = name;
        this.element = element;
        this.health = health;
    }

    int getHealth() {
        return health;
    }

    void setHealth(int health) {
        this.health = health;
    }
}
