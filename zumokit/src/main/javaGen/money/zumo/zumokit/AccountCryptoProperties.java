// AUTOGENERATED FILE - DO NOT MODIFY!
// This file generated by Djinni from records.djinni

package money.zumo.zumokit;

import java.util.ArrayList;

/**
 * Record containing account's crypto related properties.
 * @see Account
 */
public final class AccountCryptoProperties {


    /*package*/ final String mAddress;

    /*package*/ final String mPath;

    /*package*/ final Long mNonce;

    /*package*/ final ArrayList<UnspentOutput> mUtxoPool;

    /*package*/ final byte mVersion;

    public AccountCryptoProperties(
            String address,
            String path,
            Long nonce,
            ArrayList<UnspentOutput> utxoPool,
            byte version) {
        this.mAddress = address;
        this.mPath = path;
        this.mNonce = nonce;
        this.mUtxoPool = utxoPool;
        this.mVersion = version;
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

    public ArrayList<UnspentOutput> getUtxoPool() {
        return mUtxoPool;
    }

    public byte getVersion() {
        return mVersion;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof AccountCryptoProperties)) {
            return false;
        }
        AccountCryptoProperties other = (AccountCryptoProperties) obj;
        return this.mAddress.equals(other.mAddress) &&
                this.mPath.equals(other.mPath) &&
                ((this.mNonce == null && other.mNonce == null) || (this.mNonce != null && this.mNonce.equals(other.mNonce))) &&
                this.mUtxoPool.equals(other.mUtxoPool) &&
                this.mVersion == other.mVersion;
    }

    @Override
    public int hashCode() {
        // Pick an arbitrary non-zero starting value
        int hashCode = 17;
        hashCode = hashCode * 31 + mAddress.hashCode();
        hashCode = hashCode * 31 + mPath.hashCode();
        hashCode = hashCode * 31 + (mNonce == null ? 0 : mNonce.hashCode());
        hashCode = hashCode * 31 + mUtxoPool.hashCode();
        hashCode = hashCode * 31 + mVersion;
        return hashCode;
    }

    @Override
    public String toString() {
        return "AccountCryptoProperties{" +
                "mAddress=" + mAddress +
                "," + "mPath=" + mPath +
                "," + "mNonce=" + mNonce +
                "," + "mUtxoPool=" + mUtxoPool +
                "," + "mVersion=" + mVersion +
        "}";
    }

}
