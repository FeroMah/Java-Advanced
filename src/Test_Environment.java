import java.util.Scanner;

public class Test_Environment {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] arrayTest = sc.nextLine().replace(" ", "").toCharArray();

        for (char symbol : arrayTest) {
            System.out.print(symbol);
        }
    }
}
