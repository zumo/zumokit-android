package money.zumo.zumokit.exceptions;

public class APIConnectionException extends ZumoKitException {
    public APIConnectionException(String errorType, String errorCode, String errorMessage) {
        super(errorType, errorCode, errorMessage);
    }
}
