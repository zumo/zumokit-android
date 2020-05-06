// AUTOGENERATED FILE - DO NOT MODIFY!
// This file generated by Djinni from state.djinni

package money.zumo.zumokit;

public final class Exchange {


    /*package*/ final String mId;

    /*package*/ final String mStatus;

    /*package*/ final String mDepositCurrency;

    /*package*/ final String mDepositAccountId;

    /*package*/ final String mDepositTransactionId;

    /*package*/ final String mWithdrawCurrency;

    /*package*/ final String mWithdrawAccountId;

    /*package*/ final String mWithdrawTransactionId;

    /*package*/ final String mAmount;

    /*package*/ final String mDepositFee;

    /*package*/ final String mReturnAmount;

    /*package*/ final String mExchangeFee;

    /*package*/ final String mWithdrawFee;

    /*package*/ final ExchangeRate mExchangeRate;

    /*package*/ final ExchangeFees mExchangeFees;

    /*package*/ final Long mSubmittedAt;

    /*package*/ final Long mConfirmedAt;

    public Exchange(
            String id,
            String status,
            String depositCurrency,
            String depositAccountId,
            String depositTransactionId,
            String withdrawCurrency,
            String withdrawAccountId,
            String withdrawTransactionId,
            String amount,
            String depositFee,
            String returnAmount,
            String exchangeFee,
            String withdrawFee,
            ExchangeRate exchangeRate,
            ExchangeFees exchangeFees,
            Long submittedAt,
            Long confirmedAt) {
        this.mId = id;
        this.mStatus = status;
        this.mDepositCurrency = depositCurrency;
        this.mDepositAccountId = depositAccountId;
        this.mDepositTransactionId = depositTransactionId;
        this.mWithdrawCurrency = withdrawCurrency;
        this.mWithdrawAccountId = withdrawAccountId;
        this.mWithdrawTransactionId = withdrawTransactionId;
        this.mAmount = amount;
        this.mDepositFee = depositFee;
        this.mReturnAmount = returnAmount;
        this.mExchangeFee = exchangeFee;
        this.mWithdrawFee = withdrawFee;
        this.mExchangeRate = exchangeRate;
        this.mExchangeFees = exchangeFees;
        this.mSubmittedAt = submittedAt;
        this.mConfirmedAt = confirmedAt;
    }

    public String getId() {
        return mId;
    }

    public String getStatus() {
        return mStatus;
    }

    public String getDepositCurrency() {
        return mDepositCurrency;
    }

    public String getDepositAccountId() {
        return mDepositAccountId;
    }

    public String getDepositTransactionId() {
        return mDepositTransactionId;
    }

    public String getWithdrawCurrency() {
        return mWithdrawCurrency;
    }

    public String getWithdrawAccountId() {
        return mWithdrawAccountId;
    }

    public String getWithdrawTransactionId() {
        return mWithdrawTransactionId;
    }

    public String getAmount() {
        return mAmount;
    }

    public String getDepositFee() {
        return mDepositFee;
    }

    public String getReturnAmount() {
        return mReturnAmount;
    }

    public String getExchangeFee() {
        return mExchangeFee;
    }

    public String getWithdrawFee() {
        return mWithdrawFee;
    }

    public ExchangeRate getExchangeRate() {
        return mExchangeRate;
    }

    public ExchangeFees getExchangeFees() {
        return mExchangeFees;
    }

    public Long getSubmittedAt() {
        return mSubmittedAt;
    }

