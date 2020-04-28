package money.zumo.zumokit.exceptions;

public class WalletException extends ZumoKitException {
    public WalletException(String errorType, String errorCode, String errorMessage) {
        super(errorType, errorCode, errorMessage);
    }
}