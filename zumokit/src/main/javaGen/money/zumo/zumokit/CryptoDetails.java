// AUTOGENERATED FILE - DO NOT MODIFY!
// This file generated by Djinni from state.djinni

package money.zumo.zumokit;

import java.util.HashMap;

public final class CryptoDetails {


    /*package*/ final String mTxHash;

    /*package*/ final Long mNonce;

    /*package*/ final String mFromAddress;

    /*package*/ final String mToAddress;

    /*package*/ final String mData;

    /*package*/ final String mGasPrice;

    /*package*/ final String mGasLimit;

    /*package*/ final HashMap<String, String> mFiatAmount;

    /*package*/ final HashMap<String, String> mFiatFee;

    public CryptoDetails(
            String txHash,
            Long nonce,
            String fromAddress,
            String toAddress,
            String data,
            String gasPrice,
            String gasLimit,
            HashMap<String, String> fiatAmount,
            HashMap<String, String> fiatFee) {
        this.mTxHash = txHash;
        this.mNonce = nonce;
        this.mFromAddress = fromAddress;
        this.mToAddress = toAddress;
        this.mData = data;
        this.mGasPrice = gasPrice;
        this.mGasLimit = gasLimit;
        this.mFiatAmount = fiatAmount;
        this.mFiatFee = fiatFee;
    }

    public String getTxHash() {
        return mTxHash;
    }

    public Long getNonce() {
        return mNonce;
    }

    public String getFromAddress() {
        return mFromAddress;
    }

    public String getToAddress() {
        return mToAddress;
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

    public HashMap<String, String> getFiatAmount() {
        return mFiatAmount;
    }

    public HashMap<String, String> getFiatFee() {
        return mFiatFee;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof CryptoDetails)) {
            return false;
        }
        CryptoDetails other = (CryptoDetails) obj;
        return ((this.mTxHash == null && other.mTxHash == null) || (this.mTxHash != null && this.mTxHash.equals(other.mTxHash))) &&
                ((this.mNonce == null && other.mNonce == null) || (this.mNonce != null && this.mNonce.equals(other.mNonce))) &&
                this.mFromAddress.equals(other.mFromAddress) &&
                ((this.mToAddress == null && other.mToAddress == null) || (this.mToAddress != null && this.mToAddress.equals(other.mToAddress))) &&
                ((this.mData == null && other.mData == null) || (this.mData != null && this.mData.equals(other.mData))) &&
                ((this.mGasPrice == null && other.mGasPrice == null) || (this.mGasPrice != null && this.mGasPrice.equals(other.mGasPrice))) &&
                ((this.mGasLimit == null && other.mGasLimit == null) || (this.mGasLimit != null && this.mGasLimit.equals(other.mGasLimit))) &&
                this.mFiatAmount.equals(other.mFiatAmount) &&
                this.mFiatFee.equals(other.mFiatFee);
    }

    @Override
    public int hashCode() {
        // Pick an arbitrary non-zero starting value
        int hashCode = 17;
        hashCode = hashCode * 31 + (mTxHash == null ? 0 : mTxHash.hashCode());
        hashCode = hashCode * 31 + (mNonce == null ? 0 : mNonce.hashCode());
        hashCode = hashCode * 31 + mFromAddress.hashCode();
        hashCode = hashCode * 31 + (mToAddress == null ? 0 : mToAddress.hashCode());
        hashCode = hashCode * 31 + (mData == null ? 0 : mData.hashCode());
        hashCode = hashCode * 31 + (mGasPrice == null ? 0 : mGasPrice.hashCode());
        hashCode = hashCode * 31 + (mGasLimit == null ? 0 : mGasLimit.hashCode());
        hashCode = hashCode * 31 + mFiatAmount.hashCode();
        hashCode = hashCode * 31 + mFiatFee.hashCode();
        return hashCode;
    }

    @Override
    public String toString() {
        return "CryptoDetails{" +
                "mTxHash=" + mTxHash +
                "," + "mNonce=" + mNonce +
                "," + "mFromAddress=" + mFromAddress +
                "," + "mToAddress=" + mToAddress +
                "," + "mData=" + mData +
                "," + "mGasPrice=" + mGasPrice +
                "," + "mGasLimit=" + mGasLimit +
                "," + "mFiatAmount=" + mFiatAmount +
                "," + "mFiatFee=" + mFiatFee +
        "}";
    }

}
