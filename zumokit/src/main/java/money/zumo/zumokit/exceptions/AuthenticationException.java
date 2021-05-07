package money.zumo.zumokit.exceptions;

/**
 * An exception that represents failure to authenticate with ZumoKit's API.
 */
public class AuthenticationException extends ZumoKitException {
    public AuthenticationException(String errorType, String errorCode, String errorMessage) {
        super(errorType, errorCode, errorMessage);
    }
}
