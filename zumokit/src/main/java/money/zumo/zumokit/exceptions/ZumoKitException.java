package money.zumo.zumokit.exceptions;

public class ZumoKitException extends RuntimeException {
    private final String errorType;
    private final String errorCode;

    public ZumoKitException(String errorType, String errorCode, String errorMessage) {
        super(errorMessage);
        this.errorType = errorType;
        this.errorCode = errorCode;
    }

    public String getErrorType() {
        return this.errorType;
    }

    public String getErrorCode() {
        return this.errorCode;
    }
}
