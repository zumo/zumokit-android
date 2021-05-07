package money.zumo.zumokit.exceptions;

/**
 * An exception indicating that too many requests have hit the API too quickly.
 */
public class RateLimitException extends ZumoKitException {
    public RateLimitException(String errorType, String errorCode, String errorMessage) {
        super(errorType, errorCode, errorMessage);
    }
}