package money.zumo.zumokit.exceptions;

public class APIException extends ZumoKitException {
    public APIException(String errorType, String errorCode, String errorMessage) {
        super(errorType, errorCode, errorMessage);
    }
}
