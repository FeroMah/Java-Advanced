package SetsAndMapsAdvanced.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class UserLogs_06 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("\\s+");


        Map<String, Map<String, Integer>> users = new TreeMap<>();
        while (!input[0].equals("end")) {
            String ip = input[0].split("=")[1];
//            String massage = input[1].split("=")[1]; // no use
            String user = input[2].split("=")[1];

            users.putIfAbsent(user, new LinkedHashMap<>());
            users.get(user).putIfAbsent(ip, 0);
            int count = users.get(user).get(ip) + 1;
            users.get(user).put(ip, count);
            input = br.readLine().split("\\s+");
        }

        users.forEach((key1, value1) -> {
            StringBuilder sb = new StringBuilder();

            sb.append(key1).append(":").append(System.lineSeparator());

            value1
                    .forEach((key, value) -> sb.append(key).append(" => ").append(value).append(", "));

            System.out.println(sb.toString().substring(0, sb.length() - 2) + ".");
        });
    }
}
