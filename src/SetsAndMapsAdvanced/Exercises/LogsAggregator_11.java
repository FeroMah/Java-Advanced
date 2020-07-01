package SetsAndMapsAdvanced.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class LogsAggregator_11 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cycles = Integer.parseInt(br.readLine());

        Map<String, Integer> users_durations = new TreeMap<>();
        Map<String, Set<String>> users_addresses = new HashMap<>();

        while (cycles != 0) {
            List<String> input = Arrays.stream(br.readLine().split("\\s+")).collect(Collectors.toList());
            String ip = input.get(0);
            String user = input.get(1);
            int duration = Integer.parseInt(input.get(2));

            users_durations.putIfAbsent(user, 0);
            users_durations.put(user, users_durations.get(user) + duration);

            users_addresses.putIfAbsent(user, new TreeSet<>());
            users_addresses.get(user).add(ip);

            cycles--;
        }

        StringBuilder sb = new StringBuilder();
        users_durations.entrySet()
                .forEach(u -> {

                    sb.append(String.format("%s: %d %s",
                            u.getKey(),
                            u.getValue(),
                            users_addresses.get(u.getKey()).toString()
                    )).append(System.lineSeparator());
                });
        System.out.println(sb.toString());
    }
}
