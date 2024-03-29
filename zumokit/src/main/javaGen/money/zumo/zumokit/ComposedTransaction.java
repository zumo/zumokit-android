// AUTOGENERATED FILE - DO NOT MODIFY!
// This file generated by Djinni from records.djinni

package money.zumo.zumokit;

/**
 * Record containing result of one of the transaction compose methods on {@link  Wallet Wallet} object.
 * @see Wallet
 */
public final class ComposedTransaction {


    /*package*/ final String mType;

    /*package*/ final Account mAccount;

    /*package*/ final String mDestination;

    /*package*/ final java.math.BigDecimal mAmount;

    /*package*/ final java.math.BigDecimal mFee;

    /*package*/ final String mNonce;

    /*package*/ final String mSignedTransaction;

    /*package*/ final String mCustodyOrderId;

    /*package*/ final String mData;

    public ComposedTransaction(
            String type,
            Account account,
            String destination,
            java.math.BigDecimal amount,
            java.math.BigDecimal fee,
            String nonce,
            String signedTransaction,
            String custodyOrderId,
            String data) {
        this.mType = type;
        this.mAccount = account;
        this.mDestination = destination;
        this.mAmount = amount;
        this.mFee = fee;
        this.mNonce = nonce;
        this.mSignedTransaction = signedTransaction;
        this.mCustodyOrderId = custodyOrderId;
        this.mData = data;
    }

    /**
     * Transaction type, 'FIAT', 'CRYPTO', 'NOMINATED' or 'CUSTODY-WITHDRAW'.
     * @see TransactionType
     */
    public String getType() {
        return mType;
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

    /** Maximum transaction fee. */
    public java.math.BigDecimal getFee() {
        return mFee;
    }

    /** Transaction nonce to prevent double spend. */
    public String getNonce() {
        return mNonce;
    }

    /** Signed transaction for a crypto transaction, null otherwise. */
    public String getSignedTransaction() {
        return mSignedTransaction;
    }

    /** Custody order id for custody withdraw transaction, null otherwise. */
    public String getCustodyOrderId() {
        return mCustodyOrderId;
    }

    /** Optional transaction data if available. */
    public String getData() {
        return mData;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ComposedTransaction)) {
            return false;
        }
        ComposedTransaction other = (ComposedTransaction) obj;
        return this.mType.equals(other.mType) &&
                this.mAccount.equals(other.mAccount) &&
                ((this.mDestination == null && other.mDestination == null) || (this.mDestination != null && this.mDestination.equals(other.mDestination))) &&
                ((this.mAmount == null && other.mAmount == null) || (this.mAmount != null && this.mAmount.equals(other.mAmount))) &&
                this.mFee.equals(other.mFee) &&
                this.mNonce.equals(other.mNonce) &&
                ((this.mSignedTransaction == null && other.mSignedTransaction == null) || (this.mSignedTransaction != null && this.mSignedTransaction.equals(other.mSignedTransaction))) &&
                ((this.mCustodyOrderId == null && other.mCustodyOrderId == null) || (this.mCustodyOrderId != null && this.mCustodyOrderId.equals(other.mCustodyOrderId))) &&
                ((this.mData == null && other.mData == null) || (this.mData != null && this.mData.equals(other.mData)));
    }

    @Override
    public int hashCode() {
        // Pick an arbitrary non-zero starting value
        int hashCode = 17;
        hashCode = hashCode * 31 + mType.hashCode();
        hashCode = hashCode * 31 + mAccount.hashCode();
        hashCode = hashCode * 31 + (mDestination == null ? 0 : mDestination.hashCode());
        hashCode = hashCode * 31 + (mAmount == null ? 0 : mAmount.hashCode());
        hashCode = hashCode * 31 + (mFee.hashCode());
        hashCode = hashCode * 31 + mNonce.hashCode();
        hashCode = hashCode * 31 + (mSignedTransaction == null ? 0 : mSignedTransaction.hashCode());
        hashCode = hashCode * 31 + (mCustodyOrderId == null ? 0 : mCustodyOrderId.hashCode());
        hashCode = hashCode * 31 + (mData == null ? 0 : mData.hashCode());
        return hashCode;
    }

    @Override
    public String toString() {
        return "ComposedTransaction{" +
                "mType=" + mType +
                "," + "mAccount=" + mAccount +
                "," + "mDestination=" + mDestination +
                "," + "mAmount=" + mAmount +
                "," + "mFee=" + mFee +
                "," + "mNonce=" + mNonce +
                "," + "mSignedTransaction=" + mSignedTransaction +
                "," + "mCustodyOrderId=" + mCustodyOrderId +
                "," + "mData=" + mData +
        "}";
    }

}
