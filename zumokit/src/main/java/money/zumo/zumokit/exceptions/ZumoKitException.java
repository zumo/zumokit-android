package money.zumo.zumokit.exceptions;

public class ZumoKitException extends RuntimeException {
    private final String errorName;

    public ZumoKitException(String errorName, String errorMessage) {
        super(errorMessage);
        this.errorName = errorName;
    }

    public String getName() {
        return this.errorName;
    }
}
