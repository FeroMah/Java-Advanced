package SetsАndMapsAdvanced.Lab;

import java.util.HashSet;
import java.util.Scanner;

public class SoftUniParty_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashSet<String> guestSet = new HashSet<>();
        String guestListInput;
        while (!"Party".equalsIgnoreCase(guestListInput = sc.nextLine())) {
            if (guestListInput.length() != 8) {
                continue;
            }
            guestSet.add(guestListInput);
        }
        String guestWent;
        while (!"End".equalsIgnoreCase(guestWent=sc.nextLine())){
            guestSet.remove(guestWent);
        }
        System.out.println(guestSet.size());
        guestSet.stream().sorted().forEach(System.out::println);
    }
}
