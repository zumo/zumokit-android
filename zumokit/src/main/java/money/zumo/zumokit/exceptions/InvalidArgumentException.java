package money.zumo.zumokit.exceptions;

public class InvalidArgumentException extends ZumoKitException {
    public InvalidArgumentException(String errorType, String errorCode, String errorMessage) {
        super(errorType, errorCode, errorMessage);
    }
}