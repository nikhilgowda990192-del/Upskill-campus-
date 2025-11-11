/* 
 * Title : Banking Information System
 * Language : Java
 * Description : A simple console-based banking information system 
 *               that allows users to create accounts, deposit, withdraw,
 *               transfer funds, and view balances.
 * Author : Arjun
 */

import java.util.*;

class Account {
    private String accountNumber;
    private String holderName;
    private double balance;

    public Account(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient funds or invalid amount!");
        }
    }

    public void transfer(Account receiver, double amount) {
        if (amount > 0 && amount <= balance) {
            this.balance -= amount;
            receiver.balance += amount;
            System.out.println("Transferred " + amount + " to " + receiver.getHolderName());
        } else {
            System.out.println("Transfer failed. Check your balance or amount!");
        }
    }

    public void displayAccountInfo() {
        System.out.println("-----------------------------------");
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Account Holder : " + holderName);
        System.out.println("Current Balance: " + balance);
        System.out.println("-----------------------------------");
    }
}

public class BankingInformationSystem {
    private static Map<String, Account> accounts = new HashMap<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n====== BANKING INFORMATION SYSTEM ======");
            System.out.println("1. Create Account");
            System.out.println("2. View Account");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Transfer");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    viewAccount();
                    break;
                case 3:
                    depositMoney();
                    break;
                case 4:
                    withdrawMoney();
                    break;
                case 5:
                    transferMoney();
                    break;
                case 6:
                    System.out.println("Thank you for using the Banking System!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again!");
            }
        } while (choice != 6);
    }

    private static void createAccount() {
        System.out.print("Enter Account Number: ");
        String accNo = sc.nextLine();
        System.out.print("Enter Holder Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Initial Deposit: ");
        double deposit = sc.nextDouble();
        Account account = new Account(accNo, name, deposit);
        accounts.put(accNo, account);
        System.out.println("Account created successfully!");
    }

    private static void viewAccount() {
        System.out.print("Enter Account Number: ");
        String accNo = sc.nextLine();
        Account acc = accounts.get(accNo);
        if (acc != null) {
            acc.displayAccountInfo();
        } else {
            System.out.println("Account not found!");
        }
    }

    private static void depositMoney() {
        System.out.print("Enter Account Number: ");
        String accNo = sc.nextLine();
        Account acc = accounts.get(accNo);
        if (acc != null) {
            System.out.print("Enter amount to deposit: ");
            double amt = sc.nextDouble();
            acc.deposit(amt);
        } else {
            System.out.println("Account not found!");
        }
    }

    private static void withdrawMoney() {
        System.out.print("Enter Account Number: ");
        String accNo = sc.nextLine();
        Account acc = accounts.get(accNo);
        if (acc != null) {
            System.out.print("Enter amount to withdraw: ");
            double amt = sc.nextDouble();
            acc.withdraw(amt);
        } else {
            System.out.println("Account not found!");
        }
    }

    private static void transferMoney() {
        System.out.print("Enter Sender Account Number: ");
        String fromAcc = sc.nextLine();
        System.out.print("Enter Receiver Account Number: ");
        String toAcc = sc.nextLine();
        Account sender = accounts.get(fromAcc);
        Account receiver = accounts.get(toAcc);

        if (sender != null && receiver != null) {
            System.out.print("Enter amount to transfer: ");
            double amt = sc.nextDouble();
            sender.transfer(receiver, amt);
        } else {
            System.out.println("Invalid account numbers!");
        }
    }
}
