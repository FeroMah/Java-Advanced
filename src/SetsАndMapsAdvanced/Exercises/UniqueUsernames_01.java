package SetsАndMapsAdvanced.Exercises;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueUsernames_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberInputCount= Integer.valueOf(sc.nextLine());
        Set<String > uniqueCollectionOfUsers = new LinkedHashSet<>();
        for (int i = 0; i <numberInputCount ; i++) {
            String inputUserName = sc.nextLine();
            uniqueCollectionOfUsers.add(inputUserName);
        }
        for (String user : uniqueCollectionOfUsers) {
            System.out.println(user);
        }
    }
}
