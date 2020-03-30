package money.zumo.zumokit.exceptions;

public class InvalidPasswordException extends RuntimeException {
    public InvalidPasswordException(String errorMessage) {
        super(errorMessage);
    }
}