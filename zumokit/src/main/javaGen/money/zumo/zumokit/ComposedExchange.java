// AUTOGENERATED FILE - DO NOT MODIFY!
// This file generated by Djinni from state.djinni

package money.zumo.zumokit;

public final class ComposedExchange {


    /*package*/ final String mSignedTransaction;

    /*package*/ final Account mDepositAccount;

    /*package*/ final Account mWithdrawAccount;

    /*package*/ final ExchangeRate mExchangeRate;

    /*package*/ final String mExchangeAddress;

    /*package*/ final String mValue;

    /*package*/ final String mReturnValue;

    /*package*/ final String mDepositFee;

    /*package*/ final String mExchangeFee;

    /*package*/ final String mWithdrawFee;

    public ComposedExchange(
            String signedTransaction,
            Account depositAccount,
            Account withdrawAccount,
            ExchangeRate exchangeRate,
            String exchangeAddress,
            String value,
            String returnValue,
            String depositFee,
            String exchangeFee,
            String withdrawFee) {
        this.mSignedTransaction = signedTransaction;
        this.mDepositAccount = depositAccount;
        this.mWithdrawAccount = withdrawAccount;
        this.mExchangeRate = exchangeRate;
        this.mExchangeAddress = exchangeAddress;
        this.mValue = value;
        this.mReturnValue = returnValue;
        this.mDepositFee = depositFee;
        this.mExchangeFee = exchangeFee;
        this.mWithdrawFee = withdrawFee;
    }

    public String getSignedTransaction() {
        return mSignedTransaction;
    }

    public Account getDepositAccount() {
        return mDepositAccount;
    }

    public Account getWithdrawAccount() {
        return mWithdrawAccount;
    }

    public ExchangeRate getExchangeRate() {
        return mExchangeRate;
    }

    public String getExchangeAddress() {
        return mExchangeAddress;
    }

    public String getValue() {
        return mValue;
    }

    public String getReturnValue() {
        return mReturnValue;
    }

    public String getDepositFee() {
        return mDepositFee;
    }

    public String getExchangeFee() {
        return mExchangeFee;
    }

    public String getWithdrawFee() {
        return mWithdrawFee;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ComposedExchange)) {
            return false;
        }
        ComposedExchange other = (ComposedExchange) obj;
        return this.mSignedTransaction.equals(other.mSignedTransaction) &&
                this.mDepositAccount.equals(other.mDepositAccount) &&
                this.mWithdrawAccount.equals(other.mWithdrawAccount) &&
                this.mExchangeRate.equals(other.mExchangeRate) &&
                this.mExchangeAddress.equals(other.mExchangeAddress) &&
                this.mValue.equals(other.mValue) &&
                this.mReturnValue.equals(other.mReturnValue) &&
                this.mDepositFee.equals(other.mDepositFee) &&
                this.mExchangeFee.equals(other.mExchangeFee) &&
                this.mWithdrawFee.equals(other.mWithdrawFee);
    }

    @Override
    public int hashCode() {
        // Pick an arbitrary non-zero starting value
        int hashCode = 17;
        hashCode = hashCode * 31 + mSignedTransaction.hashCode();
        hashCode = hashCode * 31 + mDepositAccount.hashCode();
        hashCode = hashCode * 31 + mWithdrawAccount.hashCode();
        hashCode = hashCode * 31 + mExchangeRate.hashCode();
        hashCode = hashCode * 31 + mExchangeAddress.hashCode();
        hashCode = hashCode * 31 + mValue.hashCode();
        hashCode = hashCode * 31 + mReturnValue.hashCode();
        hashCode = hashCode * 31 + mDepositFee.hashCode();
        hashCode = hashCode * 31 + mExchangeFee.hashCode();
        hashCode = hashCode * 31 + mWithdrawFee.hashCode();
        return hashCode;
    }

    @Override
    public String toString() {
        return "ComposedExchange{" +
                "mSignedTransaction=" + mSignedTransaction +
                "," + "mDepositAccount=" + mDepositAccount +
                "," + "mWithdrawAccount=" + mWithdrawAccount +
                "," + "mExchangeRate=" + mExchangeRate +
                "," + "mExchangeAddress=" + mExchangeAddress +
                "," + "mValue=" + mValue +
                "," + "mReturnValue=" + mReturnValue +
                "," + "mDepositFee=" + mDepositFee +
                "," + "mExchangeFee=" + mExchangeFee +
                "," + "mWithdrawFee=" + mWithdrawFee +
        "}";
    }

}