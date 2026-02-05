package se.iths.fredrik.simplebankapplabb.exception;

public class InsufficientFundsException extends RuntimeException{
    public InsufficientFundsException(String message) {
        super(message);
    }
}
