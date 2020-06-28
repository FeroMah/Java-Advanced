package SetsАndMapsAdvanced.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class UserLogs_06 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split("\\s+");
        String userName = extractUserFormInput(input);
        System.out.println(userName);
//        Map<String, String> logs = new HashMap<>();


    }

    private static String extractUserFormInput(String[] input) {
        return input[2].split("=")[1];
    }
}
