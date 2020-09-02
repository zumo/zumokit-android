// AUTOGENERATED FILE - DO NOT MODIFY!
// This file generated by Djinni from state.djinni

package money.zumo.zumokit;

/**
 * Exchange status, such as 'PENDING', 'DEPOSITED' and 'CONFIRMED'.
 * <p>
 * Once exchange is submitted it has to be confirmed. Once exchange is confirmed its status will change from pending to confirmed.
 * <p>
 * See <a target="_top" href="https://developers.zumo.money/docs/guides/make-exchanges#exchange-statuses">Make Exchanges</a> guide for details.
 */
public final class ExchangeStatus {

    /** Exchange has been paused by Transaction Service before being submitted to blockchain. */
    public static final String PAUSED = "PAUSED";

    /** Exchange has been rejected by Transaction Service before being submitted to blockchain. */
    public static final String REJECTED = "REJECTED";

    /** Deposit transaction has been submitted to blockchain. */
    public static final String PENDING = "PENDING";

    /** Deposit transaction has been mined and exchange has been initiated. */
    public static final String DEPOSITED = "DEPOSITED";

    /** Exchange was confirmed. */
    public static final String CONFIRMED = "CONFIRMED";

    /** Exchange has failed. */
    public static final String FAILED = "FAILED";

    /** Ethereum deposit transaction was overriden by sending the same transaction with higher gas price. */
    public static final String RESUBMITTED = "RESUBMITTED";

    /**
     * Ethereum deposit transaction was overriden by a different transaction with higher gas price than
     * the previously submitted transaction and with with the same nonce as that previously submitted transaction.
     */
    public static final String CANCELLED = "CANCELLED";


    public ExchangeStatus(
            ) {
    }

    @Override
    public String toString() {
        return "ExchangeStatus{" +
        "}";
    }

}
