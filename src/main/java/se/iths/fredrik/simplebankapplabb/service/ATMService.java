package se.iths.fredrik.simplebankapplabb.service;

import org.springframework.stereotype.Service;
import se.iths.fredrik.simplebankapplabb.component.AccountComponent;
import se.iths.fredrik.simplebankapplabb.exception.InsufficientFundsException;
import se.iths.fredrik.simplebankapplabb.exception.InvalidAmountException;
import se.iths.fredrik.simplebankapplabb.exception.MaxWithdrawExceededException;

@Service
public class ATMService {
    private final AccountComponent component;
    private static final int MaxWithdrawAmount = 1000;

    public ATMService(AccountComponent component) {
        this.component = component;
    }

    public void deposit(int amount){
        if(amount <= 0){
            throw new InvalidAmountException("Amount must be greater than 0");
        }
        component.deposit(amount);
    }

    public void withdraw(int amount){
        if(amount > MaxWithdrawAmount){
            throw new MaxWithdrawExceededException("Amount must be less than " + MaxWithdrawAmount);
        }
        if(amount <= 0){
            throw new InvalidAmountException("Amount must be greater than 0");
        }
        if(amount > component.getBalance()){
            throw new InsufficientFundsException("Insufficient Funds");
        }
        component.withdraw(amount);
    }

    public int getBalance(){
        return component.getBalance();
    }
}