    public Long getConfirmedAt() {
        return mConfirmedAt;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Exchange)) {
            return false;
        }
        Exchange other = (Exchange) obj;
        return this.mId.equals(other.mId) &&
                this.mStatus.equals(other.mStatus) &&
                this.mDepositCurrency.equals(other.mDepositCurrency) &&
                this.mDepositAccountId.equals(other.mDepositAccountId) &&
                this.mDepositTransactionId.equals(other.mDepositTransactionId) &&
                this.mWithdrawCurrency.equals(other.mWithdrawCurrency) &&
                this.mWithdrawAccountId.equals(other.mWithdrawAccountId) &&
                ((this.mWithdrawTransactionId == null && other.mWithdrawTransactionId == null) || (this.mWithdrawTransactionId != null && this.mWithdrawTransactionId.equals(other.mWithdrawTransactionId))) &&
                this.mAmount.equals(other.mAmount) &&
                ((this.mDepositFee == null && other.mDepositFee == null) || (this.mDepositFee != null && this.mDepositFee.equals(other.mDepositFee))) &&
                this.mReturnAmount.equals(other.mReturnAmount) &&
                this.mExchangeFee.equals(other.mExchangeFee) &&
                this.mWithdrawFee.equals(other.mWithdrawFee) &&
                this.mExchangeRate.equals(other.mExchangeRate) &&
                this.mExchangeFees.equals(other.mExchangeFees) &&
                ((this.mSubmittedAt == null && other.mSubmittedAt == null) || (this.mSubmittedAt != null && this.mSubmittedAt.equals(other.mSubmittedAt))) &&
                ((this.mConfirmedAt == null && other.mConfirmedAt == null) || (this.mConfirmedAt != null && this.mConfirmedAt.equals(other.mConfirmedAt)));
    }

    @Override
    public int hashCode() {
        // Pick an arbitrary non-zero starting value
        int hashCode = 17;
        hashCode = hashCode * 31 + mId.hashCode();
        hashCode = hashCode * 31 + mStatus.hashCode();
        hashCode = hashCode * 31 + mDepositCurrency.hashCode();
        hashCode = hashCode * 31 + mDepositAccountId.hashCode();
        hashCode = hashCode * 31 + mDepositTransactionId.hashCode();
        hashCode = hashCode * 31 + mWithdrawCurrency.hashCode();
        hashCode = hashCode * 31 + mWithdrawAccountId.hashCode();
        hashCode = hashCode * 31 + (mWithdrawTransactionId == null ? 0 : mWithdrawTransactionId.hashCode());
        hashCode = hashCode * 31 + mAmount.hashCode();
        hashCode = hashCode * 31 + (mDepositFee == null ? 0 : mDepositFee.hashCode());
        hashCode = hashCode * 31 + mReturnAmount.hashCode();
        hashCode = hashCode * 31 + mExchangeFee.hashCode();
        hashCode = hashCode * 31 + mWithdrawFee.hashCode();
        hashCode = hashCode * 31 + mExchangeRate.hashCode();
        hashCode = hashCode * 31 + mExchangeFees.hashCode();
        hashCode = hashCode * 31 + (mSubmittedAt == null ? 0 : mSubmittedAt.hashCode());
        hashCode = hashCode * 31 + (mConfirmedAt == null ? 0 : mConfirmedAt.hashCode());
        return hashCode;
    }

    @Override
    public String toString() {
        return "Exchange{" +
                "mId=" + mId +
                "," + "mStatus=" + mStatus +
                "," + "mDepositCurrency=" + mDepositCurrency +
                "," + "mDepositAccountId=" + mDepositAccountId +
                "," + "mDepositTransactionId=" + mDepositTransactionId +
                "," + "mWithdrawCurrency=" + mWithdrawCurrency +
                "," + "mWithdrawAccountId=" + mWithdrawAccountId +
                "," + "mWithdrawTransactionId=" + mWithdrawTransactionId +
                "," + "mAmount=" + mAmount +
                "," + "mDepositFee=" + mDepositFee +
                "," + "mReturnAmount=" + mReturnAmount +
                "," + "mExchangeFee=" + mExchangeFee +
                "," + "mWithdrawFee=" + mWithdrawFee +
                "," + "mExchangeRate=" + mExchangeRate +
                "," + "mExchangeFees=" + mExchangeFees +
                "," + "mSubmittedAt=" + mSubmittedAt +
                "," + "mConfirmedAt=" + mConfirmedAt +
        "}";
    }

}
