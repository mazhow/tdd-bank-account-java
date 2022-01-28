package org.xpdojo.bank;

public class Account {

    private int balance;

    public static Account emptyAccount() {
        return new Account();
    }

    private Account() {
        balance = 0;
    }

    public int balance() {
        return balance;
    }

    public void deposit(int amount) {
        balance += amount;
    }

    public void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
        }
    }

    public void transfer(int amount, Account savingsAccount) {
        if (balance >= amount) {
            withdraw(amount);
            savingsAccount.deposit(amount);
        }
    }

    public void printBalanceSlip() {
        System.out.println("Balance: " + balance);
    }
}
