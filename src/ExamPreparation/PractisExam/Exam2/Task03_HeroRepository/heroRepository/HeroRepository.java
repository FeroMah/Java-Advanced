package ExamPreparation.PractisExam.Exam2.Task03_HeroRepository.heroRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class HeroRepository {
    private Map<String, Hero> data;

    public HeroRepository() {
        this.data = new HashMap<>();
    }

    public void add(Hero hero) {
        this.data.put(hero.getName(), hero);
    }

    public void remove(String heroName) {
        this.data.remove(heroName);
    }

    public Hero getHeroWithHighestStrength() {

        return this.data.values().stream().sorted((h1, h2) ->
                Integer.compare(h2.getItem().getStrength(), h1.getItem().getStrength()))
                .collect(Collectors.toList()).get(0);
    }


    public Hero getHeroWithHighestAgility() {
        return this.data.values().stream().sorted((h1, h2) ->
                Integer.compare(h2.getItem().getAgility(), h1.getItem().getAgility()))
                .collect(Collectors.toList()).get(0);
    }

    public Hero getHeroWithHighestIntelligence() {
        return this.data.values().stream().sorted((h1, h2) ->
                Integer.compare(h2.getItem().getIntelligence(), h1.getItem().getIntelligence()))
                .collect(Collectors.toList()).get(0);
    }

    public int getCount() {
        return this.data.size();
    }

    @Override
    public String toString() {
        return String.join("\n",
                this.data.values()
                        .stream()
                        .map(Hero::toString)
                        .collect(Collectors.toList()));
    }
}

//    @Override
//    public String toString() {
//        StringBuilder allHeroes = new StringBuilder();
//        for (Hero hero : this.data.values()) {
//            allHeroes.append(hero.toString()).append("\n");
//        }
//        return allHeroes.toString().trim();
//    }

