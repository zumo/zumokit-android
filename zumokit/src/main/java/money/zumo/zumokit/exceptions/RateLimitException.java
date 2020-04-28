package money.zumo.zumokit.exceptions;

public class RateLimitException extends ZumoKitException {
    public RateLimitException(String errorType, String errorCode, String errorMessage) {
        super(errorType, errorCode, errorMessage);
    }
}