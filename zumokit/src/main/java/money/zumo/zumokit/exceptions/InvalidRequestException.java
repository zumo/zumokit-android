package money.zumo.zumokit.exceptions;

public class InvalidRequestException extends ZumoKitException {
    public InvalidRequestException(String errorType, String errorCode, String errorMessage) {
        super(errorType, errorCode, errorMessage);
    }
}