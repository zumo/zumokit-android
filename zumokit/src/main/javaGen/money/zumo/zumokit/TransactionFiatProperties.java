// AUTOGENERATED FILE - DO NOT MODIFY!
// This file generated by Djinni from state.djinni

package money.zumo.zumokit;

public final class TransactionFiatProperties {


    /*package*/ final AccountFiatProperties mFromFiatAccount;

    /*package*/ final AccountFiatProperties mToFiatAccount;

    public TransactionFiatProperties(
            AccountFiatProperties fromFiatAccount,
            AccountFiatProperties toFiatAccount) {
        this.mFromFiatAccount = fromFiatAccount;
        this.mToFiatAccount = toFiatAccount;
    }

    public AccountFiatProperties getFromFiatAccount() {
        return mFromFiatAccount;
    }

    public AccountFiatProperties getToFiatAccount() {
        return mToFiatAccount;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof TransactionFiatProperties)) {
            return false;
        }
        TransactionFiatProperties other = (TransactionFiatProperties) obj;
        return this.mFromFiatAccount.equals(other.mFromFiatAccount) &&
                this.mToFiatAccount.equals(other.mToFiatAccount);
    }

    @Override
    public int hashCode() {
        // Pick an arbitrary non-zero starting value
        int hashCode = 17;
        hashCode = hashCode * 31 + mFromFiatAccount.hashCode();
        hashCode = hashCode * 31 + mToFiatAccount.hashCode();
        return hashCode;
    }

    @Override
    public String toString() {
        return "TransactionFiatProperties{" +
                "mFromFiatAccount=" + mFromFiatAccount +
                "," + "mToFiatAccount=" + mToFiatAccount +
        "}";
    }

}
