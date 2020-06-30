package SetsAndMapsAdvanced.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class PopulationCounter_07 {
    public static void main(String[] args) throws IOException {
        Map<String, Map<String, Integer>> countries = new LinkedHashMap<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] consoleInput = br.readLine().split("\\|");
//        System.out.println(Arrays.toString(consoleInput));

        while (!consoleInput[0].equals("report")) {

            String city = consoleInput[0];
            String country = consoleInput[1];
            int population = Integer.parseInt(consoleInput[2]);

            countries.putIfAbsent(country, new LinkedHashMap<>());
            countries.get(country).putIfAbsent(city, 0);

            int pop = countries.get(country).get(city);
            countries.get(country).put(city, pop + population);

            consoleInput = br.readLine().split("\\|");
        }

        Map<String, Long> countriesPop = new LinkedHashMap<>();

        for (Map.Entry<String, Map<String, Integer>> country : countries.entrySet()) {
            long countyPop = country.getValue().values().stream().mapToLong(i -> i).sum();
            countriesPop.put(country.getKey(), countyPop);

        }

        StringBuilder sb = new StringBuilder();

        countriesPop.entrySet()
                .stream()
                .sorted((c1, c2) -> c2.getValue().compareTo(c1.getValue()))
                .forEach(country -> {
                            sb.append(String.format("%s (total population: %d)", country.getKey(), country.getValue()))
                                    .append(System.lineSeparator());

                            countries.get(country.getKey()).entrySet()
                                    .stream()
                                    .sorted((c1, c2) -> c2.getValue().compareTo(c1.getValue()))
                                    .forEach(city -> {
                                        sb.append(String.format("=>%s: %d", city.getKey(), city.getValue()))
                                                .append(System.lineSeparator());
                                    });
                        }
                );
        System.out.println(sb.toString().trim());
    }
}
