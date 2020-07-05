package SetsAndMapsAdvanced.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SrabskoUnleashed_13 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Map<String, Long>> venues = new LinkedHashMap<>();

        String input = br.readLine().trim();


        while (!input.equals("End")) {
            String[] validInput = extractValidInput(input);

            if (validInput != null) {
                String singer = validInput[0];
                String venue = validInput[1];
                long income = Long.parseLong(validInput[2]) * Long.parseLong(validInput[3]);

                venues.putIfAbsent(venue, new LinkedHashMap<>());
                venues.get(venue).putIfAbsent(singer, 0L);

                Long money = venues.get(venue).get(singer);
                venues.get(venue).put(singer, money + income);
            }

            input = br.readLine();
        }

        System.out.println(getVenuesToString(venues));

    }

    private static String getVenuesToString(Map<String, Map<String, Long>> venues) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Map<String, Long>> venue : venues.entrySet()) {
            sb.append(venue.getKey()).append(System.lineSeparator());

            venue.getValue().entrySet().stream().sorted((c1, c2) -> c2.getValue().compareTo(c1.getValue())).forEach(x -> {
                sb.append(String.format("#  %s -> %d", x.getKey(), x.getValue())).append(System.lineSeparator());
            });
        }
        return sb.toString().trim();
    }


    private static String[] extractValidInput(String input) {
        final String regex = "^(?<singer>[A-Za-z]+(\\s[A-Za-z]+)*)\\s@(?<town>[A-Za-z]+(\\s[A-Za-z]+)*)\\s(?<price>\\d+)\\s(?<tickets>\\d+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        return matcher.find() ?
                new String[]{
                        matcher.group("singer"),
                        matcher.group("town"),
                        matcher.group("price"),
                        matcher.group("tickets")
                } : null;
    }
}
