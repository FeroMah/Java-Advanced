package DefiningClasses.Lab.BankAccount_03;

class BankAccount {
    private final static double DEFAULT_INTEREST_RATE = 0.02;
    private static double interestRate = DEFAULT_INTEREST_RATE;
    private static int bankAccount = 1;
    private int id;


    private double balance;

    int getId() {
        return id;
    }

    BankAccount() {
        this.id = bankAccount++;
    }

    static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;
    }

    void deposit(double amount) {
        this.balance += amount;
    }

    double getInterest(int years) {
        return BankAccount.interestRate * years * this.balance;
    }
}
