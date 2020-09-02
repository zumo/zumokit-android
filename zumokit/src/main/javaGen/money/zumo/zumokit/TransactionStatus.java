// AUTOGENERATED FILE - DO NOT MODIFY!
// This file generated by Djinni from state.djinni

package money.zumo.zumokit;

/**
 * Transaction status, such as 'PENDING' and 'CONFIRMED'.
 * <p>
 * Once transaction is submitted it has to be confirmed. This might take variable amount of time depending on the selected fee rate.
 * Once a transaction is confirmed its status will change from pending to confirmed.
 * <p>
 * See <a target="_top" href="https://developers.zumo.money/docs/guides/send-transactions#transaction-statuses">Send Transactions</a> guide for details.
 */
public final class TransactionStatus {

    /** Transaction has been paused by Transaction Service before being submitted to blockchain. */
    public static final String PAUSED = "PAUSED";

    /** Transaction has been rejected by Transaction Service before being submitted to blockchain. */
    public static final String REJECTED = "REJECTED";

    /** Transaction has been submitted to blockchain. */
    public static final String PENDING = "PENDING";

    /** Transacion was confirmed and added to blockchain. */
    public static final String CONFIRMED = "CONFIRMED";

    /** Transaction failed. */
    public static final String FAILED = "FAILED";

    /** Ethereum transaction was overriden by sending the same transaction with higher gas price. */
    public static final String RESUBMITTED = "RESUBMITTED";

    /**
     * Ethereum transaction was overriden by a different transaction with higher gas price than the previously
     * submitted transaction and with with the same nonce as that previously submitted transaction.
     */
    public static final String CANCELLED = "CANCELLED";


    public TransactionStatus(
            ) {
    }

    @Override
    public String toString() {
        return "TransactionStatus{" +
        "}";
    }

}
