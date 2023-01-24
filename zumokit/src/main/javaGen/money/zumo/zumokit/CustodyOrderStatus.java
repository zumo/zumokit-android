// AUTOGENERATED FILE - DO NOT MODIFY!
// This file generated by Djinni from enums.djinni

package money.zumo.zumokit;

/** Custody order status, for example 'PENDING'. */
public final class CustodyOrderStatus {

    /** Custody order has been created and is awaiting command to be executed. */
    public static final String NEW = "NEW";

    /** Custody order has been submitted to blockchain. */
    public static final String PENDING = "PENDING";

    /** Custody order was confirmed and added to blockchain. */
    public static final String CONFIRMED = "CONFIRMED";

    /** Custody order failed. */
    public static final String FAILED = "FAILED";


    public CustodyOrderStatus(
            ) {
    }

    @Override
    public String toString() {
        return "CustodyOrderStatus{" +
        "}";
    }

}