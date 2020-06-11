package DefiningClasses.Exercises.PokemonTrainer_06;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Trainer> allTrainers = new LinkedHashMap<>();
        String input;
        while (!"Tournament".equalsIgnoreCase(input = sc.nextLine())) {
            String[] inputData = input.split("\\s+");
// input format: "<TrainerName> <PokemonName> <PokemonElement> <PokemonHealth>"
            String trainerName = inputData[0];
            String pokemonName = inputData[1];
            String pokemonElement = inputData[2];
            int pokemonHealth = Integer.parseInt(inputData[3]);
            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            if (!allTrainers.containsKey(trainerName)) {
                Trainer trainer = new Trainer(trainerName);
                trainer.addToCollection(pokemon);
                allTrainers.put(trainerName, trainer);
            } else {
                allTrainers.get(trainerName).addToCollection(pokemon);
            }
        }
        while (!"End".equalsIgnoreCase(input = sc.nextLine())) {
            if (input.equalsIgnoreCase("Fire")
                    || input.equalsIgnoreCase("Water")
                    || input.equalsIgnoreCase("Electricity")) {
                for (Trainer trainer : allTrainers.values()) {
                    boolean hasThisTypeOfPokemon = false;
                    for (int i = 0; i < trainer.getPokemonCollection().size(); i++) {
                        if (trainer.getPokemonElement(i).equalsIgnoreCase(input)) {
                            trainer.setNumberOfBadges(trainer.getNumberOfBadges() + 1);
                            hasThisTypeOfPokemon = true;
                            break;
                        }
                    }
                    if (!hasThisTypeOfPokemon) {
                        decreaseHealthToAllPokemons(trainer);
                    }
                }
            } else {
                for (Trainer trainer : allTrainers.values()) {
                decreaseHealthToAllPokemons(trainer);
            }}
        }
        allTrainers.values().stream().sorted((value1, value2) ->
                Integer.compare(value2.getNumberOfBadges(), value1.getNumberOfBadges())).
                forEach(trainer -> System.out.println(String.format("%s %d %d",
                        trainer.getName(), trainer.getNumberOfBadges(), trainer.getPokemonCollection().size())));
    }

    private static void decreaseHealthToAllPokemons(Trainer trainer) {
            for (int i = 0; i < trainer.getPokemonCollection().size(); i++) {
                int newHealth = trainer.getPokemonHealth(i) - 10;
                trainer.setPokemonHealth(trainer.getPokemonHealth(i), newHealth);
                if (trainer.getPokemonHealth(i) <= 0) {
                    trainer.getPokemonCollection().remove(i);
                    i--;
                }
            }

    }
}