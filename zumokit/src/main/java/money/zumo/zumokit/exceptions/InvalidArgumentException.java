package money.zumo.zumokit.exceptions;

/**
 * An exception indicating that one or more of the arguments failed to validate on client-side,
 * for example when a destination address is invalid.
 * */
public class InvalidArgumentException extends ZumoKitException {
    public InvalidArgumentException(String errorType, String errorCode, String errorMessage) {
        super(errorType, errorCode, errorMessage);
    }
}