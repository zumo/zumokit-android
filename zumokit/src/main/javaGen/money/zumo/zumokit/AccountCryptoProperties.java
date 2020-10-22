// AUTOGENERATED FILE - DO NOT MODIFY!
// This file generated by Djinni from records.djinni

package money.zumo.zumokit;

/**
 * Record containing account's crypto related properties.
 * @see Account
 */
public final class AccountCryptoProperties {


    /*package*/ final String mAddress;

    /*package*/ final String mPath;

    /*package*/ final Long mNonce;

    public AccountCryptoProperties(
            String address,
            String path,
            Long nonce) {
        this.mAddress = address;
        this.mPath = path;
        this.mNonce = nonce;
    }

    /** Account crypto address. */
    public String getAddress() {
        return mAddress;
    }

    /** Hierarchical Deterministic (HD) account derivation path. */
    public String getPath() {
        return mPath;
    }

    /** Ethereum account nonce if greater than 0 or null otherwise. */
    public Long getNonce() {
        return mNonce;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof AccountCryptoProperties)) {
            return false;
        }
        AccountCryptoProperties other = (AccountCryptoProperties) obj;
        return this.mAddress.equals(other.mAddress) &&
                this.mPath.equals(other.mPath) &&
                ((this.mNonce == null && other.mNonce == null) || (this.mNonce != null && this.mNonce.equals(other.mNonce)));
    }

    @Override
    public int hashCode() {
        // Pick an arbitrary non-zero starting value
        int hashCode = 17;
        hashCode = hashCode * 31 + mAddress.hashCode();
        hashCode = hashCode * 31 + mPath.hashCode();
        hashCode = hashCode * 31 + (mNonce == null ? 0 : mNonce.hashCode());
        return hashCode;
    }

    @Override
    public String toString() {
        return "AccountCryptoProperties{" +
                "mAddress=" + mAddress +
                "," + "mPath=" + mPath +
                "," + "mNonce=" + mNonce +
        "}";
    }

}
