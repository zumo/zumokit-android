// AUTOGENERATED FILE - DO NOT MODIFY!
// This file generated by Djinni from enums.djinni

package money.zumo.zumokit;

/**
 * Account custody type, 'CUSTODY' or 'NON-CUSTODY'.
 * <p>
 * Only relevant for crypto accounts. Fiat accounts are always of type 'CUSTODY'.
 */
public final class CustodyType {

    /** Funds on custody accounts are managed by Zumo. User does not need to unlock wallet to manage his funds. */
    public static final String CUSTODY = "CUSTODY";

    /** Funds on non-custody accounts are managed by the end user. User needs to unlock wallet to manage his funds. */
    public static final String NON_CUSTODY = "NON-CUSTODY";


    public CustodyType(
            ) {
    }

    @Override
    public String toString() {
        return "CustodyType{" +
        "}";
    }

}