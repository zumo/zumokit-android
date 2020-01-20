package money.zumo.zumokit.exceptions;

public class AuthNotFoundException extends RuntimeException {
    public AuthNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
