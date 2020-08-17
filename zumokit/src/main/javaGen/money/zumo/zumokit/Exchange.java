// AUTOGENERATED FILE - DO NOT MODIFY!
// This file generated by Djinni from state.djinni

package money.zumo.zumokit;

import java.util.HashMap;

/** Record containing exchange details. */
public final class Exchange {


    /*package*/ final String mId;

    /*package*/ final String mStatus;

    /*package*/ final String mDepositCurrency;

    /*package*/ final String mDepositAccountId;

    /*package*/ final String mDepositTransactionId;

    /*package*/ final String mWithdrawCurrency;

    /*package*/ final String mWithdrawAccountId;

    /*package*/ final String mWithdrawTransactionId;

    /*package*/ final java.math.BigDecimal mAmount;

    /*package*/ final java.math.BigDecimal mDepositFee;

    /*package*/ final java.math.BigDecimal mReturnAmount;

    /*package*/ final java.math.BigDecimal mExchangeFee;

    /*package*/ final java.math.BigDecimal mWithdrawFee;

    /*package*/ final ExchangeRate mExchangeRate;

    /*package*/ final ExchangeSettings mExchangeSettings;

    /*package*/ final HashMap<String, HashMap<String, ExchangeRate>> mExchangeRates;

    /*package*/ final String mNonce;

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
            java.math.BigDecimal amount,
            java.math.BigDecimal depositFee,
            java.math.BigDecimal returnAmount,
            java.math.BigDecimal exchangeFee,
            java.math.BigDecimal withdrawFee,
            ExchangeRate exchangeRate,
            ExchangeSettings exchangeSettings,
            HashMap<String, HashMap<String, ExchangeRate>> exchangeRates,
            String nonce,
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
        this.mExchangeSettings = exchangeSettings;
        this.mExchangeRates = exchangeRates;
        this.mNonce = nonce;
        this.mSubmittedAt = submittedAt;
        this.mConfirmedAt = confirmedAt;
    }

    /** Identifier */
    public String getId() {
        return mId;
    }

    /**
     * Exchange status.
     * @see ExchangeStatus
     */
    public String getStatus() {
        return mStatus;
    }

    /**
     * Currency from which exchange was made.
     * @see CurrencyCode
     */
    public String getDepositCurrency() {
        return mDepositCurrency;
    }

    /** Source {@link  Account Account} identifier. */
    public String getDepositAccountId() {
        return mDepositAccountId;
    }

    /** Outgoing {@link  Transaction Transaction} identifier. */
    public String getDepositTransactionId() {
        return mDepositTransactionId;
    }

    /**
     * Currency to which exchange was made.
     * @see CurrencyCode
     */
    public String getWithdrawCurrency() {
        return mWithdrawCurrency;
    }

    /** Target {@link  Account Account} identifier. */
    public String getWithdrawAccountId() {
        return mWithdrawAccountId;
    }

    /** Return {@link  Transaction Transaction} identifier. */
    public String getWithdrawTransactionId() {
        return mWithdrawTransactionId;
    }

    /** Amount in deposit currency. */
    public java.math.BigDecimal getAmount() {
        return mAmount;
    }

    /** Deposit transaction fee. */
    public java.math.BigDecimal getDepositFee() {
        return mDepositFee;
    }

    /**
     * Amount that user receives, calculated as <code>amount X exchangeRate X (1 - feeRate) - withdrawFee</code>.
     * @see ExchangeSettings
     */
    public java.math.BigDecimal getReturnAmount() {
        return mReturnAmount;
    }

    /**
     * Exchange fee, calculated as <code>amount X exchangeRate X feeRate</code>.
     * @see ExchangeSettings
     */
    public java.math.BigDecimal getExchangeFee() {
        return mExchangeFee;
    }

    /**
     * Return transaction fee.
     * @see ExchangeSettings
     */
    public java.math.BigDecimal getWithdrawFee() {
        return mWithdrawFee;
    }

    /** Exchange rate used. */
    public ExchangeRate getExchangeRate() {
        return mExchangeRate;
    }

    /** Exchange settings used. */
    public ExchangeSettings getExchangeSettings() {
        return mExchangeSettings;
    }

    /**
     * Exchange rates at the time exchange was made.
     * This can be used to display amounts in local currency to the user.
     */
    public HashMap<String, HashMap<String, ExchangeRate>> getExchangeRates() {
        return mExchangeRates;
    }

    /** Exchange nonce or null. Used to prevent double spend. */
    public String getNonce() {
        return mNonce;
    }

    /** Epoch timestamp when transaction was submitted. */
    public Long getSubmittedAt() {
        return mSubmittedAt;
    }

    /** Epoch timestamp when transaction was confirmed or null if not yet confirmed. */
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
                ((this.mDepositTransactionId == null && other.mDepositTransactionId == null) || (this.mDepositTransactionId != null && this.mDepositTransactionId.equals(other.mDepositTransactionId))) &&
                this.mWithdrawCurrency.equals(other.mWithdrawCurrency) &&
                this.mWithdrawAccountId.equals(other.mWithdrawAccountId) &&
                ((this.mWithdrawTransactionId == null && other.mWithdrawTransactionId == null) || (this.mWithdrawTransactionId != null && this.mWithdrawTransactionId.equals(other.mWithdrawTransactionId))) &&
                this.mAmount.equals(other.mAmount) &&
                ((this.mDepositFee == null && other.mDepositFee == null) || (this.mDepositFee != null && this.mDepositFee.equals(other.mDepositFee))) &&
                this.mReturnAmount.equals(other.mReturnAmount) &&
                this.mExchangeFee.equals(other.mExchangeFee) &&
                this.mWithdrawFee.equals(other.mWithdrawFee) &&
                this.mExchangeRate.equals(other.mExchangeRate) &&
                this.mExchangeSettings.equals(other.mExchangeSettings) &&
                this.mExchangeRates.equals(other.mExchangeRates) &&
                ((this.mNonce == null && other.mNonce == null) || (this.mNonce != null && this.mNonce.equals(other.mNonce))) &&
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
        hashCode = hashCode * 31 + (mDepositTransactionId == null ? 0 : mDepositTransactionId.hashCode());
        hashCode = hashCode * 31 + mWithdrawCurrency.hashCode();
        hashCode = hashCode * 31 + mWithdrawAccountId.hashCode();
        hashCode = hashCode * 31 + (mWithdrawTransactionId == null ? 0 : mWithdrawTransactionId.hashCode());
        hashCode = hashCode * 31 + (mAmount.hashCode());
        hashCode = hashCode * 31 + (mDepositFee == null ? 0 : mDepositFee.hashCode());
        hashCode = hashCode * 31 + (mReturnAmount.hashCode());
        hashCode = hashCode * 31 + (mExchangeFee.hashCode());
        hashCode = hashCode * 31 + (mWithdrawFee.hashCode());
        hashCode = hashCode * 31 + mExchangeRate.hashCode();
        hashCode = hashCode * 31 + mExchangeSettings.hashCode();
        hashCode = hashCode * 31 + mExchangeRates.hashCode();
        hashCode = hashCode * 31 + (mNonce == null ? 0 : mNonce.hashCode());
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
                "," + "mExchangeSettings=" + mExchangeSettings +
                "," + "mExchangeRates=" + mExchangeRates +
                "," + "mNonce=" + mNonce +
                "," + "mSubmittedAt=" + mSubmittedAt +
                "," + "mConfirmedAt=" + mConfirmedAt +
        "}";
    }

}
