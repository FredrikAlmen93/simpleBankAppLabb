package se.iths.fredrik.simplebankapplabb.component;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountComponentTest {
    private AccountComponent account;

    @BeforeEach
    void setUp(){
        account = new AccountComponent();
    }

    @Test
    @DisplayName("Balance is zero from creation")
    void zeroBalance(){
        assertEquals(0,account.getBalance());
    }

    @Test
    @DisplayName("Deposit increases balance amount")
    void depositAmount(){
        account.deposit(10);
        assertEquals(10,account.getBalance());
    }

    @Test
    @DisplayName("Withdraw decreases balance amount")
    void  withdrawAmount(){
        account.deposit(50);
        account.withdraw(10);
        assertEquals(40,account.getBalance());
    }

    @Test
    @DisplayName("Withdraw and deposit in same test")
    void withdrawAndDeposit(){
        account.deposit(50);
        account.withdraw(30);
        account.deposit(10);
        assertEquals(30,account.getBalance());
    }
}
