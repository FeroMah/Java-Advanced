package DefiningClasses.Exercises.FromValdo222.PokemonTrainer_06;

class Pokemon {
    private String name;
    private String element;
    private int health;

    Pokemon(String name, String element, int health) {
        this.name = name;
        this.element = element;
        this.health = health;
    }

    int getHealth() {
        return health;
    }

    void setHealth() {
        this.health = this.health - 10;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    String getElement() {
        return element;
    }

    void setElement(String element) {
        this.element = element;
    }
}
