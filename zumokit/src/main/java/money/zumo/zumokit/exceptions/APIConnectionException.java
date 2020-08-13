package money.zumo.zumokit.exceptions;

/** An exception that represents a failure to connect to ZumoKit's API. */
public class APIConnectionException extends ZumoKitException {
    public APIConnectionException(String errorType, String errorCode, String errorMessage) {
        super(errorType, errorCode, errorMessage);
    }
}
