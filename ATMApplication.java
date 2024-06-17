package codsoft;

import java.util.Scanner;

//Class to represent the user's bank account
class BankAccount {
 private double balance;

 public BankAccount(double initialBalance) {
     this.balance = initialBalance;
 }

 public double getBalance() {
     return balance;
 }

 public void deposit(double amount) {
     if (amount > 0) {
         balance += amount;
         System.out.println("Deposit successful.");
     } else {
         System.out.println("Invalid deposit amount.");
     }
 }

 public void withdraw(double amount) {
     if (amount > 0 && amount <= balance) {
         balance -= amount;
         System.out.println("Withdrawal successful.");
     } else {
         System.out.println("Insufficient balance or invalid withdrawal amount.");
     }
 }

 public void checkBalance() {
     System.out.println("Current balance: $" + balance);
 }
}

//Class to represent the ATM machine
class ATM {
 private BankAccount account;

 public ATM(BankAccount account) {
     this.account = account;
 }

 public void showMenu() {
     Scanner scanner = new Scanner(System.in);
     int option = 0;

     do {
         System.out.println("\nATM Menu:");
         System.out.println("1. Withdraw");
         System.out.println("2. Deposit");
         System.out.println("3. Check Balance");
         System.out.println("4. Exit");
         System.out.print("Choose an option: ");
         option = scanner.nextInt();

         switch (option) {
             case 1:
                 System.out.print("Enter amount to withdraw: ");
                 double withdrawAmount = scanner.nextDouble();
                 account.withdraw(withdrawAmount);
                 break;
             case 2:
                 System.out.print("Enter amount to deposit: ");
                 double depositAmount = scanner.nextDouble();
                 account.deposit(depositAmount);
                 break;
             case 3:
                 account.checkBalance();
                 break;
             case 4:
                 System.out.println("Exiting. Thank you for using the ATM.");
                 break;
             default:
                 System.out.println("Invalid option. Please try again.");
         }
     } while (option != 4);
     
     scanner.close();
 }
}

//Main class to run the ATM
public class ATMApplication {
 public static void main(String[] args) {
     // Create a bank account with an initial balance
     BankAccount account = new BankAccount(1000.00); // Initial balance is $1000.00

     // Create an ATM instance with the bank account
     ATM atm = new ATM(account);

     // Display the ATM menu
     atm.showMenu();
 }
}
