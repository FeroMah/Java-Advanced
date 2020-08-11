package DefiningClasses.Exercises.CatLady_09;

import DefiningClasses.Exercises.CatLady_09.breads.Cymric;
import DefiningClasses.Exercises.CatLady_09.breads.Siamese;
import DefiningClasses.Exercises.CatLady_09.breads.StreetExtraordinaire;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        List<Cat> cats = new ArrayList<>();

        while (!(input = br.readLine()).equals("End")) {
            String[] metaCat = input.split("\\s+");

            String breed = metaCat[0];
            String name = metaCat[1];
            int meta = Integer.parseInt(metaCat[2]);

            Cat cat = null;
            if (breed.equals("StreetExtraordinaire")) {
                cat = new StreetExtraordinaire(name, meta);
            }
            if (breed.equals("Siamese")) {
                cat = new Siamese(name, meta);
            }
            if (breed.equals("Cymric")) {
                cat = new Cymric(name, meta);
            }

            if (cat != null) {
                cats.add(cat);
            }
        }
        String catName = br.readLine().trim();

        Cat catByName = findCatByName(catName, cats);

        System.out.println(catByName.toString());
    }

    private static Cat findCatByName(String name, List<Cat> cats) {
        return cats.stream()
                .filter(cat -> cat.getName().equals(name))
                .collect(Collectors.toList()).get(0);
    }
}