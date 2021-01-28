// AUTOGENERATED FILE - DO NOT MODIFY!
// This file generated by Djinni from records.djinni

package money.zumo.zumokit;

/** Record containing sensitive card details. */
public final class CardDetails {


    /*package*/ final String mPan;

    /*package*/ final String mCvv2;

    /*package*/ final String mExpiry;

    public CardDetails(
            String pan,
            String cvv2,
            String expiry) {
        this.mPan = pan;
        this.mCvv2 = cvv2;
        this.mExpiry = expiry;
    }

    /** Card PAN, e.g 4564 6545 7997 5454. */
    public String getPan() {
        return mPan;
    }

    /** Card CVV2, e.g. 078. */
    public String getCvv2() {
        return mCvv2;
    }

    /** Card year and month of expiry, e.g. 2024-08. */
    public String getExpiry() {
        return mExpiry;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof CardDetails)) {
            return false;
        }
        CardDetails other = (CardDetails) obj;
        return this.mPan.equals(other.mPan) &&
                this.mCvv2.equals(other.mCvv2) &&
                this.mExpiry.equals(other.mExpiry);
    }

    @Override
    public int hashCode() {
        // Pick an arbitrary non-zero starting value
        int hashCode = 17;
        hashCode = hashCode * 31 + mPan.hashCode();
        hashCode = hashCode * 31 + mCvv2.hashCode();
        hashCode = hashCode * 31 + mExpiry.hashCode();
        return hashCode;
    }

    @Override
    public String toString() {
        return "CardDetails{" +
                "mPan=" + mPan +
                "," + "mCvv2=" + mCvv2 +
                "," + "mExpiry=" + mExpiry +
        "}";
    }

}
