package se.iths.fredrik.simplebankapplabb.exception;

public class MaxWithdrawExceededException extends RuntimeException{
    public MaxWithdrawExceededException(String message) {
        super(message);
    }
}
