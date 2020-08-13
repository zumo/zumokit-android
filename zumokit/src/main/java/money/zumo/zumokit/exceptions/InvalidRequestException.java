package money.zumo.zumokit.exceptions;

/** An exception indicating that invalid parameters were used in a request. */
public class InvalidRequestException extends ZumoKitException {
    public InvalidRequestException(String errorType, String errorCode, String errorMessage) {
        super(errorType, errorCode, errorMessage);
    }
}