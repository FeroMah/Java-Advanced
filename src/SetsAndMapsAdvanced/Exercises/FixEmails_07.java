package SetsAndMapsAdvanced.Exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FixEmails_07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, String> dataMap = new LinkedHashMap<>();
        String inputLine;
        while (!"stop".equalsIgnoreCase(inputLine = sc.nextLine())) {
            String name = inputLine;
            String inputEmail = sc.nextLine();

            if (domainIsAllowed(inputEmail)) {
                dataMap.putIfAbsent(inputEmail, name);
            }
        }
        printAllData(dataMap);
    }

    private static boolean domainIsAllowed(String email) {
        String regex = "^([a-zA-Z]+)@([a-zA-Z]+)\\.(?<domain>[a-z]+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        boolean isAllowed = false;
        if (matcher.find()) {
            if (!matcher.group("domain").equalsIgnoreCase("com") &&
                    !matcher.group("domain").equalsIgnoreCase("us") &&
                    !matcher.group("domain").equalsIgnoreCase("uk")) {
                isAllowed = true;
            }
        }
        return isAllowed;
    }

    private static void printAllData(Map<String, String> dataMap) {
        for (Map.Entry<String, String> user : dataMap.entrySet()) {
            System.out.println(String.format("%s -> %s", user.getValue(), user.getKey()));
        }
    }
}
