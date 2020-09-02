package money.zumo.zumokit.exceptions;

/**
 * A base class for ZumoKit-related exceptions.
 * <p>
 * RuntimeException extension with error type and error code properties.
 * Refer to <a target="_top" href="https://developers.zumo.money/docs/guides/handling-errors">Handling Errors</a>
 * guide for details on handling errors.
 * */
public class ZumoKitException extends RuntimeException {
    private final String errorType;
    private final String errorCode;

    public ZumoKitException(String errorType, String errorCode, String errorMessage) {
        super(errorMessage);
        this.errorType = errorType;
        this.errorCode = errorCode;
    }

   /**
   * Error type, such as api_connection_error, api_error, wallet_error etc.
   * @see money.zumo.zumokit.ZumoKitErrorType
   */
    public String getErrorType() {
        return this.errorType;
    }

   /**
   * In case an error could be handled programmatically in addition to error type
   * error code is returned.
   * @see money.zumo.zumokit.ZumoKitErrorCode
   */
    public String getErrorCode() {
        return this.errorCode;
    }
}
