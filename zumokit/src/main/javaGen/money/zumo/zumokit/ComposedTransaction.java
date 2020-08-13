// AUTOGENERATED FILE - DO NOT MODIFY!
// This file generated by Djinni from state.djinni

package money.zumo.zumokit;

/**
 * Result of one of the transaction compose methods on @link wallet object.
 * @see wallet
 */
public final class ComposedTransaction {


    /*package*/ final String mType;

    /*package*/ final String mSignedTransaction;

    /*package*/ final Account mAccount;

    /*package*/ final String mDestination;

    /*package*/ final java.math.BigDecimal mAmount;

    /*package*/ final String mData;

    /*package*/ final java.math.BigDecimal mFee;

    /*package*/ final String mNonce;

    public ComposedTransaction(
            String type,
            String signedTransaction,
            Account account,
            String destination,
            java.math.BigDecimal amount,
            String data,
            java.math.BigDecimal fee,
            String nonce) {
        this.mType = type;
        this.mSignedTransaction = signedTransaction;
        this.mAccount = account;
        this.mDestination = destination;
        this.mAmount = amount;
        this.mData = data;
        this.mFee = fee;
        this.mNonce = nonce;
    }

    /**
     * Transaction type, 'FIAT', 'CRYPTO' or 'NOMINATED'.
     * @see transaction_type
     */
    public String getType() {
        return mType;
    }

    /** Signed transaction for a crypto transaction, null otherwise. */
    public String getSignedTransaction() {
        return mSignedTransaction;
    }

    /** Account the composed transaction belongs to. */
    public Account getAccount() {
        return mAccount;
    }

    /** Transaction destination, i.e. destination address for crypto transactions or user id for fiat transactions. */
    public String getDestination() {
        return mDestination;
    }

    /** Transaction amount in account currency. */
    public java.math.BigDecimal getAmount() {
        return mAmount;
    }

    /** Optional transaction data if available. */
    public String getData() {
        return mData;
    }

    /** Maximum transaction fee. */
    public java.math.BigDecimal getFee() {
        return mFee;
    }

    /** Transaction nonce to prevent double spend. */
    public String getNonce() {
        return mNonce;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ComposedTransaction)) {
            return false;
        }
        ComposedTransaction other = (ComposedTransaction) obj;
        return this.mType.equals(other.mType) &&
                ((this.mSignedTransaction == null && other.mSignedTransaction == null) || (this.mSignedTransaction != null && this.mSignedTransaction.equals(other.mSignedTransaction))) &&
                this.mAccount.equals(other.mAccount) &&
                ((this.mDestination == null && other.mDestination == null) || (this.mDestination != null && this.mDestination.equals(other.mDestination))) &&
                ((this.mAmount == null && other.mAmount == null) || (this.mAmount != null && this.mAmount.equals(other.mAmount))) &&
                ((this.mData == null && other.mData == null) || (this.mData != null && this.mData.equals(other.mData))) &&
                this.mFee.equals(other.mFee) &&
                this.mNonce.equals(other.mNonce);
    }

    @Override
    public int hashCode() {
        // Pick an arbitrary non-zero starting value
        int hashCode = 17;
        hashCode = hashCode * 31 + mType.hashCode();
        hashCode = hashCode * 31 + (mSignedTransaction == null ? 0 : mSignedTransaction.hashCode());
        hashCode = hashCode * 31 + mAccount.hashCode();
        hashCode = hashCode * 31 + (mDestination == null ? 0 : mDestination.hashCode());
        hashCode = hashCode * 31 + (mAmount == null ? 0 : mAmount.hashCode());
        hashCode = hashCode * 31 + (mData == null ? 0 : mData.hashCode());
        hashCode = hashCode * 31 + (mFee.hashCode());
        hashCode = hashCode * 31 + mNonce.hashCode();
        return hashCode;
    }

    @Override
    public String toString() {
        return "ComposedTransaction{" +
                "mType=" + mType +
                "," + "mSignedTransaction=" + mSignedTransaction +
                "," + "mAccount=" + mAccount +
                "," + "mDestination=" + mDestination +
                "," + "mAmount=" + mAmount +
                "," + "mData=" + mData +
                "," + "mFee=" + mFee +
                "," + "mNonce=" + mNonce +
        "}";
    }

}
