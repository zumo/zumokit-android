// AUTOGENERATED FILE - DO NOT MODIFY!
// This file generated by Djinni from state.djinni

package money.zumo.zumokit;

import java.util.HashMap;

public final class Transaction {


    /*package*/ final String mId;

    /*package*/ final TransactionType mType;

    /*package*/ final TransactionDirection mDirection;

    /*package*/ final String mTxHash;

    /*package*/ final String mAccountId;

    /*package*/ final String mSymbol;

    /*package*/ final String mCoin;

    /*package*/ final NetworkType mNetwork;

    /*package*/ final Long mNonce;

    /*package*/ final TransactionStatus mStatus;

    /*package*/ final String mFromAddress;

    /*package*/ final String mFromUserId;

    /*package*/ final String mToAddress;

    /*package*/ final String mToUserId;

    /*package*/ final String mValue;

    /*package*/ final HashMap<String, String> mFiatValue;

    /*package*/ final String mData;

    /*package*/ final String mGasPrice;

    /*package*/ final String mGasLimit;

    /*package*/ final String mCost;

    /*package*/ final HashMap<String, String> mFiatCost;

    /*package*/ final Long mSubmittedAt;

    /*package*/ final Long mConfirmedAt;

    /*package*/ final long mTimestamp;

    public Transaction(
            String id,
            TransactionType type,
            TransactionDirection direction,
            String txHash,
            String accountId,
            String symbol,
            String coin,
            NetworkType network,
            Long nonce,
            TransactionStatus status,
            String fromAddress,
            String fromUserId,
            String toAddress,
            String toUserId,
            String value,
            HashMap<String, String> fiatValue,
            String data,
            String gasPrice,
            String gasLimit,
            String cost,
            HashMap<String, String> fiatCost,
            Long submittedAt,
            Long confirmedAt,
            long timestamp) {
        this.mId = id;
        this.mType = type;
        this.mDirection = direction;
        this.mTxHash = txHash;
        this.mAccountId = accountId;
        this.mSymbol = symbol;
        this.mCoin = coin;
        this.mNetwork = network;
        this.mNonce = nonce;
        this.mStatus = status;
        this.mFromAddress = fromAddress;
        this.mFromUserId = fromUserId;
        this.mToAddress = toAddress;
        this.mToUserId = toUserId;
        this.mValue = value;
        this.mFiatValue = fiatValue;
        this.mData = data;
        this.mGasPrice = gasPrice;
        this.mGasLimit = gasLimit;
        this.mCost = cost;
        this.mFiatCost = fiatCost;
        this.mSubmittedAt = submittedAt;
        this.mConfirmedAt = confirmedAt;
        this.mTimestamp = timestamp;
    }

    public String getId() {
        return mId;
    }

    public TransactionType getType() {
        return mType;
    }

    public TransactionDirection getDirection() {
        return mDirection;
    }

    public String getTxHash() {
        return mTxHash;
    }

    public String getAccountId() {
        return mAccountId;
    }

    public String getSymbol() {
        return mSymbol;
    }

    public String getCoin() {
        return mCoin;
    }

    public NetworkType getNetwork() {
        return mNetwork;
    }

    public Long getNonce() {
        return mNonce;
    }

    public TransactionStatus getStatus() {
        return mStatus;
    }

    public String getFromAddress() {
        return mFromAddress;
    }

    public String getFromUserId() {
        return mFromUserId;
    }

    public String getToAddress() {
        return mToAddress;
    }

    public String getToUserId() {
        return mToUserId;
    }

    public String getValue() {
        return mValue;
    }

    public HashMap<String, String> getFiatValue() {
        return mFiatValue;
    }

    public String getData() {
        return mData;
    }

    public String getGasPrice() {
        return mGasPrice;
    }

    public String getGasLimit() {
        return mGasLimit;
    }

    public String getCost() {
        return mCost;
    }

    public HashMap<String, String> getFiatCost() {
        return mFiatCost;
    }

    public Long getSubmittedAt() {
        return mSubmittedAt;
    }

    public Long getConfirmedAt() {
        return mConfirmedAt;
    }

