// AUTOGENERATED FILE - DO NOT MODIFY!
// This file generated by Djinni from records.djinni

package money.zumo.zumokit;

import java.util.ArrayList;

/** Record containing account data snapshot. */
public final class AccountDataSnapshot {


    /*package*/ final Account mAccount;

    /*package*/ final ArrayList<Transaction> mTransactions;

    public AccountDataSnapshot(
            Account account,
            ArrayList<Transaction> transactions) {
        this.mAccount = account;
        this.mTransactions = transactions;
    }

    /** Account. */
    public Account getAccount() {
        return mAccount;
    }

    /** Account's transactions. */
    public ArrayList<Transaction> getTransactions() {
        return mTransactions;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof AccountDataSnapshot)) {
            return false;
        }
        AccountDataSnapshot other = (AccountDataSnapshot) obj;
        return this.mAccount.equals(other.mAccount) &&
                this.mTransactions.equals(other.mTransactions);
    }

    @Override
    public int hashCode() {
        // Pick an arbitrary non-zero starting value
        int hashCode = 17;
        hashCode = hashCode * 31 + mAccount.hashCode();
        hashCode = hashCode * 31 + mTransactions.hashCode();
        return hashCode;
    }

    @Override
    public String toString() {
        return "AccountDataSnapshot{" +
                "mAccount=" + mAccount +
                "," + "mTransactions=" + mTransactions +
        "}";
    }

}
