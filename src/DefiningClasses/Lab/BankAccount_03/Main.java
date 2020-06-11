package DefiningClasses.Lab.BankAccount_03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input;
        List<BankAccount> bankList = new ArrayList<>();
        while (!"End".equalsIgnoreCase(input = sc.nextLine())) {
            String[] consoleInput = input.split("\\s+");
            String command = consoleInput[0];
            switch (command) {
                case "Create":
                    BankAccount bankAccount = new BankAccount();
                    bankList.add(bankAccount);
                    System.out.println(String.format("Account ID%d created", bankAccount.getId()));
                    break;
                case "Deposit":
                    int id = Integer.parseInt(consoleInput[1]);
                    int amount = Integer.parseInt(consoleInput[2]);
                    boolean isUsedID = false;
                    for (BankAccount account : bankList) {
                        if (account.getId() == id) {
                            account.deposit(amount);
                            System.out.println(String.format("Deposited %d to ID%d", amount, id));
                            isUsedID = true;
                        }
                    }
                    if (!isUsedID) {
                        System.out.println("Account does not exist");
                    }
                    break;
                case "SetInterest":
                    double newInterestRate = Double.parseDouble(consoleInput[1]);
                    BankAccount.setInterestRate(newInterestRate);
                    break;
                case "GetInterest":
                    int inputID = Integer.parseInt(consoleInput[1]);
                    int years = Integer.parseInt(consoleInput[2]);
                    boolean notFound = true;
                    for (BankAccount account : bankList) {
                        if (account.getId() == inputID) {
                            System.out.println(String.format("%.2f", account.getInterest(years)));
                            notFound = false;
                        }
                    }
                    if (notFound) System.out.println("Account does not exist");
                    break;
            }
        }
    }
}