    public long getTimestamp() {
        return mTimestamp;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Transaction)) {
            return false;
        }
        Transaction other = (Transaction) obj;
        return this.mId.equals(other.mId) &&
                this.mType == other.mType &&
                this.mDirection == other.mDirection &&
                ((this.mTxHash == null && other.mTxHash == null) || (this.mTxHash != null && this.mTxHash.equals(other.mTxHash))) &&
                this.mAccountId.equals(other.mAccountId) &&
                ((this.mSymbol == null && other.mSymbol == null) || (this.mSymbol != null && this.mSymbol.equals(other.mSymbol))) &&
                this.mCoin.equals(other.mCoin) &&
                this.mNetwork == other.mNetwork &&
                ((this.mNonce == null && other.mNonce == null) || (this.mNonce != null && this.mNonce.equals(other.mNonce))) &&
                this.mStatus == other.mStatus &&
                this.mFromAddress.equals(other.mFromAddress) &&
                ((this.mFromUserId == null && other.mFromUserId == null) || (this.mFromUserId != null && this.mFromUserId.equals(other.mFromUserId))) &&
                this.mToAddress.equals(other.mToAddress) &&
                ((this.mToUserId == null && other.mToUserId == null) || (this.mToUserId != null && this.mToUserId.equals(other.mToUserId))) &&
                ((this.mValue == null && other.mValue == null) || (this.mValue != null && this.mValue.equals(other.mValue))) &&
                this.mFiatValue.equals(other.mFiatValue) &&
                ((this.mData == null && other.mData == null) || (this.mData != null && this.mData.equals(other.mData))) &&
                ((this.mGasPrice == null && other.mGasPrice == null) || (this.mGasPrice != null && this.mGasPrice.equals(other.mGasPrice))) &&
                ((this.mGasLimit == null && other.mGasLimit == null) || (this.mGasLimit != null && this.mGasLimit.equals(other.mGasLimit))) &&
                this.mCost.equals(other.mCost) &&
                this.mFiatCost.equals(other.mFiatCost) &&
                ((this.mSubmittedAt == null && other.mSubmittedAt == null) || (this.mSubmittedAt != null && this.mSubmittedAt.equals(other.mSubmittedAt))) &&
                ((this.mConfirmedAt == null && other.mConfirmedAt == null) || (this.mConfirmedAt != null && this.mConfirmedAt.equals(other.mConfirmedAt))) &&
                this.mTimestamp == other.mTimestamp;
    }

    @Override
    public int hashCode() {
        // Pick an arbitrary non-zero starting value
        int hashCode = 17;
        hashCode = hashCode * 31 + mId.hashCode();
        hashCode = hashCode * 31 + mType.hashCode();
        hashCode = hashCode * 31 + mDirection.hashCode();
        hashCode = hashCode * 31 + (mTxHash == null ? 0 : mTxHash.hashCode());
        hashCode = hashCode * 31 + mAccountId.hashCode();
        hashCode = hashCode * 31 + (mSymbol == null ? 0 : mSymbol.hashCode());
        hashCode = hashCode * 31 + mCoin.hashCode();
        hashCode = hashCode * 31 + mNetwork.hashCode();
        hashCode = hashCode * 31 + (mNonce == null ? 0 : mNonce.hashCode());
        hashCode = hashCode * 31 + mStatus.hashCode();
        hashCode = hashCode * 31 + mFromAddress.hashCode();
        hashCode = hashCode * 31 + (mFromUserId == null ? 0 : mFromUserId.hashCode());
        hashCode = hashCode * 31 + mToAddress.hashCode();
        hashCode = hashCode * 31 + (mToUserId == null ? 0 : mToUserId.hashCode());
        hashCode = hashCode * 31 + (mValue == null ? 0 : mValue.hashCode());
        hashCode = hashCode * 31 + mFiatValue.hashCode();
        hashCode = hashCode * 31 + (mData == null ? 0 : mData.hashCode());
        hashCode = hashCode * 31 + (mGasPrice == null ? 0 : mGasPrice.hashCode());
        hashCode = hashCode * 31 + (mGasLimit == null ? 0 : mGasLimit.hashCode());
        hashCode = hashCode * 31 + mCost.hashCode();
        hashCode = hashCode * 31 + mFiatCost.hashCode();
        hashCode = hashCode * 31 + (mSubmittedAt == null ? 0 : mSubmittedAt.hashCode());
        hashCode = hashCode * 31 + (mConfirmedAt == null ? 0 : mConfirmedAt.hashCode());
        hashCode = hashCode * 31 + ((int) (mTimestamp ^ (mTimestamp >>> 32)));
        return hashCode;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "mId=" + mId +
                "," + "mType=" + mType +
                "," + "mDirection=" + mDirection +
                "," + "mTxHash=" + mTxHash +
                "," + "mAccountId=" + mAccountId +
                "," + "mSymbol=" + mSymbol +
                "," + "mCoin=" + mCoin +
                "," + "mNetwork=" + mNetwork +
                "," + "mNonce=" + mNonce +
                "," + "mStatus=" + mStatus +
                "," + "mFromAddress=" + mFromAddress +
                "," + "mFromUserId=" + mFromUserId +
                "," + "mToAddress=" + mToAddress +
                "," + "mToUserId=" + mToUserId +
                "," + "mValue=" + mValue +
                "," + "mFiatValue=" + mFiatValue +
                "," + "mData=" + mData +
                "," + "mGasPrice=" + mGasPrice +
                "," + "mGasLimit=" + mGasLimit +
                "," + "mCost=" + mCost +
                "," + "mFiatCost=" + mFiatCost +
                "," + "mSubmittedAt=" + mSubmittedAt +
                "," + "mConfirmedAt=" + mConfirmedAt +
                "," + "mTimestamp=" + mTimestamp +
        "}";
    }

}
