// AUTOGENERATED FILE - DO NOT MODIFY!
// This file generated by Djinni from records.djinni

package money.zumo.zumokit;

/** Record containing internal transaction details. */
public final class InternalTransaction {


    /*package*/ final String mFromUserId;

    /*package*/ final String mFromUserIntegratorId;

    /*package*/ final String mFromAccountId;

    /*package*/ final String mFromAddress;

    /*package*/ final String mToUserId;

    /*package*/ final String mToUserIntegratorId;

    /*package*/ final String mToAccountId;

    /*package*/ final String mToAddress;

    /*package*/ final java.math.BigDecimal mAmount;

    public InternalTransaction(
            String fromUserId,
            String fromUserIntegratorId,
            String fromAccountId,
            String fromAddress,
            String toUserId,
            String toUserIntegratorId,
            String toAccountId,
            String toAddress,
            java.math.BigDecimal amount) {
        this.mFromUserId = fromUserId;
        this.mFromUserIntegratorId = fromUserIntegratorId;
        this.mFromAccountId = fromAccountId;
        this.mFromAddress = fromAddress;
        this.mToUserId = toUserId;
        this.mToUserIntegratorId = toUserIntegratorId;
        this.mToAccountId = toAccountId;
        this.mToAddress = toAddress;
        this.mAmount = amount;
    }

    /** Sender user id or null if it is external user. */
    public String getFromUserId() {
        return mFromUserId;
    }

    /** Sender user integrator id or null if it is external user. */
    public String getFromUserIntegratorId() {
        return mFromUserIntegratorId;
    }

    /** Sender account id or null if it is external user. */
    public String getFromAccountId() {
        return mFromAccountId;
    }

    /** Sender address. */
    public String getFromAddress() {
        return mFromAddress;
    }

    /** Recipient user id or null if it is external user. */
    public String getToUserId() {
        return mToUserId;
    }

    /** Recipient user integrator id or null if it is external user. */
    public String getToUserIntegratorId() {
        return mToUserIntegratorId;
    }

    /** Recipient account id or null if it is external user. */
    public String getToAccountId() {
        return mToAccountId;
    }

    /** Recipient address. */
    public String getToAddress() {
        return mToAddress;
    }

    /** Transaction amount in transaction currency. */
    public java.math.BigDecimal getAmount() {
        return mAmount;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof InternalTransaction)) {
            return false;
        }
        InternalTransaction other = (InternalTransaction) obj;
        return ((this.mFromUserId == null && other.mFromUserId == null) || (this.mFromUserId != null && this.mFromUserId.equals(other.mFromUserId))) &&
                ((this.mFromUserIntegratorId == null && other.mFromUserIntegratorId == null) || (this.mFromUserIntegratorId != null && this.mFromUserIntegratorId.equals(other.mFromUserIntegratorId))) &&
                ((this.mFromAccountId == null && other.mFromAccountId == null) || (this.mFromAccountId != null && this.mFromAccountId.equals(other.mFromAccountId))) &&
                this.mFromAddress.equals(other.mFromAddress) &&
                ((this.mToUserId == null && other.mToUserId == null) || (this.mToUserId != null && this.mToUserId.equals(other.mToUserId))) &&
                ((this.mToUserIntegratorId == null && other.mToUserIntegratorId == null) || (this.mToUserIntegratorId != null && this.mToUserIntegratorId.equals(other.mToUserIntegratorId))) &&
                ((this.mToAccountId == null && other.mToAccountId == null) || (this.mToAccountId != null && this.mToAccountId.equals(other.mToAccountId))) &&
                this.mToAddress.equals(other.mToAddress) &&
                this.mAmount.equals(other.mAmount);
    }

    @Override
    public int hashCode() {
        // Pick an arbitrary non-zero starting value
        int hashCode = 17;
        hashCode = hashCode * 31 + (mFromUserId == null ? 0 : mFromUserId.hashCode());
        hashCode = hashCode * 31 + (mFromUserIntegratorId == null ? 0 : mFromUserIntegratorId.hashCode());
        hashCode = hashCode * 31 + (mFromAccountId == null ? 0 : mFromAccountId.hashCode());
        hashCode = hashCode * 31 + mFromAddress.hashCode();
        hashCode = hashCode * 31 + (mToUserId == null ? 0 : mToUserId.hashCode());
        hashCode = hashCode * 31 + (mToUserIntegratorId == null ? 0 : mToUserIntegratorId.hashCode());
        hashCode = hashCode * 31 + (mToAccountId == null ? 0 : mToAccountId.hashCode());
        hashCode = hashCode * 31 + mToAddress.hashCode();
        hashCode = hashCode * 31 + (mAmount.hashCode());
        return hashCode;
    }

    @Override
    public String toString() {
        return "InternalTransaction{" +
                "mFromUserId=" + mFromUserId +
                "," + "mFromUserIntegratorId=" + mFromUserIntegratorId +
                "," + "mFromAccountId=" + mFromAccountId +
                "," + "mFromAddress=" + mFromAddress +
                "," + "mToUserId=" + mToUserId +
                "," + "mToUserIntegratorId=" + mToUserIntegratorId +
                "," + "mToAccountId=" + mToAccountId +
                "," + "mToAddress=" + mToAddress +
                "," + "mAmount=" + mAmount +
        "}";
    }

}
