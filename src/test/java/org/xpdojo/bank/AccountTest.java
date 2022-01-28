package org.xpdojo.bank;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.xpdojo.bank.Account.emptyAccount;

public class AccountTest {

    @Test
	public void initialAccount_shouldHaveZeroBalance() {
        assertThat(emptyAccount().balance()).isEqualTo(0);
    }

    @Test
    public void depositAnAmount_shouldIncreaseBalanceBySameAmount() {
        Account account = emptyAccount();
        account.deposit(10);
        assertThat(account.balance()).isEqualTo(10);
    }

    @Test
    public void depositMultipleAmounts() {
        Account account = emptyAccount();
        account.deposit(10);
        account.deposit(20);
        assertThat(account.balance()).isEqualTo(30);
    }

    @Test
    public void withdrawAnAmount_shouldDecreaseBalanceBySameAmount() {
        Account account = emptyAccount();
        account.withdraw(10);
        assertThat(account.balance()).isEqualTo(0);
    }

    @Test
    public void cannotWithdraw_ifNotEnoughFunds() {
        Account account = emptyAccount();
        account.deposit(99);
        account.withdraw(100);
        assertThat(account.balance()).isEqualTo(99);
    }

    @Test
    public void cannotWithdrawFromEmptyAccount() {
        Account account = emptyAccount();
        account.withdraw(10);
        assertThat(account.balance()).isEqualTo(0);
    }

    @Test
    public void transferAnAmount_shouldMoveMoneyFromOneAccountToAnother() {
        Account mainAccount = emptyAccount();
        Account savingsAccount = emptyAccount();

        mainAccount.deposit(1000);
        mainAccount.transfer(500,savingsAccount);

        assertThat(mainAccount.balance()).isEqualTo(500);
        assertThat(savingsAccount.balance()).isEqualTo(500);
    }

    @Test
    public void transferAnAmount_OnlyIfFundsAvailable() {
        Account mainAccount = emptyAccount();
        Account savingsAccount = emptyAccount();

        mainAccount.deposit(10);
        mainAccount.transfer(100,savingsAccount);
        assertThat(savingsAccount.balance()).isEqualTo(0);
        assertThat(mainAccount.balance()).isEqualTo(10);
    }
}
