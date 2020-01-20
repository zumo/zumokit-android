package money.zumo.zumokit.exceptions;

public class WalletLimitExceededException extends RuntimeException {
    public WalletLimitExceededException(String errorMessage) {
        super(errorMessage);
    }
}