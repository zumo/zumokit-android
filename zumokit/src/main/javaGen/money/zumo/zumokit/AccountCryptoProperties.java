// AUTOGENERATED FILE - DO NOT MODIFY!
// This file generated by Djinni from records.djinni

package money.zumo.zumokit;

/**
 * Record containing account's crypto related properties.
 * @see Account
 */
public final class AccountCryptoProperties {


    /*package*/ final String mAddress;

    /*package*/ final String mDirectDepositAddress;

    /*package*/ final String mPath;

    /*package*/ final Integer mNonce;

    public AccountCryptoProperties(
            String address,
            String directDepositAddress,
            String path,
            Integer nonce) {
        this.mAddress = address;
        this.mDirectDepositAddress = directDepositAddress;
        this.mPath = path;
        this.mNonce = nonce;
    }

    /** Account crypto address. */
    public String getAddress() {
        return mAddress;
    }

    /**
     * Account direct deposit crypto address, only applicable to custody accounts. 
     * Should only be used to deposit funds from Zumo non-custody accounts.
     */
    public String getDirectDepositAddress() {
        return mDirectDepositAddress;
    }

    /** Hierarchical Deterministic (HD) account derivation path. */
    public String getPath() {
        return mPath;
    }

    /** Ethereum account nonce if greater than 0 or null otherwise. */
    public Integer getNonce() {
        return mNonce;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof AccountCryptoProperties)) {
            return false;
        }
        AccountCryptoProperties other = (AccountCryptoProperties) obj;
        return this.mAddress.equals(other.mAddress) &&
                ((this.mDirectDepositAddress == null && other.mDirectDepositAddress == null) || (this.mDirectDepositAddress != null && this.mDirectDepositAddress.equals(other.mDirectDepositAddress))) &&
                ((this.mPath == null && other.mPath == null) || (this.mPath != null && this.mPath.equals(other.mPath))) &&
                ((this.mNonce == null && other.mNonce == null) || (this.mNonce != null && this.mNonce.equals(other.mNonce)));
    }

    @Override
    public int hashCode() {
        // Pick an arbitrary non-zero starting value
        int hashCode = 17;
        hashCode = hashCode * 31 + mAddress.hashCode();
        hashCode = hashCode * 31 + (mDirectDepositAddress == null ? 0 : mDirectDepositAddress.hashCode());
        hashCode = hashCode * 31 + (mPath == null ? 0 : mPath.hashCode());
        hashCode = hashCode * 31 + (mNonce == null ? 0 : mNonce.hashCode());
        return hashCode;
    }

    @Override
    public String toString() {
        return "AccountCryptoProperties{" +
                "mAddress=" + mAddress +
                "," + "mDirectDepositAddress=" + mDirectDepositAddress +
                "," + "mPath=" + mPath +
                "," + "mNonce=" + mNonce +
        "}";
    }

}
