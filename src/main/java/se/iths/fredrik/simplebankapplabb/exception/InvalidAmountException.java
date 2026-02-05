package se.iths.fredrik.simplebankapplabb.exception;

public class InvalidAmountException extends RuntimeException{
    public InvalidAmountException(String message){
        super(message);
    }
}
