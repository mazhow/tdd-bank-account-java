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
}
