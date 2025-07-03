import java.util.Scanner;

abstract class BankAccount {
    private long accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(long accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public long getAccountNumber() { return accountNumber; }
    public String getHolderName() { return holderName; }
    public double getBalance() { return balance; }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= balance) balance -= amount;
        else System.out.println("Insufficient balance.");
    }

    protected void setBalance(double newBalance) {
        this.balance = newBalance;
    }

    public abstract double calculateInterest();

    public void displayDetails() {
        System.out.println("Account No: " + accountNumber);
        System.out.println("Holder: " + holderName);
        System.out.println("Balance: " + balance);
        System.out.println("Interest: " + calculateInterest());
    }
}

interface Loanable {
    void applyForLoan(double amount);
    boolean calculateLoanEligibility();
}

class SavingsAccount extends BankAccount implements Loanable {
    public SavingsAccount(long accNo, String name, double balance) {
        super(accNo, name, balance);
    }

    public double calculateInterest() {
        return getBalance() * 0.04;
    }

    public void applyForLoan(double amount) {
        System.out.println("Savings Loan Applied: " + amount);
    }

    public boolean calculateLoanEligibility() {
        return getBalance() >= 5000;
    }
}

class CurrentAccount extends BankAccount implements Loanable {
    public CurrentAccount(long accNo, String name, double balance) {
        super(accNo, name, balance);
    }

    public double calculateInterest() {
        return 0;
    }

    public void applyForLoan(double amount) {
        System.out.println("Current Loan Applied: " + amount);
    }

    public boolean calculateLoanEligibility() {
        return getBalance() >= 10000;
    }
}

public class Q4_BankingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount[] accounts = new BankAccount[2];

        System.out.print("Enter Savings Account Number: ");
        long sAcc = sc.nextLong();
        sc.nextLine();
        System.out.print("Enter Holder Name: ");
        String sName = sc.nextLine();
        System.out.print("Enter Balance: ");
        double sBal = sc.nextDouble();
        accounts[0] = new SavingsAccount(sAcc, sName, sBal);

        System.out.print("\nEnter Current Account Number: ");
        long cAcc = sc.nextLong();
        sc.nextLine();
        System.out.print("Enter Holder Name: ");
        String cName = sc.nextLine();
        System.out.print("Enter Balance: ");
        double cBal = sc.nextDouble();
        accounts[1] = new CurrentAccount(cAcc, cName, cBal);

        for (BankAccount acc : accounts) {
            acc.displayDetails();
            if (acc instanceof Loanable) {
                ((Loanable) acc).applyForLoan(10000);
                boolean eligible = ((Loanable) acc).calculateLoanEligibility();
                System.out.println("Loan Eligible: " + eligible);
            }
            System.out.println();
        }
    }
}
