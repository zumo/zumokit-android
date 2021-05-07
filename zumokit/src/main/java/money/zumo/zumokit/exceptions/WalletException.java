package money.zumo.zumokit.exceptions;

/**
 * An exception indicating that there is a problem with the wallet used for a request.
 * Wallet errors are the most common type of error you should expect to handle.
 * They result when user's wallet action can't be performed,
 * e.g. balance too low or invalid wallet password are such errors.
 */
public class WalletException extends ZumoKitException {
    public WalletException(String errorType, String errorCode, String errorMessage) {
        super(errorType, errorCode, errorMessage);
    }
}