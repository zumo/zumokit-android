// AUTOGENERATED FILE - DO NOT MODIFY!
// This file generated by Djinni from state.djinni

package money.zumo.zumokit;

/**
 * Account type, 'STANDARD', 'COMPATIBILITY' or 'SEGWIT'.
 * <p>
 * Only relevant for Bitcoin accounts. All other accounts are 'STANDARD' account type.
 */
public final class AccountType {

    /**
     * Corresponds to standard Ethereum account type and Bitcoin non-segwit account type <a href="https://github.com/bitcoin/bips/blob/master/bip-0044.mediawiki">P2PKH</a>.
     * <p>
     * Standard Bitcoin addresses always begin with 1 on Bitcoin Mainnet and m or n on Bitcoin Testnet.
     */
    public static final String STANDARD = "STANDARD";

    /**
     * Corresponds to compatibilty Bitcoin account <a href="https://github.com/bitcoin/bips/blob/master/bip-0049.mediawiki">P2WPKH-nested-in-P2SH</a>.
     * <p>
     * These addresses always begin with 3 on Bitcoin Mainnet and 2 on Bitcoin Testnet.
     */
    public static final String COMPATIBILITY = "COMPATIBILITY";

    /**
     * Corresponds to Segregated Witness Bitcoin account type <a href="https://github.com/bitcoin/bips/blob/master/bip-0084.mediawiki">P2WPKH</a> and are also reffered to as bech32 addresses.
     * <p>
     * These addresses always begin with bc1 on Bitcoin Mainnet and tb1 on Bitcoin Testnet.
     */
    public static final String SEGWIT = "SEGWIT";


    public AccountType(
            ) {
    }

    @Override
    public String toString() {
        return "AccountType{" +
        "}";
    }

}
