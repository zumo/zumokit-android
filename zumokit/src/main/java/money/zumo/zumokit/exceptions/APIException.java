package money.zumo.zumokit.exceptions;

/**
 * An exception that represents an internal problem with ZumoKit's servers.
 */
public class APIException extends ZumoKitException {
    public APIException(String errorType, String errorCode, String errorMessage) {
        super(errorType, errorCode, errorMessage);
    }
}
