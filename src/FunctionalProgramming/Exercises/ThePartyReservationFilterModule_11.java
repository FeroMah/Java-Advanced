package FunctionalProgramming.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ThePartyReservationFilterModule_11 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<String> names = Arrays.stream(br.readLine().split("\\s+"))
                .collect(Collectors.toList());

        List<String> filtersList = new ArrayList<>();

        while (true) {
            String input = br.readLine();

            if ("Print".equals(input.trim())) {
                filtersList.forEach(f -> {
                    String filterType = f.split(";")[0];
                    String param = f.split(";")[1];

                    switch (filterType) {
                        case "Starts with":
                            String[] namesStartsWith = names.stream()
                                    .filter(n -> n.startsWith(param))
                                    .toArray(String[]::new);
                            for (String name : namesStartsWith) {
                                names.remove(name);
                            }
                            break;
                        case "Ends with":
                            String[] namesEndsWith = names.stream()
                                    .filter(n -> n.endsWith(param))
                                    .toArray(String[]::new);
                            for (String name : namesEndsWith) {
                                names.remove(name);
                            }
                            break;
                        case "Length":
                            String[] namesLength = names.stream()
                                    .filter(n -> n.length()==Integer.parseInt(param))
                                    .toArray(String[]::new);
                            for (String name : namesLength) {
                                names.remove(name);
                            }
                            break;

                        case "Contains":
                            String[] namesContains = names.stream()
                                    .filter(n -> n.contains(param))
                                    .toArray(String[]::new);
                            for (String name : namesContains) {
                                names.remove(name);
                            }
                            break;
                    }
                });

                System.out.println(String.join(" ",names));

                return;
            }

            int index = input.indexOf(";");
            String action = input.substring(0, index);
            String filter = input.substring(index + 1);

            switch (action) {
                case "Add filter":
                    filtersList.add(filter);
                    break;

                case "Remove filter":
                    filtersList.remove(filter);
                    break;
            }
        }
    }
}
