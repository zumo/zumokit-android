// AUTOGENERATED FILE - DO NOT MODIFY!
// This file generated by Djinni from records.djinni

package money.zumo.zumokit;

/** Record containing result of the compose exchange method on {@link  Wallet Wallet} object. */
public final class ComposedExchange {


    /*package*/ final Account mDebitAccount;

    /*package*/ final Account mCreditAccount;

    /*package*/ final Quote mQuote;

    public ComposedExchange(
            Account debitAccount,
            Account creditAccount,
            Quote quote) {
        this.mDebitAccount = debitAccount;
        this.mCreditAccount = creditAccount;
        this.mQuote = quote;
    }

    /** Debit account. */
    public Account getDebitAccount() {
        return mDebitAccount;
    }

    /** Credit account. */
    public Account getCreditAccount() {
        return mCreditAccount;
    }

    /** Exchange rate quote used when composing exchange. */
    public Quote getQuote() {
        return mQuote;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ComposedExchange)) {
            return false;
        }
        ComposedExchange other = (ComposedExchange) obj;
        return this.mDebitAccount.equals(other.mDebitAccount) &&
                this.mCreditAccount.equals(other.mCreditAccount) &&
                this.mQuote.equals(other.mQuote);
    }

    @Override
    public int hashCode() {
        // Pick an arbitrary non-zero starting value
        int hashCode = 17;
        hashCode = hashCode * 31 + mDebitAccount.hashCode();
        hashCode = hashCode * 31 + mCreditAccount.hashCode();
        hashCode = hashCode * 31 + mQuote.hashCode();
        return hashCode;
    }

    @Override
    public String toString() {
        return "ComposedExchange{" +
                "mDebitAccount=" + mDebitAccount +
                "," + "mCreditAccount=" + mCreditAccount +
                "," + "mQuote=" + mQuote +
        "}";
    }

}
