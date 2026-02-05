package se.iths.fredrik.simplebankapplabb.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import se.iths.fredrik.simplebankapplabb.component.AccountComponent;
import se.iths.fredrik.simplebankapplabb.exception.InsufficientFundsException;
import se.iths.fredrik.simplebankapplabb.exception.InvalidAmountException;
import se.iths.fredrik.simplebankapplabb.exception.MaxWithdrawExceededException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ATMServiceTest {

    @Mock
    private AccountComponent account;

    @InjectMocks
    private ATMService atmService;

    @Test
    @DisplayName("Deposit throws InvalidAmountException")
    void depositInvalidAmount(){
        assertThrows(InvalidAmountException.class,
                () -> atmService.deposit(0));
    }

    @Test
    @DisplayName("Withdraw throws MaxWithdrawExceededException")
    void  withdrawOverMaxAmount(){
        assertThrows(MaxWithdrawExceededException.class,
                () -> atmService.withdraw(2000));
    }

    @Test
    @DisplayName("Withdraw throws InvalidAmountException")
    void  withdrawInvalidAmount(){
        assertThrows(InvalidAmountException.class,
                () -> atmService.withdraw(0));
    }

    @Test
    @DisplayName("Withdraw Throws InsufficientFundsException")
    void withdrawInsufficientFunds(){
        when(account.getBalance()).thenReturn(100);

        assertThrows(InsufficientFundsException.class,
                () -> atmService.withdraw(200));
    }

    @Test
    @DisplayName("Valid account deposit")
    void validAccountDeposit(){
        atmService.deposit(100);
        verify(account).deposit(100);
    }

    @Test
    @DisplayName("Valid account withdraw")
    void validAccountWithdraw(){
        when(account.getBalance()).thenReturn(100);

        atmService.withdraw(50);

        verify(account).withdraw(50);
    }

    @Test
    @DisplayName("Valid get account balance")
    void getAccountBalance(){
        when(account.getBalance()).thenReturn(100);

        int balance = atmService.getBalance();

        assertEquals(100, balance);
    }
}
