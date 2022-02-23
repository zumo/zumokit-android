// AUTOGENERATED FILE - DO NOT MODIFY!
// This file generated by Djinni from records.djinni

package money.zumo.zumokit;

/** Record containing basic card details. */
public final class Card {


    /*package*/ final String mId;

    /*package*/ final String mAccountId;

    /*package*/ final String mCardType;

    /*package*/ final String mCardStatus;

    /*package*/ final int mLimit;

    /*package*/ final String mMaskedPan;

    /*package*/ final String mExpiry;

    /*package*/ final boolean mSca;

    public Card(
            String id,
            String accountId,
            String cardType,
            String cardStatus,
            int limit,
            String maskedPan,
            String expiry,
            boolean sca) {
        this.mId = id;
        this.mAccountId = accountId;
        this.mCardType = cardType;
        this.mCardStatus = cardStatus;
        this.mLimit = limit;
        this.mMaskedPan = maskedPan;
        this.mExpiry = expiry;
        this.mSca = sca;
    }

    /** Unique card identifier. */
    public String getId() {
        return mId;
    }

    /** Associated account's identifier. */
    public String getAccountId() {
        return mAccountId;
    }

    /**
     * Card type.
     * @see CardType.
     */
    public String getCardType() {
        return mCardType;
    }

    /**
     * Current card status.
     * @see CardStatus
     */
    public String getCardStatus() {
        return mCardStatus;
    }

    /** Current card limit. */
    public int getLimit() {
        return mLimit;
    }

    /** Card masked pan, e.g **** **** **** 5454. */
    public String getMaskedPan() {
        return mMaskedPan;
    }

    /** Card year and month of expiry, e.g. 2024-08. */
    public String getExpiry() {
        return mExpiry;
    }

    /** Boolean indicating if card is SCA compliant. */
    public boolean getSca() {
        return mSca;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Card)) {
            return false;
        }
        Card other = (Card) obj;
        return this.mId.equals(other.mId) &&
                this.mAccountId.equals(other.mAccountId) &&
                this.mCardType.equals(other.mCardType) &&
                this.mCardStatus.equals(other.mCardStatus) &&
                this.mLimit == other.mLimit &&
                this.mMaskedPan.equals(other.mMaskedPan) &&
                this.mExpiry.equals(other.mExpiry) &&
                this.mSca == other.mSca;
    }

    @Override
    public int hashCode() {
        // Pick an arbitrary non-zero starting value
        int hashCode = 17;
        hashCode = hashCode * 31 + mId.hashCode();
        hashCode = hashCode * 31 + mAccountId.hashCode();
        hashCode = hashCode * 31 + mCardType.hashCode();
        hashCode = hashCode * 31 + mCardStatus.hashCode();
        hashCode = hashCode * 31 + mLimit;
        hashCode = hashCode * 31 + mMaskedPan.hashCode();
        hashCode = hashCode * 31 + mExpiry.hashCode();
        hashCode = hashCode * 31 + (mSca ? 1 : 0);
        return hashCode;
    }

    @Override
    public String toString() {
        return "Card{" +
                "mId=" + mId +
                "," + "mAccountId=" + mAccountId +
                "," + "mCardType=" + mCardType +
                "," + "mCardStatus=" + mCardStatus +
                "," + "mLimit=" + mLimit +
                "," + "mMaskedPan=" + mMaskedPan +
                "," + "mExpiry=" + mExpiry +
                "," + "mSca=" + mSca +
        "}";
    }

}
