package money.zumo.zumokit.exceptions;

public class AuthenticationException extends ZumoKitException {
    public AuthenticationException(String errorType, String errorCode, String errorMessage) {
        super(errorType, errorCode, errorMessage);
    }
}
